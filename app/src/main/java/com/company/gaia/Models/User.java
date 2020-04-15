package com.company.gaia.Models;

public class User {
    private int id;
    private String UName;
    private String password;
    private String token;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUName() {
        return UName;
    }

    public void setUName(String UName) {
        this.UName = UName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
