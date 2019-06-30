package com.example.pair_game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TableActivity extends AppCompatActivity {
    public static  int width,height;
    ArrayList<Card> cards = new ArrayList<Card>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;
        int card_w = (int)(width-50)/4;
        Log.d("SIZE1",width+" "+height+" "+card_w);

        ArrayList<Card> cards = new ArrayList<Card>();
        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        ArrayList<String> ranks=new ArrayList<String>(),suits=new ArrayList<String>(),cardId=new ArrayList<String>();
        ranks.addAll(Arrays.asList(new String[]{"6","7","8","9","10","jack","queen","king","ace"}));
        suits.addAll(Arrays.asList(new String[]{"clubs","diamonds","spades","hearts"}));
        for (String i:suits)
            for (String j:ranks) {
                cardId.add(j + i);
                cards.add(new Card(j,i));
            }
        Collections.shuffle(cards);

        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView;
        final ImageView imageView;
        final CardView border;

        gridView = inflater.inflate(R.layout.card, null);




        Context context = getApplicationContext();


        // добавляем фрагмент
        CardView card = new CardView(context);

        //View v = inflater.inflate(R.layout.activity_table,null);

        LayoutInflater mInflater = LayoutInflater.from(context);
        View mProgressBarFooter = mInflater.inflate(R.layout.card, null, false);
        //textLoader = (TextView) mProgressBarFooter.findViewById(R.id.footer_label);
        for (int i = 0; i < 36; i++) {

        }
    }
}
