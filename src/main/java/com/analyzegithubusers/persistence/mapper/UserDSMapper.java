package com.analyzegithubusers.persistence.mapper;

import com.analyzegithubusers.model.User;
import com.analyzegithubusers.model.UserDetails;
import com.analyzegithubusers.persistence.entity.UserEntity;

public class UserDSMapper {

    public static UserEntity toUserEntity(User user) {
        var details = user.getUserDetails();
        return UserEntity.builder()
                .sourceId(user.getId())
                .login(user.getLogin())
                .avatarUrl(user.getAvatarUrl())
                .url(user.getUrl())
                .htmlUrl(user.getHtmlUrl())
                .followersUrl(user.getFollowersUrl())
                .followingUrl(user.getFollowingUrl())
                .name(details.getName())
                .company(details.getCompany())
                .location(details.getLocation())
                .email(details.getEmail())
                .publicRepos(details.getPublicRepos())
                .followers(details.getFollowers())
                .following(details.getFollowing())
                .profileCreatedAt(details.getCreatedAt())
                .totalPrivateRepos(details.getTotalPrivateRepos())
                .ownedPrivateRepos(details.getOwnedPrivateRepos())
                .build();
    }

    public static User toUser(UserEntity userEntity) {
        var userDetails = UserDetails.builder()
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
        return User.builder()
                .login(userEntity.getLogin())
                .id(userEntity.getId())
                .avatarUrl(userEntity.getAvatarUrl())
                .url(userEntity.getUrl())
                .htmlUrl(userEntity.getHtmlUrl())
                .followersUrl(userEntity.getFollowersUrl())
                .followingUrl(userEntity.getFollowingUrl())
                .userDetails(userDetails)
                .build();
    }

}
