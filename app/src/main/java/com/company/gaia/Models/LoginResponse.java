package com.company.gaia.Models;

import com.company.gaia.Entities.User;

public class LoginResponse {

    private String token;

    public LoginResponse() {

    }

    public LoginResponse(String token) {

    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
