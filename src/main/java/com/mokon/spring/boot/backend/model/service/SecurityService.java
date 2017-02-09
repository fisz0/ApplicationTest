package com.mokon.spring.boot.backend.model.service;

/**
 * Created by marcinokon on 09.02.2017.
 */
public interface SecurityService {

    public String findLoggedInUsername();

    public void autologin(String username, String password);
}
