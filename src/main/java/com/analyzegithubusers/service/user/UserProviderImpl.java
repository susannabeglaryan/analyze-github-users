package com.analyzegithubusers.service.user;

import com.analyzegithubusers.service.github.GitHubClient;
import com.analyzegithubusers.service.user.mapper.UserMapper;
import com.analyzegithubusers.service.user.model.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@AllArgsConstructor
@Slf4j
public class UserProviderImpl implements UserProvider {
    private final GitHubClient gitHubClient;

    @Override
    public Flux<User> getAllUsers() {
        final int countPer = 100;
        Flux<User> result = Flux.empty();
        for (int i = 0; i < 10; i++) {
            var chunk = gitHubClient.getAllUsers(countPer, i + i * countPer)
                    .map(UserMapper::toUser)
                    .flatMap(user -> gitHubClient.getUser(user.getLogin())
                            .onErrorContinue((err, o) -> log.warn(err.getMessage(), o))
                            .map(UserMapper::toUserDetails)
                            .map(userDetails -> {
                                user.setUserDetails(userDetails);
                                return user;
                            })).onErrorContinue((err, o) -> log.warn(err.getMessage(), o));
            result = Flux.concat(result, chunk);
        }
        return result;
    }

}
