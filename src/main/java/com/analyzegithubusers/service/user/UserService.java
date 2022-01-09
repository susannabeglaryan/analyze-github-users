package com.analyzegithubusers.service.user;

import com.analyzegithubusers.persistence.UserDAO;
import com.analyzegithubusers.service.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.time.Month;

import static com.analyzegithubusers.service.user.mapper.UserMapper.toUser;
import static com.analyzegithubusers.service.user.mapper.UserMapper.toUserEntity;

@AllArgsConstructor
@Component
public class UserService {
    UserProvider userProvider;
    UserDAO userDAO;

    public Flux<User> saveUsers() {
        UserSavingFilter userFilter = new UserSavingFilter();
        userFilter.setPublicReposMoreThan(5);
        userFilter.setFollowersMoreThan(10);
        userFilter.setProfileCreatedAfter(LocalDateTime.of(2007, Month.APRIL, 1, 12, 30));
        userProvider.getAllUsers(userFilter).subscribe((user) -> {
            //TODO Save user
            var savedUser = toUser(userDAO.save(toUserEntity(user)));
            System.out.println(savedUser.getId() + ": " + savedUser.getUserDetails().getName());
        });
        return null;
    }

}
