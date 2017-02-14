package com.mokon.spring.boot.backend.domain.validator;

import com.mokon.spring.boot.backend.domain.UserCreateForm;
import com.mokon.spring.boot.backend.model.entity.User;
import com.mokon.spring.boot.backend.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


/**
 * Created by mokon on 10.02.2017.
 */
@Component
public class UserCreateFormValidator implements Validator {

    private final UserService userService;

    @Autowired
    public UserCreateFormValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(UserCreateForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserCreateForm form = (UserCreateForm) target;
        validatePasswords(errors, form);
        validateEmail(errors, form);
        validateLogin(errors, form);
    }

    private void validatePasswords(Errors errors, UserCreateForm form) {
        if (!form.getPassword().equals(form.getPasswordRepeated())) {
            errors.reject("password.no_match", "Passwords do not match");
        }
    }

    private void validateEmail(Errors errors, UserCreateForm form) {
        if (userService.getUserByEmail(form.getEmail()).isPresent()) {
            errors.reject("email.exists", "User with this email already exists");
        }
    }

    private void validateLogin(Errors errors, UserCreateForm form) {
        if (userService.getUserByLogin(form.getLogin()).isPresent()) {
            errors.reject("login.exists", "User with this login already exists");
        }
    }
}
