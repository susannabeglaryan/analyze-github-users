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

    public UserSpecBuilder companyIs(String company) {
        apply(company, (root, query, criteriaBuilder) -> criteriaBuilder.equal(
                root.get("company"),
                company)
        );
        return this;
    }

    public UserSpecBuilder locationIs(String location) {
        apply(location, (root, query, criteriaBuilder) -> criteriaBuilder.equal(
                root.get("location"),
                location)
        );
        return this;
    }

}
