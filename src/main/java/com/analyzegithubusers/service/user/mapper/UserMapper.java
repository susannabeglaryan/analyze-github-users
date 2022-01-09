package com.analyzegithubusers.service.user.mapper;

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



}
