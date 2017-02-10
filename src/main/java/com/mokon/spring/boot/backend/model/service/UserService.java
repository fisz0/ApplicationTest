package com.mokon.spring.boot.backend.model.service;

import com.mokon.spring.boot.backend.model.dto.UserDto;
import com.mokon.spring.boot.backend.model.entity.User;

/**
 * Created by marcinokon on 09.02.2017.
 */
public interface UserService {

    public void save(UserDto user);

    public UserDto findByUsername(String username);
}
