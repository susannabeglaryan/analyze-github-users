package com.analyzegithubusers.controller.mapper;

import com.analyzegithubusers.controller.dto.UserResponseDTO;
import com.analyzegithubusers.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserViewMapper {

    public static UserResponseDTO toUserResponseDTO(User user) {
        var details = user.getUserDetails();
        return UserResponseDTO.builder()
                .login(user.getLogin())
                .id(user.getId())
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
                .createdAt(details.getCreatedAt())
                .totalPrivateRepos(details.getTotalPrivateRepos())
                .ownedPrivateRepos(details.getOwnedPrivateRepos())
                .build();
    }

    public static List<UserResponseDTO> toUserResponseDTOList(List<User> users) {
        return users.stream()
                .map(UserViewMapper::toUserResponseDTO)
                .collect(Collectors.toList());
    }
}
