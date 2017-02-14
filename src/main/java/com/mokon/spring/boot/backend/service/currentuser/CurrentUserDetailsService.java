package com.mokon.spring.boot.backend.service.currentuser;

import com.mokon.spring.boot.backend.domain.CurrentUser;
import com.mokon.spring.boot.backend.model.entity.User;
import com.mokon.spring.boot.backend.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by marcinokon on 09.02.2017.
 */
@Service
public class CurrentUserDetailsService implements UserDetailsService {
    private final UserService userService;

    @Autowired
    public CurrentUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CurrentUser loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userService.getUserByLogin(login)
            .orElseThrow(() -> new UsernameNotFoundException(String.format("User with login=%s was not found", login)));
        return new CurrentUser(user);
    }
}
