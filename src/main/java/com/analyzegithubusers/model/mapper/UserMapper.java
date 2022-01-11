package com.analyzegithubusers.model.mapper;

import com.analyzegithubusers.db.entity.UserEntity;
import com.analyzegithubusers.model.User;
import com.analyzegithubusers.model.UserDetails;
import com.analyzegithubusers.model.UserDetailsDTO;
import com.analyzegithubusers.model.UserResponseDTO;
import com.analyzegithubusers.service.github.model.GithubUserDetailsResponse;
import com.analyzegithubusers.service.github.model.GithubUserResponse;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
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
                .id(userEntity.getId())
                .avatarUrl(userEntity.getAvatarUrl())
                .url(userEntity.getUrl())
                .htmlUrl(userEntity.getHtmlUrl())
                .followersUrl(userEntity.getFollowersUrl())
                .followingUrl(userEntity.getFollowingUrl())
                .userDetails(userDetails)
                .build();
    }

    public static User toUser(UserResponseDTO userResponseDTO) {
        var details = userResponseDTO.getUserDetails();
        var userDetails = UserDetails.builder()
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
        return User.builder()
                .login(userResponseDTO.getLogin())
                .id(userResponseDTO.getId())
                .avatarUrl(userResponseDTO.getAvatarUrl())
                .url(userResponseDTO.getUrl())
                .htmlUrl(userResponseDTO.getHtmlUrl())
                .followersUrl(userResponseDTO.getFollowersUrl())
                .followingUrl(userResponseDTO.getFollowingUrl())
                .userDetails(userDetails)
                .build();
    }

    public static UserResponseDTO toUserResponseDTO(User user) {
        var details = user.getUserDetails();
        var userDetails = UserDetailsDTO.builder()
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
        return UserResponseDTO.builder()
                .login(user.getLogin())
                .id(user.getId())
                .avatarUrl(user.getAvatarUrl())
                .url(user.getUrl())
                .htmlUrl(user.getHtmlUrl())
                .followersUrl(user.getFollowersUrl())
                .followingUrl(user.getFollowingUrl())
                .userDetails(userDetails)
                .build();
    }

    public static Map<String, List<UserResponseDTO>> toUserResponseDTOMap(Map<String, List<User>> userMap) {
        return userMap.entrySet().stream().map(entry -> {
            var list = entry.getValue().stream()
                    .map(UserMapper::toUserResponseDTO).collect(Collectors.toList());
            return Map.entry(entry.getKey(), list);
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

}
