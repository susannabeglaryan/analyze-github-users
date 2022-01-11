package com.analyzegithubusers.service.user;

import com.analyzegithubusers.model.User;
import com.analyzegithubusers.persistence.UserDAO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.time.Month;

@Service
public class UserService {
    private final UserProvider userProvider;
    private final UserDAO userDAO;

    public UserService(UserProvider userProvider, UserDAO userDAO) {
        this.userProvider = userProvider;
        this.userDAO = userDAO;
    }

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

    public Flux<User> getPagedUsers(String login, String company, String location, Pageable pageable) {
        return userDAO.findAll(login, company, location, pageable);
    }
}
