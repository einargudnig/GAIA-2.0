package com.company.gaia.Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.company.gaia.Entities.Challenge;
import com.company.gaia.Entities.User;
import com.company.gaia.Network.APIclient;
import com.company.gaia.Network.GaiaAPI;
import com.company.gaia.R;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchFragments extends Fragment {

    private ListView lstSearch;
    private EditText txtSearch;
    public ArrayList<String> userList = new ArrayList<String>();
    public ArrayList<Double> scoreList = new ArrayList<Double>();
    public GaiaAPI gaiaAPI;
    private ArrayAdapter<String> userAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        gaiaAPI = APIclient.getGaiaClient().create(GaiaAPI.class);
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        lstSearch = view.findViewById(R.id.lstSearch);
        txtSearch = view.findViewById(R.id.searchText);
        getUsers();
        return view;
    }

    private void getUsers() {
        Call<List<User>> call = gaiaAPI.getUsers();

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                if (!response.isSuccessful()) {
                    System.out.println("No bueno!");
                }

                List<User> users = response.body();

                for (User user : users) {
                    userList.add(user.getuname());
                    scoreList.add(user.getCurrIndex());
                }

                userAdapter = new ArrayAdapter<String>(getActivity(), R.layout.custom_simple_list_item_2, R.id.text1, userList){
                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {
                        View view = super.getView(position, convertView, parent);

                        User currUser = users.get(position);
                        TextView text1 = view.findViewById(R.id.text1);

                        TextView text2 = view.findViewById(R.id.text2);
                        Double d = currUser.getOriginalIndex();
                        String str = d + "";

                        String search = txtSearch.getText().toString();
                        for(int i = 0; i < userList.size(); i++) {
                            if(search == userList.get(i)) {
                                text1.setText(users.get(position).getuname());
                                text2.setText(scoreList.get(position).toString());
                            }
                        }
                        return view;
                    }
                };

                lstSearch.setAdapter(userAdapter);

                txtSearch.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        userAdapter.getFilter().filter(s);
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });

            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }
}
/**
 userAdapter = new ArrayAdapter<User>(getActivity(), R.layout.custom_simple_list_item_2, R.id.text1, users){
@Override
public View getView(int position, View convertView, ViewGroup parent) {
View view = super.getView(position, convertView, parent);

TextView text1 = view.findViewById(R.id.text1);
TextView text2 = view.findViewById(R.id.text2);

String search = txtSearch.getText().toString();
for(int i = 0; i < userList.size(); i++) {
if(search == userList.get(i)) {
text1.setText(users.get(position).getuname());
double d = users.get(position).getCurrIndex();
String str = d + "";
text2.setText(str);


}
}

return view;
}
};
 **/