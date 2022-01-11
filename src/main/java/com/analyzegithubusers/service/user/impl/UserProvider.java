package com.analyzegithubusers.service.user.impl;

import com.analyzegithubusers.service.github.GitHubClient;
import com.analyzegithubusers.model.User;
import com.analyzegithubusers.service.github.mapper.GithubUserMapper;
import com.analyzegithubusers.service.user.UserFilter;
import com.analyzegithubusers.service.user.IUserProvider;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@AllArgsConstructor
@Slf4j
class UserProvider implements IUserProvider {
    private final GitHubClient gitHubClient;

    @Override
    public Flux<User> getAllUsers(UserFilter userFilter) {
        final int countPerPage = 100;
        Flux<User> result = Flux.empty();
        for (int i = 0; i < 10; i++) {
            var since = i + i * countPerPage;
            var chunk = gitHubClient.getAllUsers(countPerPage, since)
                    .map(GithubUserMapper::toUser)
                    .flatMap(user -> gitHubClient.getUser(user.getLogin())
                            .onErrorContinue((err, o) -> log.warn(err.getMessage(), o))
                            .map(GithubUserMapper::toUserDetails)
                            .map(userDetails -> {
                                user.setUserDetails(userDetails);
                                return user;
                            })
                            .filter(userFilter::isMatching)
                    )
                    .onErrorContinue((err, o) -> log.warn(err.getMessage(), o));
            result = Flux.concat(result, chunk);
        }
        return result;
    }

}
