package com.analyzegithubusers.persistence;

import com.analyzegithubusers.model.User;
import com.analyzegithubusers.persistence.entity.UserEntity;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.util.annotation.Nullable;

public interface UserDAO {

    Flux<User> findAll(@Nullable String login, String company, String location, Pageable pageable);

    Flux<UserEntity> saveAll(Flux<User> users);
}
