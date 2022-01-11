package com.analyzegithubusers.service.user.impl;

import com.analyzegithubusers.model.User;
import com.analyzegithubusers.persistence.UserDAO;
import com.analyzegithubusers.service.user.IUserGroupService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.GroupedFlux;

@AllArgsConstructor
@Service
class UserGroupService implements IUserGroupService {
    private final UserDAO userDAO;

    public Flux<GroupedFlux<String, User>> getUsersGroupedByCompany() {
        return userDAO.findAll()
                .map(u -> {
                    if (u.getUserDetails().getCompany() == null){
                        u.getUserDetails().setCompany("N/A");
                    }
                    return u;
                })
                .groupBy(u -> u.getUserDetails().getCompany());
    }

    public Flux<GroupedFlux<String, User>> getUsersGroupedByLocation() {
        return userDAO.findAll()
                .map(u -> {
                    if (u.getUserDetails().getLocation() == null){
                        u.getUserDetails().setLocation("N/A");
                    }
                    return u;
                })
                .groupBy(u -> u.getUserDetails().getLocation());
    }

}
