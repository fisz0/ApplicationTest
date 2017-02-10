package com.mokon.spring.boot.backend.model.dto;

import com.mokon.spring.boot.backend.model.entity.User;

import java.util.Set;

/**
 * Created by mokon on 10.02.2017.
 */
public class RoleDto {
    private Long id;
    private String name;
    private Set<UserDto> users;

    public RoleDto(Long id, String name, Set<UserDto> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }

    public RoleDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserDto> getUsers() {
        return users;
    }

    public void setUsers(Set<UserDto> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleDto roleDto = (RoleDto) o;

        if (id != null ? !id.equals(roleDto.id) : roleDto.id != null) return false;
        if (name != null ? !name.equals(roleDto.name) : roleDto.name != null) return false;
        return users != null ? users.equals(roleDto.users) : roleDto.users == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (users != null ? users.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RoleDto{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", users=" + users +
            '}';
    }
}
