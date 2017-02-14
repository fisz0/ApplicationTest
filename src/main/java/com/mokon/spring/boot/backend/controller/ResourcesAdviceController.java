package com.mokon.spring.boot.backend.controller;

import com.mokon.spring.boot.backend.model.entity.Role;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by mokon on 10.02.2017.
 */
@ControllerAdvice
public class ResourcesAdviceController {
    
    @ModelAttribute("currentUser")
    public UserDetails getCurrentUser(Authentication authentication) {
        return (authentication == null) ? null : (UserDetails) authentication.getPrincipal();
    }

    @ModelAttribute("roles")
    public Role[] getRoles() {
        Role[] roles = Role.values();
        return roles;
    }

}
