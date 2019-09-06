package com.example.demo.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Set;

/**
 * @Author: 青菜
 * @Date: 2019/8/30 下午6:19
 * @Description:
 * @Version 1.0
 */
@Data
public class SelfUserDetails implements UserDetails, Serializable {
    private String username;
    private String password;
    private Set<? extends GrantedAuthority> authorities;


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
