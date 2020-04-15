package com.company.gaia.Storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.company.gaia.Models.User;

import java.net.Authenticator;

public class SharedPref {


    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String SHARED_PREF_NAME= "token";
    String SESSION_KEY;

    public SharedPref(Context context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveToken(String token) {

        editor.putString(SESSION_KEY, token).commit();
    }

    public String getToken() {
        return sharedPreferences.getString(SESSION_KEY, null);
    }

    public void removeToke() {
        editor.putString(SESSION_KEY, null).commit();
    }
}
