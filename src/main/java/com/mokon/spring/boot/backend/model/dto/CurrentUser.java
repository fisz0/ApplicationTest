package com.mokon.spring.boot.backend.model.dto;

import com.mokon.spring.boot.backend.model.entity.Role;
import com.mokon.spring.boot.backend.model.entity.User;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 * Created by mokon on 10.02.2017.
 */
public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private User user;

    public CurrentUser(User user) {
        super(user.getEmail(), user.getPasswordHash(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Long getId() {
        return user.getId();
    }

    public Role getRole() {
        return user.getRole();
    }

}
