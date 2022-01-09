package com.analyzegithubusers.service.user;

import com.analyzegithubusers.service.github.GitHubClient;
import com.analyzegithubusers.service.user.mapper.UserMapper;
import com.analyzegithubusers.service.user.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@AllArgsConstructor
public class UserProviderImpl implements UserProvider {
    private final GitHubClient gitHubClient;

    @Override
    public Flux<User> getAllUsers(String perPage, String since) {
        return gitHubClient.getAllUsers(perPage, since)
                .map(UserMapper::toUser)
                .flatMap(user -> gitHubClient.getUser(user.getLogin())
                        .map(UserMapper::toUserDetails)
                        .map(userDetails -> {
                            user.setUserDetails(userDetails);
                            return user;
                        }));
    }

}
