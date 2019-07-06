
package com.example.pair_game;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class GameActivity extends AppCompatActivity {
    public static int width, height;
    public static int card_h;

    public static int convertDpToPixels(float dp, Context context) {
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
        return px;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Navigation
                .findNavController(this, R.id.fragment_game)
                .navigate(R.id.solo_toolbar2);
        System.out.println(getIntent().getStringExtra("mode"));


        //String myArgument = SecondFragmentArgs.fromBundle(getArguments()).getMyArgument();
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;

        card_h = (height - convertDpToPixels(70, this)) / 4;
        ArrayList<Card> cards = new ArrayList<Card>();
        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        ArrayList<String> ranks = new ArrayList<String>(), suits = new ArrayList<String>(), cardId = new ArrayList<String>();
        ranks.addAll(Arrays.asList("6", "7", "8", "9", "10", "jack", "queen", "king", "ace"));
        suits.addAll(Arrays.asList("clubs", "diamonds", "spades", "hearts"));
        for (String i : suits)
            for (String j : ranks) {
                cardId.add(j + i);
                cards.add(new Card(j, i));
            }
        Collections.shuffle(cards);
        GridAdapter mAdapter;
        GridView gvMain;
        mAdapter = new GridAdapter(this, cards);
        gvMain = findViewById(R.id.grid_solo);
        gvMain.setAdapter(mAdapter);

    }
}
