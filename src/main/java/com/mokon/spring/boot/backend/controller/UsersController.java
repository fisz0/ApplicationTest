package com.mokon.spring.boot.backend.controller;

/**
 * Created by marcinokon on 09.02.2017.
 */

import com.mokon.spring.boot.backend.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ModelAndView getUsersPage() {
        return new ModelAndView("users");
    }

    @GetMapping("/users_table")
    public ModelAndView getUsersTable() {
        return new ModelAndView("users_table", "users", userService.getAllUsers());
    }
}
