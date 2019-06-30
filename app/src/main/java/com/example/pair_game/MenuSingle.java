package com.example.pair_game;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MenuSingle extends Fragment {

    public MenuSingle() {
        // Required empty public constructor
    }
    Button btn_hardcore;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_menusingle, container, false);


        btn_hardcore = (Button)v.findViewById(R.id.button2);
        btn_hardcore.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_single_game_menu_to_tableActivity, null));

        return v;
    }




}
