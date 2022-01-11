package com.analyzegithubusers.controller;


import com.analyzegithubusers.controller.dto.UserGroupResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;

import static org.springframework.http.MediaType.APPLICATION_NDJSON_VALUE;

public interface IUserGroupController {

    @GetMapping("/byCompany")
    Flux<UserGroupResponseDTO> getUsersGroupedByCompany();

    @GetMapping(path = "/byLocation" , produces = APPLICATION_NDJSON_VALUE)
    Flux<UserGroupResponseDTO> getUsersGroupedByLocation();
}
