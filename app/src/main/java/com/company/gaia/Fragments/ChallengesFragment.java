package com.company.gaia.Fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.company.gaia.Activities.challenge_activity;
import com.company.gaia.R;

import org.w3c.dom.Text;

public class ChallengesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_challenges, container, false);

        String[] challengesItems = { "Be Omar for a day", "Fart less", "Be vegan for a day", "Stop being a slob",
        "Stop using single use plastics"};
        String[] challengesDesc = { "This is considered to be the most difficult challenge", "This is good for others", "Think of the animals",
                "Being a slob is bad for you", "Single use plastics suck ass"};

        ListView challengeTitle = view.findViewById(R.id.challengeList);

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                challengesItems
        );

        challengeTitle.setAdapter(listViewAdapter);

        challengeTitle.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), challenge_activity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
