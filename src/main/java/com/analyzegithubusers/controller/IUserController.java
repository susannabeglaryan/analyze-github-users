package com.analyzegithubusers.controller;

import com.analyzegithubusers.controller.dto.UserResponseDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Flux;

public interface IUserController {

    @GetMapping("/all")
    Flux<UserResponseDTO> getPagedUsers(
            @RequestParam(required = false) String login,
            @RequestParam(required = false) String company,
            @RequestParam(required = false) String location,
            @PageableDefault(sort = "profileCreatedAt", direction = Sort.Direction.ASC) Pageable pageable
    );

}
