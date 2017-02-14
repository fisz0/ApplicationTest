package com.mokon.spring.boot.backend.service.user;

import com.mokon.spring.boot.backend.model.entity.User;
import com.mokon.spring.boot.backend.domain.UserCreateForm;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by marcinokon on 09.02.2017.
 */
public interface UserService {

    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);

    Optional<User> getUserByLogin(String login);

    Collection<User> getAllUsers();

    User create(UserCreateForm form);

}
