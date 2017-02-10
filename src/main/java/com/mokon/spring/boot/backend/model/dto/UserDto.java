package com.mokon.spring.boot.backend.model.dto;

import com.mokon.spring.boot.backend.model.entity.Role;

import java.util.Set;

/**
 * Created by mokon on 10.02.2017.
 */
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String passwordConfirm;
    private Set<RoleDto> roles;

    public UserDto(Long id, String username, String password, String passwordConfirm, Set<RoleDto> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.roles = roles;
    }

    public UserDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Set<RoleDto> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleDto> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDto userDto = (UserDto) o;

        if (id != null ? !id.equals(userDto.id) : userDto.id != null) return false;
        if (username != null ? !username.equals(userDto.username) : userDto.username != null) return false;
        if (password != null ? !password.equals(userDto.password) : userDto.password != null) return false;
        if (passwordConfirm != null ? !passwordConfirm.equals(userDto.passwordConfirm) : userDto.passwordConfirm != null)
            return false;
        return roles != null ? roles.equals(userDto.roles) : userDto.roles == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (passwordConfirm != null ? passwordConfirm.hashCode() : 0);
        result = 31 * result + (roles != null ? roles.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserDto{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", passwordConfirm='" + passwordConfirm + '\'' +
            ", roles=" + roles +
            '}';
    }
}
