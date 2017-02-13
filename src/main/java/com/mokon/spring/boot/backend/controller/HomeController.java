package com.mokon.spring.boot.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by mokon on 10.02.2017.
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String getHomePage() {
        return "home";
    }

}
