package com.translog.user.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ftr_login")
public class Login {
    @Id
    private String userName;
    private String password;

    public String getUserName() { return this.userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public String getPassword() { return this.password; }

    public void setPassword(String password) { this.password = password; }
    
}
