package com.analyzegithubusers.service.user;

import com.analyzegithubusers.model.User;
import com.analyzegithubusers.persistence.UserReactiveDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.GroupedFlux;

@AllArgsConstructor
@Service
class UserGroupService implements IUserGroupService {
    private final UserReactiveDAO userReactiveDAO;

    public Flux<GroupedFlux<String, User>> getUsersGroupedByCompany() {
        return userReactiveDAO.findAll()
                .groupBy(u -> u.getUserDetails().getCompany());
    }

    public Flux<GroupedFlux<String, User>> getUsersGroupedByLocation() {
        return userReactiveDAO.findAll()
                .groupBy(u -> u.getUserDetails().getLocation());
    }

}
