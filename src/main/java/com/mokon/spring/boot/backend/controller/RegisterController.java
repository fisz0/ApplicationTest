package com.mokon.spring.boot.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by mokon on 13.02.2017.
 */

@Controller
public class RegisterController {

    @GetMapping("/register")
    public String getRegisterPage() {
        return "register";
    }
}
