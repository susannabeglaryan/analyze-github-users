package com.analyzegithubusers.controller;

import com.analyzegithubusers.controller.dto.UserResponseDTO;
import com.analyzegithubusers.controller.mapper.UserViewMapper;
import com.analyzegithubusers.service.user.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/user")
class UserController implements IUserController {

    private final IUserService userService;

    @Override
    public Flux<UserResponseDTO> getPagedUsers(
            String login,
            String company,
            String location,
            Pageable pageable
    ) {
        return userService.getPagedUsers(login, company, location, pageable)
                .map(UserViewMapper::toUserResponseDTO);
    }
}
