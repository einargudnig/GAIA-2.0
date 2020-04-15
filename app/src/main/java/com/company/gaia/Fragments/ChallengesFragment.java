package com.company.gaia.Fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
// import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.company.gaia.Activities.challenge_activity;
import com.company.gaia.Entities.Challenge;
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

public class ChallengesFragment extends Fragment {

    public GaiaAPI gaiaAPI;
    private ListView challengeList;
    public  ArrayList<String> titleList = new ArrayList<String>();
    public  ArrayList<String> descList = new ArrayList<String>();


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
                    descList.add(challenge.getDescription());
                }

                ArrayAdapter<String> challengeAdapter =
                        new ArrayAdapter<String>(getActivity(), R.layout.custom_simple_list_item_2, R.id.text1, titleList){
                        @Override
                        public View getView(int position, View convertView, ViewGroup parent) {
                            View view = super.getView(position, convertView, parent);
                            TextView text1 = view.findViewById(R.id.text1);
                            TextView text2 = view.findViewById(R.id.text2);

                            text1.setText(challenges.get(position).getTitle());
                            text2.setText(challenges.get(position).getDescription());
                            return view;
                        }
                };

                challengeList.setAdapter(challengeAdapter);

                challengeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                        builder.setTitle("Viltu taka þessari áskorun?");
                        builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //TODO
                                //Assign challenge here tenging við db
                                dialog.dismiss();
                            }
                        });
                        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });
            }

            @Override
            public void onFailure(Call<List<Challenge>> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }

}