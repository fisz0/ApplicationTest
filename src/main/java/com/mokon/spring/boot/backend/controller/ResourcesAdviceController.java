package com.mokon.spring.boot.backend.controller;

import com.mokon.spring.boot.backend.domain.CurrentUser;
import com.mokon.spring.boot.backend.model.entity.Role;
import com.mokon.spring.boot.backend.model.entity.User;
import com.mokon.spring.boot.backend.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by mokon on 10.02.2017.
 */
@ControllerAdvice
public class ResourcesAdviceController {

    private final UserService userService;

    @Autowired
    public ResourcesAdviceController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("currentUser")
    public User getCurrentUser(Authentication authentication) {
        return (authentication == null) ? null : userService.getUserById((((CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId())).get();
    }

    @ModelAttribute("roles")
    public Role[] getRoles() {
        Role[] roles = Role.values();
        return roles;
    }

}
