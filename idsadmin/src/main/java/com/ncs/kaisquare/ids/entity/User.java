package com.ncs.kaisquare.ids.entity;

import com.ncs.kaisquare.ids.utils.SnowFlake;
import com.ncs.kaisquare.ids.utils.Util;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection="User")
public class User extends DataEntity{
    @Indexed
    private String username;
    private String password;
    private String role;

    public User() {
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public void encriptPassword(){
        this.password = Util.encryptPassword(this.password);
    }
}
