package com.company.gaia.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.company.gaia.Database.UserBaseHelper;
import com.company.gaia.Entities.Challenge;
import com.company.gaia.Entities.User;
import com.company.gaia.Network.APIclient;
import com.company.gaia.Network.GaiaAPI;
import com.company.gaia.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class register_activity extends AppCompatActivity {
    UserBaseHelper db;
    EditText eName, eEmail, ePass, eCPass;
    Button bReg, bLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db = new UserBaseHelper(this);
        eName = (EditText)findViewById(R.id.mName);
        eEmail = (EditText)findViewById(R.id.mEmail);
        ePass = (EditText)findViewById(R.id.mPassword);
        eCPass = (EditText)findViewById(R.id.mCPassword);
        bReg = (Button)findViewById(R.id.mRegister);
        bLog = (Button)findViewById(R.id.mLogin);

        /**
         * Listener activity for the log in button
         * starts a new activity with intent. opens the login activity.
        **/
        bLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(register_activity.this,login_activity.class);
                startActivity(i);
            }
        });


        /**
         * Listener for the register button
         * Makes sure no fields are empty, the name is unique and the both passwords entered match.
         */

        bReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = eName.getText().toString();
                String s2 = eEmail.getText().toString();
                String s3 = ePass.getText().toString();
                String s4 = eCPass.getText().toString();
                if (s1.equals("") || s2.equals("") || s3.equals("") || s4.equals("")) {
                    Toast.makeText(getApplicationContext(),"Fields are empty", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (s3.equals(s4)) {
                        Boolean chkName = db.chkName(s1);
                        if (chkName == true) {
                            Boolean insert = db.insert(s1, s2, s3);
                            if (insert == true) {
                                // Here is the plan to make a new activity 'pop up' with intent.
                                // This activity has all the questions for users to answer.
                                Intent i = new Intent(register_activity.this, carbon_activity.class);
                                //startActivity(i);

                                String forwardUser = eName.getText().toString();
                                System.out.println("register_activity user: " + forwardUser);
                                i.putExtra("Username", forwardUser);
                                startActivity(i);


                                //Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Email Already exists", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Password do not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
    //ATHATH Commented it all out just for testing !
    private GaiaAPI gaiaAPI;

    private TextView textViewResult;
    //private TextView mName;
    //private TextView mEmail;

    /**
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        textViewResult = findViewById(R.id.text_view_result);

        //mName = findViewById(R.id.tvName);
        //mEmail = findViewById(R.id.tvEmail);

        gaiaAPI = APIclient.getGaiaClient().create(GaiaAPI.class);

        //getUsers();
        getChallenges();
        //loginUser();
    } **/

    private void getUsers() {
        Call<List<User>> call = gaiaAPI.getUsers();

            call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                if (!response.isSuccessful()) {
                    System.out.println("No bueno!");
                }

                List<User> users = response.body();

                for (User user: users) {
                    String content ="";
                    content += "Name: " + user.getName();

                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }

    /* Get Challenges from API */
    /**
    private void getChallenges() {
        Call<List<Challenge>> call = gaiaAPI.getChallenges();

        call.enqueue(new Callback<List<Challenge>>() {
            @Override
            public void onResponse(Call<List<Challenge>> call, Response<List<Challenge>> response) {

                if (!response.isSuccessful()) {
                    System.out.println("No bueno!");
                }

                List<Challenge> challenges = response.body();

                for (Challenge challenge: challenges) {
                    String content ="";
                    content += "Title: " + challenge.getTitle();
                    content += "Description: " + challenge.getDescription();

                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Challenge>> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }
**/


    /*
    loginUser() {
        User user = new User("Einar", "ranie");

        Call<User> call = gaiaAPI.loginUser(user);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                User userResponse = response.body();

                String content ="";
                content += "Code: " + response.code() + "\n";
                content += "Name: " + userResponse.getName() + "\n";
                content += "User Password: " + userResponse.getPassword() + "\n";

                textViewResult.setText(content);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    } */

}
