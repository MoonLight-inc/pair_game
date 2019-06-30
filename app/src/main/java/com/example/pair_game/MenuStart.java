package com.example.pair_game;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;



public class MenuStart extends Fragment {
    public MenuStart() {
        // Required empty public constructor
    }
    Button btn_single;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_menustart, container, false);
        btn_single = (Button)view.findViewById(R.id.button);
        btn_single.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_start_menu_to_single_game_menu, null));
        return view;
    }
}
