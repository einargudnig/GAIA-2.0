package com.company.gaia.Models;

import com.company.gaia.Entities.User;

import java.util.List;

public class RegisterResponse {

    private boolean err;
    private String msg;

    public RegisterResponse(boolean err, String msg) {
        this.err = err;
        this.msg = msg;
    }

    public boolean isErr() {
        return err;
    }

    public String getMsg() {
        return msg;
    }

}
