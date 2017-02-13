package com.mokon.spring.boot.backend.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by mokon on 13.02.2017.
 */
@Controller
public class TrainingController {

    @PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #id)")
    @GetMapping("/trainings/{id}")
    public String getTrainingsPage(@PathVariable Long id) {
        return "trainings";
    }
}
