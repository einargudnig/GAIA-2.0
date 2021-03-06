package com.company.gaia.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.company.gaia.Database.UserBaseHelper;
import com.company.gaia.Entities.User;
import com.company.gaia.Models.LoginRequest;
import com.company.gaia.Models.LoginResponse;
import com.company.gaia.Network.APIclient;
import com.company.gaia.Network.GaiaAPI;
import com.company.gaia.R;
import com.company.gaia.Storage.SharedPref;

import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// Fuck this hoe
// import android.support.v4.app.FragmentManager;

public class login_activity extends AppCompatActivity implements View.OnClickListener {

    private GaiaAPI gaiaAPI;
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
        gaiaAPI = APIclient.getGaiaClient().create(GaiaAPI.class);
        setContentView(R.layout.activity_login);

        editTextName = findViewById(R.id.editTextName);
        editTextPassword = findViewById(R.id.editTextPassword);

        /**
         * Button to log in
         */
        findViewById(R.id.mLog).setOnClickListener(this);
    }

    /*
    @Override
    protected void onStart() {

    }
     */


    /**
     * Validation of the log in inputs.
     * Gaia is good at security  ᕙ(⇀‸↼‶)ᕗ
     */
    private void userLogin() {
        String username = editTextName.getText().toString();
        String password = editTextPassword.getText().toString();

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

        /**
         * API call
         * POST request on /authenticate
         * Can be located in GaiaAPI class
         */

        // Changed to use HashMap!
        HashMap<String, String> body = new HashMap<>();

        body.put("username", username);
        body.put("password", password);

        Call<LoginResponse> call = gaiaAPI.loginUser(body);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                LoginResponse responseLogin = response.body();
                System.out.println(responseLogin);
                // if Success
                // SharedPref.saveToken(loginResponse.authToken)
                Intent i = new Intent(login_activity.this, user_activity.class);
                i.putExtra("Username", username);
                startActivity(i);



                //Toast.makeText(login_activity.this, (CharSequence) responseBody, Toast.LENGTH_LONG).show();

            }


            public void onFailure(Call<LoginResponse> call, Throwable t) {
                System.out.println(t.getMessage());
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
