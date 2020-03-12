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

public class login_activity extends AppCompatActivity {
    EditText eEmail, ePass;
    Button bLog;
    UserBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new UserBaseHelper(this);
        eEmail = (EditText)findViewById(R.id.mEmail);
        ePass = (EditText)findViewById(R.id.mPass);
        bLog = (Button)findViewById(R.id.mLog);
        bLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = eEmail.getText().toString();
                String password = ePass.getText().toString();
                Boolean chkEmailPass = db.emailpassword(email, password);
                if (chkEmailPass == true) {
                    Intent i = new Intent(login_activity.this, user_activity.class);
                    startActivity(i);
                    //Toast.makeText(getApplicationContext(), "Successfully Logged in", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong email or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
