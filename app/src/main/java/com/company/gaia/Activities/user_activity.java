package com.company.gaia.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.company.gaia.R;

public class user_activity extends AppCompatActivity {

    Button bChallenge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        String Username = getIntent().getStringExtra("Username");

        TextView tv = (TextView)findViewById(R.id.tvUsername);
        tv.setText(Username);

    }

    public void display(View v) {
        // Cursor c = UserBaseHelper.getAllData();
        bChallenge = (Button)findViewById(R.id.mChallenge);
        bChallenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(user_activity.this, challenge_activity.class);
                startActivity(i);
            }
        });
    }
}
