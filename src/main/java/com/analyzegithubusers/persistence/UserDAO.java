package com.analyzegithubusers.persistence;

import com.analyzegithubusers.service.user.model.User;

public interface UserDAO {
    User save(User user);
}
