package com.mokon.spring.boot.backend.domain.validator;

import com.mokon.spring.boot.backend.domain.UserCreateForm;
import com.mokon.spring.boot.backend.domain.UserUpdateForm;
import com.mokon.spring.boot.backend.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

/**
 * Created by mokon on 02.03.2017.
 */
@Component
public class UserUpdateFormValidator extends AbstractUserValidator {


    @Autowired
    public UserUpdateFormValidator(UserService userService) {
        super(userService);
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(UserUpdateForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserCreateForm form = (UserCreateForm) target;
        validateLogin(errors, form.getLogin());
        validateEmail(errors, form.getEmail());
        validateIfEmptyEmail(errors, form.getEmail());
        validateIfEmptyLastName(errors, form.getLastName());
        validateIfEmptyLogin(errors, form.getLogin());
        validateIfEmptyName(errors, form.getName());
    }


}
