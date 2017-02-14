package com.mokon.spring.boot.backend.controller;

import com.mokon.spring.boot.backend.domain.UserCreateForm;
import com.mokon.spring.boot.backend.domain.validator.UserCreateFormValidator;
import com.mokon.spring.boot.backend.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by mokon on 13.02.2017.
 */

@Controller
public class RegisterController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserCreateFormValidator userCreateFormValidator;

    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userCreateFormValidator);
    }


    @GetMapping("/register")
    public ModelAndView getUserCreatePage() {
        LOGGER.info("Rendering registration screen.");

        return new ModelAndView("register", "form", new UserCreateForm());
    }

    @RequestMapping(value = "/register/create", method = RequestMethod.POST)
    public String handleUserCreateForm(@Valid @ModelAttribute("form") UserCreateForm form, BindingResult bindingResult) {
        LOGGER.debug("Processing user create form={}, bindingResult={}", form, bindingResult);
        if (bindingResult.hasErrors()) {
            LOGGER.error("Errors occured.");
            return "register";
        }
        try {
            LOGGER.info("Saving new user.");
            userService.create(form);
        } catch (DataIntegrityViolationException e) {
            LOGGER.warn("Exception occurred when trying to save the user, assuming duplicate email or login", e);
            bindingResult.reject("data.exists", "Email or login already exists");
            return "register";
        }
        // ok, redirect
        return "redirect:/login";
    }

}
