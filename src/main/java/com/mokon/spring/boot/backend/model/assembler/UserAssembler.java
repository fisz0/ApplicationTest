package com.mokon.spring.boot.backend.model.assembler;

import com.mokon.spring.boot.backend.model.dto.UserDto;
import com.mokon.spring.boot.backend.model.entity.User;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mokon on 10.02.2017.
 */
public class UserAssembler {
    public static UserDto toDto(User user) {
        UserDto dto = new UserDto();
        if (user.getId() != null) {
            dto.setId(user.getId());
        }
        dto.setPassword(user.getPassword());
        dto.setPasswordConfirm(user.getPasswordConfirm());
        dto.setRoles(RoleAssembler.toDtoCollection(user.getRoles()));
        dto.setUsername(user.getUsername());
        return dto;
    }

    public static User toEntity(UserDto dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setPasswordConfirm(dto.getPasswordConfirm());
        user.setId(dto.getId());
        if (dto.getRoles() != null) {
            user.setRoles(RoleAssembler.toEntityCollection(dto.getRoles()));
        }
        return user;
    }

    public static Set<UserDto> toDtoCollection(Set<User> users) {
        Set<UserDto> dtos = new HashSet<>();
        users.forEach(e -> dtos.add(toDto(e)));
        return dtos;
    }

    public static Set<User> toEntityCollection(Set<UserDto> dtos) {
        Set<User> users = new HashSet<>();
        dtos.forEach(dto -> users.add(toEntity(dto)));
        return users;
    }
}
