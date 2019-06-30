package com.example.pair_game;

import android.content.Context;
import android.os.Handler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import androidx.cardview.widget.CardView;

import java.util.ArrayList;


public class GridAdapter extends BaseAdapter {

    public Card card1, card2;
    private Context context;
    private ArrayList<Card> cards;
    public Handler handler = new Handler();
    boolean clickFlag = true;

    public GridAdapter(Context context, ArrayList<Card> cards) {
        super();
        this.context = context;
        this.cards = cards;
    }

    @Override
    public int getCount() {
        return cards.size();
    }

    @Override
    public Object getItem(int position) {
        return cards.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView;
        final ImageView imageView;
        final CardView border;

        gridView = inflater.inflate(R.layout.card, null);
        imageView = (ImageView) gridView
                .findViewById(R.id.imageView);
        border = (CardView) gridView
                .findViewById(R.id.cardView);

        cards.get(position).setImg(imageView);
        cards.get(position).setBorder(border);
        gridView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //if (clickFlag)
                    if (card1 == null) {
                        cards.forEach(card -> card.getImg().setImageResource(context.getResources()
                                            .getIdentifier("shirt",
                                                    "drawable",
                                                    context.getPackageName())));
                        card1 = cards.get(position);
                        card1.setPosition(position);
                        card1.getImg().setImageResource(v.getContext()
                                .getResources()
                                .getIdentifier("img_" + cards.get(position).getRank() + "_of_" + cards.get(position).getSuit(),
                                        "drawable",
                                        context.getPackageName()));
                        card1.getImg().refreshDrawableState();
                    } else if (card1 != cards.get(position)) {
                        clickFlag = false;
                        card2 = cards.get(position);
                        card2.setPosition(position);
                        card2.getImg().setImageResource(0);
                        card2.getImg().setImageResource(v.getContext()
                                .getResources()
                                .getIdentifier("img_" + cards.get(position).getRank() + "_of_" + cards.get(position).getSuit(),
                                        "drawable",
                                        context.getPackageName()));
                        card2.getImg().refreshDrawableState();
                        card2.getImg().invalidate();
                        card2.getImg().postInvalidate();

                        if ((card1.getRank() == card2.getRank()) &&
                                (((card1.getSuit() == "hearts") && (card2.getSuit() == "diamonds")) ||
                                        ((card1.getSuit() == "diamonds") && (card2.getSuit() == "hearts")) ||
                                        ((card1.getSuit() == "clubs") && (card2.getSuit() == "spades")) ||
                                        ((card1.getSuit() == "spades") && (card2.getSuit() == "clubs")))) {
                            card1.getImg().setVisibility(View.INVISIBLE);
                            card1.getBorder().setVisibility(View.INVISIBLE);
                            card1.getImg().setClickable(false);
                            card2.getImg().setVisibility(View.INVISIBLE);
                            card2.getBorder().setVisibility(View.INVISIBLE);
                            card2.getImg().setClickable(false);
                        } else {
//                            handler.postDelayed(new Runnable() {
//                                @Override
//                                public void run() {
//                                    clickFlag = true;
//                                    card1.getImg().setImageResource(context.getResources()
//                                            .getIdentifier("shirt",
//                                                    "drawable",
//                                                    context.getPackageName()));
//                                    card2.getImg().setImageResource(context.getResources()
//                                            .getIdentifier("shirt",
//                                                    "drawable",
//                                                    context.getPackageName()));
                                    card1 = null;
//                                }
//                            }, 3000);
//
                        }
                    }
            }
        });


//            @Override
//            public void onClick(View v) {
//                if (card1 == null) {
//                    card1 = cards.get(position);
//                    //card1.getBorder().setCardBackgroundColor(Color.RED);
//                    card1.getImg().setImageResource(context
//                            .getResources()
//                            .getIdentifier("img_" + cards.get(position).getRank() + "_of_" + cards.get(position).getSuit(),
//                                    "drawable",
//                                    context.getPackageName()));
//                } else {
//                    //card1.getBorder().setCardBackgroundColor(0);
//                    card2 = cards.get(position);
//                    card2.getImg().setImageResource(context
//                            .getResources()
//                            .getIdentifier("img_" + cards.get(position).getRank() + "_of_" + cards.get(position).getSuit(),
//                                    "drawable",
//                                    context.getPackageName()));
//                    if (card1 != card2) {
//                        if (card1.getRank() == card2.getRank())
//                            if (((card1.getSuit() == "hearts") && (card2.getSuit() == "diamonds")) ||
//                                    ((card1.getSuit() == "diamonds") && (card2.getSuit() == "hearts")) ||
//                                    ((card1.getSuit() == "clubs") && (card2.getSuit() == "spades")) ||
//                                    ((card1.getSuit() == "spades") && (card2.getSuit() == "clubs"))) {
//                                card1.getImg().setVisibility(View.INVISIBLE);
//                                card1.getBorder().setVisibility(View.INVISIBLE);
//                                card1.getImg().setClickable(false);
//                                card2.getImg().setVisibility(View.INVISIBLE);
//                                card2.getBorder().setVisibility(View.INVISIBLE);
//                                card2.getImg().setClickable(false);
//                                card1.getBorder().setCardBackgroundColor(0);
//                                card1 = null;
//                                //imageView.setImageResource(0);
//                            }
//                    } else {
//                        card1 = null;
//                    }
//                    card1=null;
//                    cards.forEach(i -> i.getImg().setImageResource(context.getResources()
//                            .getIdentifier("shirt",
//                                    "drawable",
//                                    context.getPackageName())));
//                }
//            }
//        });
        return gridView;
    }

    public Card openCard(int position) {
        Card card;
        card = cards.get(position);
        card.getImg().setImageResource(context
                .getResources()
                .getIdentifier("img_" + cards.get(position).getRank() + "_of_" + cards.get(position).getSuit(),
                        "drawable",
                        context.getPackageName()));
        return card;
    }
}
