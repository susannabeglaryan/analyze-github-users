package com.analyzegithubusers.persistence;

import com.analyzegithubusers.db.entity.UserEntity;

public interface UserDAO {
    UserEntity save(UserEntity user);
}
