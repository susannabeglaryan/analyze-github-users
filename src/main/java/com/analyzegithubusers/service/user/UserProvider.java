package com.analyzegithubusers.service.user;

import com.analyzegithubusers.service.user.model.User;
import reactor.core.publisher.Flux;

public interface UserProvider {
    Flux<User> getAllUsers(UserFilter userFilter);
}
