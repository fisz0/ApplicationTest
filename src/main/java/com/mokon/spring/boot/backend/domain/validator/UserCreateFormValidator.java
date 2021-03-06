package com.mokon.spring.boot.backend.domain.validator;

import com.mokon.spring.boot.backend.domain.UserCreateForm;
import com.mokon.spring.boot.backend.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;


/**
 * Created by mokon on 10.02.2017.
 */
@Component
public class UserCreateFormValidator extends AbstractUserValidator {

    @Autowired
    public UserCreateFormValidator(UserService userService) {
        super(userService);
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(UserCreateForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserCreateForm form = (UserCreateForm) target;
        validatePasswords(errors, form.getPassword(), form.getPasswordRepeated());
        validateEmail(errors, form.getEmail());
        validateLogin(errors, form.getLogin());
    }
}
