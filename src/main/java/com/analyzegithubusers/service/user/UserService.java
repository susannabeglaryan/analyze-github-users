package com.analyzegithubusers.service.user;

import com.analyzegithubusers.service.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.time.Month;

@AllArgsConstructor
@Component
public class UserService {
    UserProvider userProvider;

    public Flux<User> saveUsers() {
        UserSavingFilter userFilter = new UserSavingFilter();
        userFilter.setPublicReposMoreThan(5);
        userFilter.setFollowersMoreThan(10);
        userFilter.setProfileCreatedAfter(LocalDateTime.of(2010, Month.APRIL, 1, 12, 30));
        userProvider.getAllUsers(userFilter).subscribe((user) -> {
            //TODO Save user
            var a = user.getUserDetails();
            System.out.println(user.getId() + ": " + a.getName());
        });
        return null;
    }

}
