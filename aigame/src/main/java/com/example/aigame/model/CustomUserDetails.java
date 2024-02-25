package com.example.aigame.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUserDetails implements UserDetails {

    private User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // You can customize this method based on your user roles/permissions
        return null;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // You can customize this based on your business logic
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // You can customize this based on your business logic
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // You can customize this based on your business logic
    }

    @Override
    public boolean isEnabled() {
        return true; // You can customize this based on your business logic
    }
}
