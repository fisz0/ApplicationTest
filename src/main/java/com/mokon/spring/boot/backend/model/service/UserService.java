package com.mokon.spring.boot.backend.model.service;

import com.mokon.spring.boot.backend.model.entity.User;

/**
 * Created by marcinokon on 09.02.2017.
 */
public interface UserService {

    public void save(User user);

    public User findByUsername(String username);
}
