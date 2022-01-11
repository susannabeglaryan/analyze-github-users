package com.analyzegithubusers.service.user;

import com.analyzegithubusers.model.User;
import reactor.core.publisher.Flux;

public interface IUserProvider {
    Flux<User> getAllUsers(UserFilter userFilter);
}
