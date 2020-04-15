package com.company.gaia.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.company.gaia.Fragments.ChallengesFragment;
import com.company.gaia.Fragments.HomeFragment;
import com.company.gaia.Fragments.SearchFragments;
import com.company.gaia.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class user_activity extends AppCompatActivity {

    // Commented out the button that redirected to the challenge acticity..
    // I think it is better to use fragments for the three pages we will most be using(user, challenges, search)
    // Button bChallenge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        // Code to get the logged in userName and display.
        //String Username = getIntent().getStringExtra("Username");
        //TextView tv = (TextView)findViewById(R.id.tvUsername);
        //tv.setText(Username);

        // For bottom navigation
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        // Added the is statement to keep the selected fragment when rotating device
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
        }
    }

        private BottomNavigationView.OnNavigationItemSelectedListener navListener =
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;

                        switch (item.getItemId()) {
                            case R.id.nav_home:
                                selectedFragment = new HomeFragment();
                                break;
                            case R.id.nav_favorites:
                                selectedFragment = new ChallengesFragment();
                                break;
                            case R.id.nav_search:
                                selectedFragment = new SearchFragments();
                                break;
                            default:
                                throw new IllegalStateException("Unexpected value: " + item.getItemId());
                        }

                        int commit = getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                selectedFragment).commit();

                        return true;
                    }
                };

    public void display(View v) {
        // Cursor c = UserBaseHelper.getAllData();
        /* bChallenge = (Button)findViewById(R.id.mChallenge);
        bChallenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(user_activity.this, challenge_activity.class);
                startActivity(i);
            }
        }); */
    }
}
