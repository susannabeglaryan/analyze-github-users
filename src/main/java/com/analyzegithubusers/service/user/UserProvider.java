package com.analyzegithubusers.service.user;

import com.analyzegithubusers.service.user.model.User;
import reactor.core.publisher.Flux;

import java.util.List;

public interface UserProvider {
    Flux<User> getAllUsers(UserFilter userFilter);
}
