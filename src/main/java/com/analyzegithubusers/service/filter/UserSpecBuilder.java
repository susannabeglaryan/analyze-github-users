package com.analyzegithubusers.service.filter;

import com.analyzegithubusers.db.entity.UserEntity;

public class UserSpecBuilder extends BaseSpecBuilder<UserEntity> {

    public UserSpecBuilder loginLike(String login) {
        apply(login, (root, query, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.upper(root.get("login")),
                likeUpper(login))
        );
        return this;
    }

}
