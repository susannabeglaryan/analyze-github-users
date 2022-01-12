package com.analyzegithubusers.service.user;

import com.analyzegithubusers.model.User;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;

public interface IUserService {

    Flux<User> getPagedUsers(String login, String company, String location, Pageable pageable);

    void saveUsers();

}
