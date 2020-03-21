package com.company.gaia.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.company.gaia.Database.UserBaseHelper;
import com.company.gaia.R;

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
         */
        bLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(register_activity.this,login_activity.class);
                startActivity(i);
            }
        });

        /**
         * Listener for the register button
         * Makes sure no fields are empty, the name is unique and the bot passwords entered match.
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
}
