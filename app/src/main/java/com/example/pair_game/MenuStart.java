package com.example.pair_game;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import static com.example.pair_game.MainActivity.btn_back;


public class MenuStart extends Fragment {
    public MenuStart() {
        // Required empty public constructor
    }

    private Button btn_single;
    private Button btn_multi;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_menustart, container, false);
        btn_single = view.findViewById(R.id.button);
        btn_single.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_start_menu_to_single_game_menu, null));
        btn_multi = view.findViewById(R.id.button2);
        btn_multi.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_start_menu_to_pvp_game_menu, null));

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(5000);
        animatorSet.playTogether(
                ObjectAnimator.ofFloat(btn_single, "scaleX", 1, 0.9f, 0.9f, 1.1f, 1.1f, 1.1f, 1.1f, 1.1f, 1.1f, 1),
                ObjectAnimator.ofFloat(btn_single, "scaleY", 1, 0.9f, 0.9f, 1.1f, 1.1f, 1.1f, 1.1f, 1.1f, 1.1f, 1),
                ObjectAnimator.ofFloat(btn_single, "rotation", 0, -3, -3, 3, -3, 3, -3, 3, -3, 0),
                ObjectAnimator.ofArgb(btn_single, "textColor", Color.WHITE, Color.RED, Color.GRAY, Color.GREEN, Color.WHITE, Color.RED, Color.GRAY, Color.GREEN));
        animatorSet.addListener(new AnimatorListenerAdapter() {
            private boolean mCanceled;

            @Override
            public void onAnimationStart(Animator animation) {
                mCanceled = false;
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                mCanceled = true;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (!mCanceled) {
                    animation.start();
                }
            }
        });
        animatorSet.start();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        btn_back.setVisibility(View.GONE);
        btn_back.setClickable(false);
    }
}
