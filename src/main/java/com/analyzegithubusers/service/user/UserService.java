package com.analyzegithubusers.service.user;

import com.analyzegithubusers.persistence.UserDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.Month;

@AllArgsConstructor
@Component
public class UserService {
    UserProvider userProvider;
    UserDAO userDAO;

    public void saveUsers() {
        UserSavingFilter userFilter = new UserSavingFilter();
        userFilter.setPublicReposMoreThan(5);
        userFilter.setFollowersMoreThan(10);
        userFilter.setProfileCreatedAfter(LocalDateTime.of(2007, Month.APRIL, 1, 12, 30));

        userProvider.getAllUsers(userFilter).subscribe((user) -> {
            var savedUser =userDAO.save(user);
            System.out.println(savedUser.getId() + ": " + savedUser.getUserDetails().getName());
        });
    }
}
