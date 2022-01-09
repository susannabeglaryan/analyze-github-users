package com.analyzegithubusers.db.jpadao;

import com.analyzegithubusers.db.entity.UserEntity;
import com.analyzegithubusers.db.repository.UserRepository;
import com.analyzegithubusers.persistence.UserDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class JPAUserDAO implements UserDAO {
    private final UserRepository userRepository;

    @Override
    public UserEntity save(UserEntity user) {
        return userRepository.save(user);
    }
}
