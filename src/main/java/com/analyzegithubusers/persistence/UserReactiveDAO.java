package com.analyzegithubusers.persistence;

import com.analyzegithubusers.model.User;
import reactor.core.publisher.Flux;

public interface UserReactiveDAO {

    Flux<User> findAll();
}
