package com.analyzegithubusers.service.user;

import com.analyzegithubusers.model.User;

public interface UserFilter {
    boolean isMatching(User user);
}
