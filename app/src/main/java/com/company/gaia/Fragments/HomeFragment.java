package com.company.gaia.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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

    public HomeFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        gaiaAPI = APIclient.getGaiaClient().create(GaiaAPI.class);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        getLoggedIn();

        return view;

        }

    private void getLoggedIn() {
        Call<User> call = gaiaAPI.getLoggedIn();

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if (!response.isSuccessful()) {
                    System.out.println(response.code());
                }

                User user = response.body();


            }


            @Override
            public void onFailure(Call<User> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }
}

