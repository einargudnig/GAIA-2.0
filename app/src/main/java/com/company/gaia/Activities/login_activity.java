package com.company.gaia.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.company.gaia.Entities.User;
import com.company.gaia.Models.LoginResponse;
import com.company.gaia.Network.APIclient;
import com.company.gaia.R;
import com.company.gaia.Storage.SharedPref;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login_activity extends AppCompatActivity implements View.OnClickListener {
     private EditText editTextName;
     private EditText editTextPassword;
    /**
     *
     * @param savedInstanceState
     * Main functionality for login.
     * Takes email and password entered to login form and checks
     * if they are already registered to database.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // db = new UserBaseHelper(this);

        editTextName = findViewById(R.id.editTextName);
        editTextPassword = findViewById(R.id.editTextPassword);

        /**
         * Button to log in
         */
        findViewById(R.id.mLog);
    }

    /*
    @Override
    protected void onStart() {

    }
     */

    private void userLogin() {

        String username = editTextName.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (username.isEmpty()) {
            editTextName.setError("Username is required");
            editTextName.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            editTextPassword.setError("Password required");
            editTextPassword.requestFocus();
            return;
        }

        Call<ResponseBody> call = APIclient
                .getInstance()
                .getApi()
                .loginUser(username, password);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                ResponseBody responseBody = response.body();
                System.out.println(responseBody);
                // if Success
                // SharedPref.saveToken(loginResponse.authToken)
                Intent i = new Intent(login_activity.this, user_activity.class);
                startActivity(i);


                //Toast.makeText(login_activity.this, (CharSequence) responseBody, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(login_activity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mLog:
                userLogin();
                break;

        }
    }
}
