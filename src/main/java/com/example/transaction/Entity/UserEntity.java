package com.example.transaction.Entity;


import org.springframework.context.annotation.Role;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Table(name = "user")
public class UserEntity {

    @org.springframework.data.annotation.Id

    private Long Id;

    @Column()
    private String name;

    @Column()
    private String email;

    @Column()
    private String password;

    @Column()
    private Role role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
