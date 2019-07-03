package com.example.pair_game.main_frag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.pair_game.R;

public class MenuPVP extends Fragment {

    public MenuPVP() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menupvp, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
//        btn_back.setVisibility(View.VISIBLE);
//        btn_back.setClickable(true);
    }
}
