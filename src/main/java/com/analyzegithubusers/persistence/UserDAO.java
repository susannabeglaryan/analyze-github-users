package com.analyzegithubusers.persistence;

import com.analyzegithubusers.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import reactor.util.annotation.Nullable;

import java.util.List;

public interface UserDAO {
    User save(User user);

    Page<User> findAll(@Nullable String login, Pageable pageable);

    Page<User> findAll(Pageable pageable);

    List<User> findAll();
}
