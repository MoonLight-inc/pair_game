package com.example.pair_game;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import static com.example.pair_game.MainActivity.btn_back;


public class MenuSingle extends Fragment {

    public MenuSingle() {
        // Required empty public constructor
    }
    Button btn_hardcore;
    Button btn_normal;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_menusingle, container, false);
        btn_hardcore = v.findViewById(R.id.button2);
        btn_hardcore.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_single_game_menu_to_table2, null));
//        btn_normal = v.findViewById(R.id.button);
//        btn_normal.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_single_game_menu_to_table2));

        YoYo.with(Techniques.Bounce)
                .duration(3000)
                .delay(1000)
                .repeat(-1)
                .playOn(btn_hardcore);

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        btn_back.setVisibility(View.VISIBLE);
        btn_back.setClickable(true);
    }

}
