package com.mokon.spring.boot.backend.model.service;

import com.mokon.spring.boot.backend.model.dto.CurrentUser;

/**
 * Created by mokon on 10.02.2017.
 */
public interface CurrentUserService {
    boolean canAccessUser(CurrentUser currentUser, Long userId);
}
