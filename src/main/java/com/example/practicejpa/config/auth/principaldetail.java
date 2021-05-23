package com.example.practicejpa.config.auth;

import java.util.Collection;

import com.example.practicejpa.models.usermodel.uservo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class principaldetail implements UserDetails{

    private uservo uservo;

    public principaldetail(uservo uservo)
    {
        this.uservo=uservo;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return uservo.getPwd();
    }

    @Override
    public String getUsername() {
        return uservo.getEmail();
    }

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
