package com.estockmarket.stockmarket.model;

import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

import java.io.Serializable;
import java.util.Collection;
import java.util.UUID;

@Table("user")
public class User implements UserDetails{
    @PrimaryKey
    private UUID id;
    private String name;
    private String username;
    private String password;


    public User(UUID id, String name, String username, String password) {
        this.id = id;
        this.name = name;
        this.username=username;
        this.password = password;
    }


    public UUID getId() {
        return this.id;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
        id = UUID.randomUUID();
    }


    public User(String username2, String password2) {
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return false;
    }


    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }


    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return false;
    }


    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return false;
    }
}
