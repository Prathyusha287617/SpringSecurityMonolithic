package com.product.ProductMonolithic.service;

import com.product.ProductMonolithic.entity.Roles;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {
    private String name;
    private String password;
    private List<SimpleGrantedAuthority> allRoles;

    public CustomUserDetails(String name, String password, List<Roles> allRoles) {
        super();
        this.name = name;
        this.password = password;
        this.allRoles = allRoles.stream().map((role)-> new SimpleGrantedAuthority(role.getRolesName())).toList();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.allRoles;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.name;
    }
}
