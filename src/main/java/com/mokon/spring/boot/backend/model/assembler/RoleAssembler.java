package com.mokon.spring.boot.backend.model.assembler;

import com.mokon.spring.boot.backend.model.dto.RoleDto;
import com.mokon.spring.boot.backend.model.entity.Role;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mokon on 10.02.2017.
 */
public class RoleAssembler {
    public static RoleDto toDto(Role role) {
        RoleDto dto = new RoleDto();
        dto.setId(role.getId());
        dto.setName(role.getName());
        dto.setUsers(UserAssembler.toDtoCollection(role.getUsers()));
        return dto;
    }

    public static Role toEntity(RoleDto dto) {
        Role role = new Role();
        role.setId(dto.getId());
        role.setName(dto.getName());
        role.setUsers(UserAssembler.toEntityCollection(dto.getUsers()));
        return role;
    }

    public static Set<RoleDto> toDtoCollection(Collection<Role> roles) {
        Set<RoleDto> dtos = new HashSet<>();
        roles.forEach(e -> dtos.add(toDto(e)));
        return dtos;
    }

    public static Set<Role> toEntityCollection(Collection<RoleDto> dtos) {
        Set<Role> roles = new HashSet<>();
        dtos.forEach(dto -> roles.add(toEntity(dto)));
        return roles;
    }
}
