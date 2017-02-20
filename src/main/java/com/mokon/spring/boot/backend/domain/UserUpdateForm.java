package com.mokon.spring.boot.backend.domain;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

/**
 * Created by mokon on 20.02.2017.
 */
public class UserUpdateForm {

    @NotEmpty
    private String email = "";

    @NotEmpty
    private String name = "";

    @NotEmpty
    private String lastName = "";

    @NotEmpty
    private String login = "";

    @NotEmpty
    private List<String> Notes;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
