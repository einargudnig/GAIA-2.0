package com.company.gaia.Activities;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.company.gaia.Database.UserBaseHelper;
import com.company.gaia.R;

public class user_activity extends AppCompatActivity {

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
    }
}
