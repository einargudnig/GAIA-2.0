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
import com.company.gaia.Models.RegisterResponse;
import com.company.gaia.Network.APIclient;
import com.company.gaia.Network.GaiaAPI;
import com.company.gaia.R;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class register_activity extends AppCompatActivity implements View.OnClickListener{

    private GaiaAPI gaiaAPI;
    private EditText editTextUName, editTextEmail, editTextPassword, editTextCPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gaiaAPI = APIclient.getGaiaClient().create(GaiaAPI.class);
        setContentView(R.layout.activity_register);

        editTextUName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextCPassword = findViewById(R.id.editTextCPassword);

         /* Both buttons on the register screen */
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

        // HashMap for the win
        HashMap<String, String> userBody = new HashMap<>();

        userBody.put("username", username);
        userBody.put("email", email);
        userBody.put("password", password);

        Call<RegisterResponse> call = gaiaAPI.registerUser(userBody);

        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {

                if (response.code() == 201) {
                    RegisterResponse registerResponse = response.body();
                    System.out.println(registerResponse);
                    // If user is successfully registered we redirect to login screen.
                    Intent i = new Intent(register_activity.this, login_activity.class);

                    String forwardUser = username;
                    System.out.println("register_activity user: " + forwardUser);
                    i.putExtra("Username", forwardUser);
                    startActivity(i);

                    startActivity(i);

                } else if (response.code() == 422) {
                    Toast.makeText(register_activity.this, "User already exists", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                System.out.println(t.getMessage());
                Toast.makeText(register_activity.this, t.getMessage(), Toast.LENGTH_LONG).show();
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
