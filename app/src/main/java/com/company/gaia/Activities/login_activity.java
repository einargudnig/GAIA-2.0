package com.company.gaia.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.company.gaia.Database.UserBaseHelper;
import com.company.gaia.R;

// Fuck this hoe
// import android.support.v4.app.FragmentManager;

public class login_activity extends AppCompatActivity {
    EditText eUsername, ePass;
    Button bLog;
    UserBaseHelper db;

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
        db = new UserBaseHelper(this);
        eUsername = (EditText)findViewById(R.id.mUsername);
        ePass = (EditText)findViewById(R.id.mPass);
        bLog = (Button)findViewById(R.id.mLog);
        bLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = eUsername.getText().toString();
                String password = ePass.getText().toString();
                Boolean chkNamePass = db.ChknamePassword(username, password);

                /**
                 * Check if email and password have been registered.
                 * If so, redirected to user page
                 */
                if (chkNamePass == true) {
                    // Palla fikt
                    // Byrjar user_activity og sendir skrad username med, atm bara med login glugga
                    Intent intent = new Intent(login_activity.this, user_activity.class);
                   // String forwardUser = eUsername.getText().toString();
                   // System.out.println("login_activity user: " + forwardUser);
                   // intent.putExtra("Username", forwardUser);
                    startActivity(intent);

                    // This was used in the early stages of development, good to see if log in works.
                    // Toast.makeText(getApplicationContext(), "Successfully Logged in", Toast.LENGTH_SHORT).show();
                } else {

                    /**
                     * If email and password have not been registered, we return a wrong email/password message.
                     */
                    Toast.makeText(getApplicationContext(), "Wrong username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
