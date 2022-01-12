package com.analyzegithubusers.service.user.impl;

import com.analyzegithubusers.model.User;
import com.analyzegithubusers.persistence.UserDAO;
import com.analyzegithubusers.service.user.IUserProvider;
import com.analyzegithubusers.service.user.IUserService;
import com.analyzegithubusers.service.user.UserSavingFilter;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.time.Month;

@Service
class UserService implements IUserService {
    private final IUserProvider userProvider;
    private final UserDAO userDAO;

    public UserService(IUserProvider userProvider, UserDAO userDAO) {
        this.userProvider = userProvider;
        this.userDAO = userDAO;
    }

    @Override
    public void saveUsers() {
        UserSavingFilter userFilter = new UserSavingFilter();
        userFilter.setPublicReposMoreThan(5);
        userFilter.setFollowersMoreThan(10);
        userFilter.setProfileCreatedAfter(LocalDateTime.of(2007, Month.APRIL, 1, 12, 30));
        var users = userProvider.getAllUsers(userFilter);
        userDAO.saveAll(users)
                .onErrorContinue((err, u) -> System.out.println(err.getMessage()))
                .subscribe(u -> System.out.println(u.getEmail()));
    }

    @Override
    public Flux<User> getPagedUsers(String login, String company, String location, Pageable pageable) {
        return userDAO.findAll(login, company, location, pageable);
    }
}
