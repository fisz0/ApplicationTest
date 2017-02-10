package com.mokon.spring.boot.backend.service.currentuser;

import com.mokon.spring.boot.backend.domain.CurrentUser;

/**
 * Created by mokon on 10.02.2017.
 */
public interface CurrentUserService {
    boolean canAccessUser(CurrentUser currentUser, Long userId);
}
