package com.example.pair_game;

import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static com.example.pair_game.MainActivity.convertDpToPixels;


public class TableFragment extends Fragment {

    public static int width, height;
    public static int card_h;
    public GridView grid;

    public TableFragment() {
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
        View v = inflater.inflate(R.layout.fragment_table, container, false);

        //container.getDisplay().
        Display display = container.getDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;
        Log.d("TAGG", height + " " + width + " DISPLAY");
        card_h = (height - convertDpToPixels(100, container.getContext())) / 4;


        ArrayList<Card> cards = new ArrayList<Card>();
        ArrayList<String> ranks = new ArrayList<String>(), suits = new ArrayList<String>(), cardId = new ArrayList<String>();
        ranks.addAll(Arrays.asList("6", "7", "8", "9", "10", "jack", "queen", "king", "ace"));
        suits.addAll(Arrays.asList("clubs", "diamonds", "spades", "hearts"));
        for (String i : suits)
            for (String j : ranks) {
                cardId.add(j + i);
                cards.add(new Card(j, i));
            }
        Collections.shuffle(cards);


        grid = v.findViewById(R.id.grid1);
        GridAdapter gridAdapter = new GridAdapter(v.getContext(), cards);
        grid.setAdapter(gridAdapter);
        return v;
    }


}
