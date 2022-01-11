package com.analyzegithubusers.controller;


import com.analyzegithubusers.controller.dto.UserGroupResponseDTO;
import com.analyzegithubusers.controller.dto.UserResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.GroupedFlux;

public interface IUserGroupController {

    @GetMapping("/byCompany")
    Flux<UserGroupResponseDTO> getUsersGroupedByCompany();

    @GetMapping("/byLocation")
    Flux<GroupedFlux<String, UserResponseDTO>> getUsersGroupedByLocation();
}
