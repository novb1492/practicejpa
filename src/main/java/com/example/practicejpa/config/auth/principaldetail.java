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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return uservo.getPwd();
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return uservo.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
    
}
