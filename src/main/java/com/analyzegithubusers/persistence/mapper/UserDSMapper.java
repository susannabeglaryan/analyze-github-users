package com.analyzegithubusers.persistence.mapper;

import com.analyzegithubusers.model.User;
import com.analyzegithubusers.model.UserDetails;
import com.analyzegithubusers.persistence.entity.UserEntity;

public class UserDSMapper {

    public static UserEntity toUserEntity(User user) {
        return UserEntity.builder()
                .sourceId(user.getId())
                .login(user.getLogin())
                .avatarUrl(user.getAvatarUrl())
                .url(user.getUrl())
                .htmlUrl(user.getHtmlUrl())
                .followersUrl(user.getFollowersUrl())
                .followingUrl(user.getFollowingUrl())
                .name(user.getName())
                .company(user.getCompany())
                .location(user.getLocation())
                .email(user.getEmail())
                .publicRepos(user.getPublicRepos())
                .followers(user.getFollowers())
                .following(user.getFollowing())
                .profileCreatedAt(user.getCreatedAt())
                .totalPrivateRepos(user.getTotalPrivateRepos())
                .ownedPrivateRepos(user.getOwnedPrivateRepos())
                .build();
    }

    public static User toUser(UserEntity userEntity) {
        return User.builder()
                .login(userEntity.getLogin())
                .id(userEntity.getId())
                .avatarUrl(userEntity.getAvatarUrl())
                .url(userEntity.getUrl())
                .htmlUrl(userEntity.getHtmlUrl())
                .followersUrl(userEntity.getFollowersUrl())
                .followingUrl(userEntity.getFollowingUrl())
                .name(userEntity.getName())
                .company(userEntity.getCompany())
                .location(userEntity.getLocation())
                .email(userEntity.getEmail())
                .publicRepos(userEntity.getPublicRepos())
                .followers(userEntity.getFollowers())
                .following(userEntity.getFollowing())
                .createdAt(userEntity.getProfileCreatedAt())
                .totalPrivateRepos(userEntity.getTotalPrivateRepos())
                .ownedPrivateRepos(userEntity.getOwnedPrivateRepos())
                .build();
    }

}
