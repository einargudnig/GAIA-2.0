package com.company.gaia.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.company.gaia.R;

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        TextView tv = (TextView) view.findViewById(R.id.textViewUser);
        // tv.setText("uti getArgu");

        System.out.println("inside homefragment");
        System.out.println("getArguments: " + getArguments());
        if (getArguments() != null) {
            System.out.println("getArguments ekki null");
            String name = getArguments().getString("Username");
            System.out.println("homefragment name: " + name);

            tv.setText("Welcome " + name);

        }

        return view;


    }
}
