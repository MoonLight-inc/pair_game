package com.example.pair_game;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import androidx.cardview.widget.CardView;

import java.util.ArrayList;
import java.util.Random;

import static com.example.pair_game.TableFragment.card_h;


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

        View gridView = inflater.inflate(R.layout.card, null);
        ImageView imageView = gridView.findViewById(R.id.imageView);
        CardView border = gridView.findViewById(R.id.cardView);

        imageView.setMaxHeight(card_h);

        cards.get(position).setImg(imageView);
        cards.get(position).setBorder(border);

        gridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickFlag)
                    if (card1 == null) {
                        card1 = cards.get(position);
                        flipCard(card1, 500, v, true);
                        card1.getImg().refreshDrawableState();
                    } else if (card1 != cards.get(position)) {
                        clickFlag = false;
                        card2 = cards.get(position);
                        flipCard(card2, 500, v, true);

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
                            clickFlag = true;
                        } else {
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    flipCard(card1, new Random().nextInt(300) + 50, v, false);
                                    flipCard(card2, new Random().nextInt(300) + 150, v, false);
                                    card1 = null;
                                    clickFlag = true;
                                }
                            }, 3000);
                        }
                    }
            }
        });
        return gridView;
    }

    private void flipCard(Card card, int duration, View v, boolean shirt) {
        ObjectAnimator oa1;
        ObjectAnimator oa2;
        oa1 = ObjectAnimator.ofFloat(card.getImg(), "scaleX", 1f, 0f);
        oa2 = ObjectAnimator.ofFloat(card.getImg(), "scaleX", 0f, 1f);
        oa1.setInterpolator(new DecelerateInterpolator());
        oa2.setInterpolator(new AccelerateDecelerateInterpolator());
        oa1.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                card.getImg().setImageResource(v.getContext()
                        .getResources()
                        .getIdentifier(shirt ? "img_" + card.getRank() + "_of_" + card.getSuit() : "shirt",
                                "drawable",
                                context.getPackageName()));
                oa2.start();
            }
        });
        oa1.setDuration(duration);
        oa2.setDuration(duration);
        oa1.start();
    }
}
