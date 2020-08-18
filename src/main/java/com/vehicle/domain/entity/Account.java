package com.vehicle.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Entity Account class
 */
@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Email(message = "Value is not valid email format")
    private String username;

    @Size(min = 8, max = 8,message = "Password should be with 8 characters ")
    private String password;

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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
