package com.example.pair_game;


import android.widget.ImageView;

import androidx.cardview.widget.CardView;

public class Card {
    private String rank;
    private String suit;
    private ImageView img;
    private CardView border;
    private String flag;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    private int position;


    public CardView getBorder() {
        return border;
    }

    public void setBorder(CardView border) {
        this.border = border;
    }

    public Card(String rank, String suit){
        this.rank=rank;
        this.suit=suit;
        if ((suit=="diamonds")||(suit=="hearts")){
            this.flag=rank+"red";
        }else{
            this.flag=rank+"black";
        }
    }

    public void setImg(ImageView img) {
        this.img = img;
    }

    public String getFlag() {
        return flag;
    }
    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public ImageView getImg() {
        return img;
    }
}
