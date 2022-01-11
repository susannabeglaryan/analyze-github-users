package com.analyzegithubusers.db.jpadao;

import com.analyzegithubusers.db.repository.UserRepository;
import com.analyzegithubusers.persistence.UserDAO;
import com.analyzegithubusers.service.user.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import static com.analyzegithubusers.service.user.mapper.UserMapper.toUser;
import static com.analyzegithubusers.service.user.mapper.UserMapper.toUserEntity;

@Component
@AllArgsConstructor
public class JPAUserDAO implements UserDAO {
    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        var userEntity = toUserEntity(user);
        var savedUserEntity = userRepository.save(userEntity);
        return toUser(savedUserEntity);
    }
}
