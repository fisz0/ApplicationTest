package com.mokon.spring.boot.backend.service.currentuser;

import com.mokon.spring.boot.backend.domain.CurrentUser;
import com.mokon.spring.boot.backend.model.entity.Role;
import org.springframework.stereotype.Service;

/**
 * Created by mokon on 10.02.2017.
 */
@Service
public class CurrentUserServiceImpl implements CurrentUserService {

    @Override
    public boolean canAccessUser(CurrentUser currentUser, Long userId) {
        return currentUser != null
            && (currentUser.getRole() == Role.ADMIN || currentUser.getId().equals(userId));
    }

}
