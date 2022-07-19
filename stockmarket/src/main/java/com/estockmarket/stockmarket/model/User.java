package com.estockmarket.stockmarket.model;

import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

import java.io.Serializable;
import java.util.UUID;

@Table("user")
public class User implements Serializable{
    @PrimaryKey
    private UUID id;
    private String name;
    private String email;
    private String password;


    public User(UUID id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email=email;
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
