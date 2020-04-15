package com.company.gaia.Models;

import com.company.gaia.Entities.User;

import java.util.List;

public class RegisterResponse {

    private boolean err;
    private String msg;
    private List<User> users;

    public RegisterResponse(boolean err, String msg, List<User> users) {
        this.err = err;
        this.msg = msg;
        this.users = users;
    }

    public boolean isErr() {
        return err;
    }

    public String getMsg() {
        return msg;
    }

    public List<User> getUsers() {
        return users;
    }
}
