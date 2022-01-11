package com.analyzegithubusers.controller;

import com.analyzegithubusers.controller.dto.UserGroupResponseDTO;
import com.analyzegithubusers.controller.mapper.UserGroupViewMapper;
import com.analyzegithubusers.service.user.IUserGroupService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping(path = "/api/v1/userGroup")
@AllArgsConstructor
public class UserGroupController implements IUserGroupController {

    private final IUserGroupService userGroupService;

    @Override
    public Flux<UserGroupResponseDTO> getUsersGroupedByCompany() {
        return userGroupService.getUsersGroupedByCompany()
                .flatMap(u -> u.collectList()
                        .map(l -> UserGroupViewMapper.toUserGroupResponseDTO(u.key(), l)));
    }

    @Override
    public Flux<UserGroupResponseDTO> getUsersGroupedByLocation() {
        return userGroupService.getUsersGroupedByLocation()
                .flatMap(u -> u.collectList()
                        .map(l -> UserGroupViewMapper.toUserGroupResponseDTO(u.key(), l)));
    }
}
