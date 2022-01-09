package com.analyzegithubusers.service.user.mapper;

import com.analyzegithubusers.db.entity.UserEntity;
import com.analyzegithubusers.service.github.model.GithubUserDetailsResponse;
import com.analyzegithubusers.service.github.model.GithubUserResponse;
import com.analyzegithubusers.service.user.model.User;
import com.analyzegithubusers.service.user.model.UserDetails;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserDetails toUserDetails(GithubUserDetailsResponse userResponse) {
        LocalDateTime createdAt = LocalDateTime.parse(userResponse.getCreatedAt().replace("Z", ""));
        return UserDetails.builder()
                .name(userResponse.getName())
                .company(userResponse.getCompany())
                .location(userResponse.getLocation())
                .email(userResponse.getEmail())
                .publicRepos(userResponse.getPublicRepos())
                .followers(userResponse.getFollowers())
                .following(userResponse.getFollowing())
                .createdAt(createdAt)
                .totalPrivateRepos(userResponse.getTotalPrivateRepos())
                .ownedPrivateRepos(userResponse.getOwnedPrivateRepos())
                .build();
    }

    public static User toUser(GithubUserResponse userResponse) {
        return User.builder()
                .login(userResponse.getLogin())
                .id(userResponse.getId())
                .avatarUrl(userResponse.getAvatarUrl())
                .url(userResponse.getUrl())
                .htmlUrl(userResponse.getHtmlUrl())
                .followersUrl(userResponse.getFollowersUrl())
                .followingUrl(userResponse.getFollowingUrl())
                .build();
    }

    public static List<User> toUsersList(List<GithubUserResponse> userResponses) {
        return userResponses.stream().map(UserMapper::toUser).collect(Collectors.toList());
    }

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
                .id(userEntity.getSourceId())
                .avatarUrl(userEntity.getAvatarUrl())
                .url(userEntity.getUrl())
                .htmlUrl(userEntity.getHtmlUrl())
                .followersUrl(userEntity.getFollowersUrl())
                .followingUrl(userEntity.getFollowingUrl())
                .userDetails(userDetails)
                .build();
    }
}
