package com.company.gaia.Fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.company.gaia.Activities.challenge_activity;
import com.company.gaia.Entities.Challenge;
import com.company.gaia.Network.APIclient;
import com.company.gaia.Network.GaiaAPI;
import com.company.gaia.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChallengesFragment extends Fragment {

    public GaiaAPI gaiaAPI;
    private ListView challengeList;
    public  ArrayList<String> titleList = new ArrayList<String>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        gaiaAPI = APIclient.getGaiaClient().create(GaiaAPI.class);
        View view = inflater.inflate(R.layout.fragment_challenges, container, false);
        challengeList = view.findViewById(R.id.challengeList);
        getChallenges();
        return view;
    }

    private void getChallenges() {
        Call<List<Challenge>> call = gaiaAPI.getChallenges();

        call.enqueue(new Callback<List<Challenge>>() {
            @Override
            public void onResponse(Call<List<Challenge>> call, Response<List<Challenge>> response) {

                if (!response.isSuccessful()) {
                    System.out.println("No bueno!");
                }

                List<Challenge> challenges = response.body();
                for (Challenge challenge: challenges) {
                    titleList.add(challenge.getTitle());
                }

                ArrayAdapter<String> challengeAdapter =
                        new ArrayAdapter<String>(getActivity(), R.layout.challenge_view, titleList);
                challengeList.setAdapter(challengeAdapter);
            }

            @Override
            public void onFailure(Call<List<Challenge>> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }

}