package com.analyzegithubusers.persistence.jpadao;

import com.analyzegithubusers.model.User;
import com.analyzegithubusers.persistence.UserDAO;
import com.analyzegithubusers.persistence.entity.UserEntity;
import com.analyzegithubusers.persistence.mapper.UserDSMapper;
import com.analyzegithubusers.persistence.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@AllArgsConstructor
@Component
public class JPAUserDAO implements UserDAO {
    private final UserRepository userRepository;

    @Override
    public Flux<User> findAll(String login, String company, String location, Pageable pageable) {
        return userRepository.findAll()
                .filter(u -> {
                    boolean isValid = true;
                    if (login != null) {
                        isValid = u.getLogin() != null && u.getLogin().contains(login);
                    }
                    if (company != null) {
                        isValid &= u.getCompany() != null && u.getCompany().equals(company);
                    }
                    if (location != null) {
                        isValid &= u.getLocation() != null && u.getLocation().equals(location);
                    }
                    return isValid;
                })
                .skip(pageable.getOffset())
                .take(pageable.getPageSize())
                .map(UserDSMapper::toUser);
    }

    @Override
    public Flux<UserEntity> saveAll(Flux<User> users) {
        return userRepository.saveAll(users.map(UserDSMapper::toUserEntity));
    }

    @Override
    public Flux<User> findAll() {
        return userRepository.findAll().map(UserDSMapper::toUser);
    }

    private boolean isNullSafe(String field1, String field2) {
        return field1 != null && field2 != null;
    }

}
