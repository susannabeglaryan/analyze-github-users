package com.analyzegithubusers.service.user;

import com.analyzegithubusers.service.user.model.User;

public interface UserFilter {
    boolean isMatching(User user);
}
