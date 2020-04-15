package com.company.gaia.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.company.gaia.Entities.Challenge;
import com.company.gaia.Entities.User;
import com.company.gaia.Network.APIclient;
import com.company.gaia.Network.GaiaAPI;
import com.company.gaia.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class register_activity extends AppCompatActivity implements View.OnClickListener{

    //UserBaseHelper db;
    private EditText editTextUName, editTextEmail, editTextPassword, editTextCPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextUName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextCPassword = findViewById(R.id.editTextCPassword);


        /**
         * Both buttons on the register screen
         */
        findViewById(R.id.mLogin).setOnClickListener(this);
        findViewById(R.id.mRegister).setOnClickListener(this);
    }

    /*
        @Override
        protected void onStart() {
        super.onStart();
        /**
         *  TODO: put in code for shared preferences.

    }*/



    /**
     * Validation of the register inputs.
     * Gaia is good at security  ᕙ(⇀‸↼‶)ᕗ
     */
    private void userSignUp() {
        String username = editTextUName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String cPassword = editTextCPassword.getText().toString().trim();

        if (username.isEmpty()) {
            editTextUName.setError("Name required");
            editTextUName.requestFocus();
            return;
        }

        if (email.isEmpty()) {
            editTextEmail.setError("Email required");
            editTextEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Enter a valid email");
            editTextEmail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            editTextPassword.setError("Password required");
            editTextPassword.requestFocus();
            return;
        }

        if (!cPassword.matches(password)) {
            editTextCPassword.setError("Passwords do not match");
            editTextCPassword.requestFocus();
            return;
        }

        /**
         * API call
         * POST request on /register
         * Can be located in GaiaAPI class
         */
        Call<User> call = APIclient
                .getInstance()
                .getApi()
                .registerUser(username, email, password);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.code() == 201) {

                    User user = response.body();
                    System.out.println(user);
                    // If user is successfully registered we redirect to login screen.
                    Intent i = new Intent(register_activity.this, login_activity.class);
                    startActivity(i);

                } else if (response.code() == 422) {
                    Toast.makeText(register_activity.this, "User already exists", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

                Toast.makeText(register_activity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                ;
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mRegister:

                userSignUp();
                break;

            case R.id.mLogin:

                Intent i = new Intent(register_activity.this,login_activity.class);
                startActivity(i);

                break;

        }
    }

}
