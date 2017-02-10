package com.mokon.spring.boot.backend.model.service;

/**
 * Created by marcinokon on 09.02.2017.
 */

import com.mokon.spring.boot.backend.model.assembler.RoleAssembler;
import com.mokon.spring.boot.backend.model.assembler.UserAssembler;
import com.mokon.spring.boot.backend.model.dto.UserDto;
import com.mokon.spring.boot.backend.model.entity.Role;
import com.mokon.spring.boot.backend.model.entity.User;
import com.mokon.spring.boot.backend.model.repository.RoleRepository;
import com.mokon.spring.boot.backend.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(UserDto user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roleRepository.findAll().forEach(e -> roles.add(e));
        user.setRoles(RoleAssembler.toDtoCollection(roles));
        userRepository.save(UserAssembler.toEntity(user));
    }

    @Override
    public UserDto findByUsername(String username) {
        return UserAssembler.toDto(userRepository.findByUsername(username));
    }
}
