package com.company.gaia.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.company.gaia.Activities.login_activity;
import com.company.gaia.Activities.register_activity;
import com.company.gaia.R;

import com.company.gaia.Activities.user_activity;
import com.company.gaia.Entities.User;
import com.company.gaia.Network.APIclient;
import com.company.gaia.Network.GaiaAPI;
import com.company.gaia.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    public GaiaAPI gaiaAPI;
    private ListView usernameTxt;
    public ArrayAdapter<String> userAdapter;
    private TextView loggedUser;
    private TextView loggedBio;
    private TextView loggedScore;

    public HomeFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        gaiaAPI = APIclient.getGaiaClient().create(GaiaAPI.class);
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        loggedUser = view.findViewById(R.id.text_userName);
        loggedBio = view.findViewById(R.id.text_userBio);
        loggedScore = view.findViewById(R.id.text_userScore);

        Button button = view.findViewById(R.id.button_logout);

        getLoggedIn();

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), register_activity.class);
                startActivity(intent);
            }
        });

        return view;

        }

    private void getLoggedIn() {
        if (getArguments() != null) {
            String name = getArguments().getString("Username");

            loggedUser.setText(name);
        }

        Call<List<User>> call = gaiaAPI.getUsers();

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                if (!response.isSuccessful()) {
                    System.out.println("No bueno!");
                }

                List<User> users = response.body();
                User myUser = new User();

                for (User user : users) {
                    if(user.getuname().equals(loggedUser.getText())){
                        myUser = user;
                    }
                }

                loggedUser.setText("Welcome " + myUser.getuname());
                loggedBio.setText(myUser.getUserInfo());
                Double d = myUser.getCurrIndex();
                String str = d + "";
                loggedScore.setText(str);

            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }
}

