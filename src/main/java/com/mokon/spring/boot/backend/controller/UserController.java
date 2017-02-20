package com.mokon.spring.boot.backend.controller;

import com.mokon.spring.boot.backend.domain.AddNoteForm;
import com.mokon.spring.boot.backend.domain.UserUpdateForm;
import com.mokon.spring.boot.backend.domain.validator.UserCreateFormValidator;
import com.mokon.spring.boot.backend.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.NoSuchElementException;

/**
 * Created by mokon on 10.02.2017.
 */
@Controller
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;
    private final UserCreateFormValidator userCreateFormValidator;

    @Autowired
    public UserController(UserService userService, UserCreateFormValidator userCreateFormValidator) {
        this.userService = userService;
        this.userCreateFormValidator = userCreateFormValidator;
    }

    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userCreateFormValidator);
    }

    @PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #id)")
    @GetMapping("/user/{id}")
    public ModelAndView getUserPage(@PathVariable Long id) {
        LOGGER.info("Rendering user details panel.");
        return new ModelAndView("user", "user", userService.getUserById(id)
            .orElseThrow(() -> new NoSuchElementException(String.format("User=%s not found", id))));
    }

    @PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #id)")
    @DeleteMapping("/users/delete/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
    }

    @PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #id)")
    @GetMapping("/update_user")
    public ModelAndView getUserUpdatePage() {
        LOGGER.info("Rendering user update page.");
        return new ModelAndView("update_user", "updateForm", new UserUpdateForm());
    }

    @PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #id)")
    @PostMapping("/update")
    public String updateUser(@Valid @ModelAttribute("updateForm") UserUpdateForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/update_user";
        }
        userService.update(form);
        return "redirect:/";
    }

    @PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #id)")
    @PostMapping("/update")
    public String addNote(@Valid @ModelAttribute("updateForm") AddNoteForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/update_user";
        }
        userService.addNote(form);
        return "redirect:/";
    }
}
