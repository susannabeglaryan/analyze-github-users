package com.analyzegithubusers.service.user;

import com.analyzegithubusers.service.user.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@AllArgsConstructor
@Component
public class UserService {
    UserProvider userProvider;

    public Flux<User> getAllUsers(String perPage, String since) {
        userProvider.getAllUsers(perPage, since).subscribe((user) -> {
            var a = user.getUserDetails();
            System.out.println(a.getName());
        });
        try
        {
            Thread.sleep(6000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        return null;
    }

}
