package com.analyzegithubusers.service.user;

import com.analyzegithubusers.service.user.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@AllArgsConstructor
@Component
public class UserService {
    UserProvider userProvider;

    public Flux<User> saveUsers() {
        userProvider.getAllUsers().subscribe((user) -> {
            //TODO Save user
            var a = user.getUserDetails();
            System.out.println(a.getName());
        });
        return null;
    }

}
