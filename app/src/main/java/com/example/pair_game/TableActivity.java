package com.example.pair_game;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static com.example.pair_game.MainActivity.convertDpToPixels;

public class TableActivity extends AppCompatActivity {
    public static  int width,height;
    public static int card_h;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;

        card_h = (height - convertDpToPixels(100, this)) / 4;
        ArrayList<Card> cards = new ArrayList<Card>();
        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        ArrayList<String> ranks=new ArrayList<String>(),suits=new ArrayList<String>(),cardId=new ArrayList<String>();
        ranks.addAll(Arrays.asList("6", "7", "8", "9", "10", "jack", "queen", "king", "ace"));
        suits.addAll(Arrays.asList("clubs", "diamonds", "spades", "hearts"));
        for (String i:suits)
            for (String j:ranks) {
                cardId.add(j + i);
                cards.add(new Card(j,i));
            }
        Collections.shuffle(cards);
        GridAdapter mAdapter;
        GridView gvMain;
        mAdapter=new GridAdapter(this,cards);
        gvMain = findViewById(R.id.grid);
        gvMain.setAdapter(mAdapter);
//        LayoutInflater mInflater = LayoutInflater.from(getApplicationContext());
//        View cardv = mInflater.inflate(R.layout.card, null);
//        int card_w=(int)(card_h*7)/10;
//        //cardv.setLayoutParams(new CardView.LayoutParams(card_w,card_h));
//        FrameLayout frameLayout = (FrameLayout)findViewById(R.id.frame);
//        frameLayout.addView(cardv,new ViewGroup.LayoutParams(card_w,card_h));



        for (int i = 0; i < 36; i++) {

        }
    }
}
