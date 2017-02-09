package com.mokon.spring.boot.backend.model.repository;

/**
 * Created by marcinokon on 09.02.2017.
 */

import com.mokon.spring.boot.backend.model.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
}