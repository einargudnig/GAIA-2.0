package com.company.gaia.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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
    // private ListView textViewUser;
    public ArrayList<String> userList = new ArrayList<String>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        gaiaAPI = APIclient.getGaiaClient().create(GaiaAPI.class);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        TextView textViewUser = view.findViewById(R.id.textViewUser);
        System.out.println("Sup ert inní HomeFragment");
        // getUsername();

        // tv.setText("uti getArgu");

        System.out.println("inside homefragment");
        System.out.println("getArguments: " + this.getArguments());
        if (getArguments() != null) {
            System.out.println("getArguments ekki null");
            String name = getArguments().getString("Username");
            System.out.println("homefragment name: " + name);

            textViewUser.setText("Welcome " + name);

        }


        return view;

    }
/*
    private void getUsername() {
        System.out.println("ert inní getUsername");
        Call<List<User>> call = gaiaAPI.getUsers();
        System.out.println("Herna er callið: " + call);

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                System.out.println("inside onResponse in HomeFragment");

                if (!response.isSuccessful()) {
                    System.out.println("no response found my guy");
                }

                List<User> users = response.body();

                for (User user : users) {
                    System.out.println(user.getuname());
                    userList.add(user.getuname());
                }

                ArrayAdapter<String> userAdapter =
                        new ArrayAdapter<String>(getActivity(), R.layout.activity_user, R.id.textViewUser, userList){
                            @Override
                            public View getView(int position, View convertView, ViewGroup parent) {
                                View view = super.getView(position, convertView, parent);
                                TextView textViewUser = view.findViewById(R.id.textViewUser);

                                textViewUser.setText(users.get(position).getName());
                                return view;
                            }
                        };

               textViewUser.setAdapter(userAdapter);

            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });

 */
    //}
}
