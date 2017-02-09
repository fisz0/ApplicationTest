package com.mokon.spring.boot.backend.model.repository;

/**
 * Created by marcinokon on 09.02.2017.
 */

import com.mokon.spring.boot.backend.model.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}