package com.translog.user.dto;

public class LoginDTO {
    
    private Integer userId;
    private String password;

    public Integer getUserName() { return this.userId; }

    public void setUserName(Integer userId) { this.userId = userId; }

    public String getPassword() { return this.password; }

    public void setPassword(String password) { this.password = password; }
}
