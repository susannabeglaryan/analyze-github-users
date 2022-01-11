package com.analyzegithubusers.persistence.jpadao;

import com.analyzegithubusers.model.User;
import com.analyzegithubusers.persistence.mapper.UserDSMapper;
import com.analyzegithubusers.persistence.UserReactiveDAO;
import com.analyzegithubusers.persistence.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@AllArgsConstructor
public class JPAUserReactiveDAO implements UserReactiveDAO {
    private final UserRepository userReactiveRepository;
    @Override
    public Flux<User> findAll() {
        return userReactiveRepository.findAll().map(UserDSMapper::toUser);
    }
}
