package com.company.gaia.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.company.gaia.R;

public class user_activity extends AppCompatActivity {

    Button bChallenge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
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
