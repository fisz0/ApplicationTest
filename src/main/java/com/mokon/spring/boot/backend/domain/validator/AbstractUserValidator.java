package com.mokon.spring.boot.backend.domain.validator;

import com.mokon.spring.boot.backend.service.user.UserService;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by mokon on 02.03.2017.
 */
public abstract class AbstractUserValidator implements Validator {

    private final UserService userService;

    public AbstractUserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public abstract boolean supports(Class<?> aClass);

    @Override
    public abstract void validate(Object o, Errors errors);

    protected void validateEmail(Errors errors, String email) {
        if (userService.getUserByEmail(email).isPresent()) {
            errors.reject("email.exists", "User with this email already exists");
        }
    }

    protected void validateLogin(Errors errors, String login) {
        if (userService.getUserByLogin(login).isPresent()) {
            errors.reject("login.exists", "User with this login already exists");
        }
    }

    protected void validateIfEmptyEmail(Errors errors, String email) {
        if (email.isEmpty()) errors.reject("email.empty", "Can not save empty email.");
    }

    protected void validateIfEmptyName(Errors errors, String name) {
        if (name.isEmpty()) errors.reject("name.empty", "Can not save empty name.");
    }

    protected void validateIfEmptyLastName(Errors errors, String lastName) {
        if (lastName.isEmpty()) errors.reject("last.name.empty", "Can not save empty last name.");
    }

    protected void validateIfEmptyLogin(Errors errors, String login) {
        if (login.isEmpty()) errors.reject("login.empty", "Can not save empty login.");
    }

    protected void validatePasswords(Errors errors, String password, String repeatedPassword) {
        if (!password.equals(repeatedPassword)) {
            errors.reject("password.no_match", "Passwords do not match");
        }
    }
}
