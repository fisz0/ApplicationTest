package com.mokon.application.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by mokon on 08.02.2017.
 */
@Controller
public class FirstController {

    @GetMapping("/test")
    public String render(@RequestParam(name = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "testView";
    }
}
