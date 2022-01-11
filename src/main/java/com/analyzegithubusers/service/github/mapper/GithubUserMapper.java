package com.analyzegithubusers.service.github.mapper;

import com.analyzegithubusers.model.User;
import com.analyzegithubusers.model.UserDetails;
import com.analyzegithubusers.service.github.model.GithubUserDetailsResponse;
import com.analyzegithubusers.service.github.model.GithubUserResponse;

import java.time.LocalDateTime;

public class GithubUserMapper {

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
}
