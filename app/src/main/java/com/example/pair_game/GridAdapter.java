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

import static com.example.pair_game.TableActivity.card_h;


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
        imageView = gridView
                .findViewById(R.id.imageView);


        imageView.setMaxHeight(card_h);
        border = gridView
                .findViewById(R.id.cardView);

        cards.get(position).setImg(imageView);
        cards.get(position).setBorder(border);
        gridView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ObjectAnimator oa1;
                ObjectAnimator oa2;

                if (clickFlag)
                    if (card1 == null) {
                        card1 = cards.get(position);
                        oa1 = ObjectAnimator.ofFloat(card1.getImg(), "scaleX", 1f, 0f);
                        oa2 = ObjectAnimator.ofFloat(card1.getImg(), "scaleX", 0f, 1f);
                        oa1.setInterpolator(new DecelerateInterpolator());
                        oa2.setInterpolator(new AccelerateDecelerateInterpolator());
//                        card1.getImg().setImageResource(context.getResources()
//                                .getIdentifier("shirt",
//                                        "drawable",
//                                        context.getPackageName()));
                        oa1.addListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                card1.setPosition(position);
                                card1.getImg().setImageResource(v.getContext()
                                        .getResources()
                                        .getIdentifier("img_" + cards.get(position).getRank() + "_of_" + cards.get(position).getSuit(),
                                                "drawable",
                                                context.getPackageName()));
                                oa2.start();
                            }
                        });
                        oa1.setDuration(500);
                        oa2.setDuration(500);
                        oa1.start();

                        card1.getImg().refreshDrawableState();
                    } else if (card1 != cards.get(position)) {
                        clickFlag = false;
                        card2 = cards.get(position);
                        oa1 = ObjectAnimator.ofFloat(card2.getImg(), "scaleX", 1f, 0f);
                        oa2 = ObjectAnimator.ofFloat(card2.getImg(), "scaleX", 0f, 1f);
                        oa1.setInterpolator(new DecelerateInterpolator());
                        oa2.setInterpolator(new AccelerateDecelerateInterpolator());
                        oa1.addListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                card2.setPosition(position);
                                card2.getImg().setImageResource(v.getContext()
                                        .getResources()
                                        .getIdentifier("img_" + cards.get(position).getRank() + "_of_" + cards.get(position).getSuit(),
                                                "drawable",
                                                context.getPackageName()));
                                oa2.start();
                            }
                        });
                        oa1.setDuration(500);
                        oa2.setDuration(500);
                        oa1.start();


//                        card2.setPosition(position);
//                        card2.getImg().setImageResource(0);
//                        card2.getImg().setImageResource(v.getContext()
//                                .getResources()
//                                .getIdentifier("img_" + cards.get(position).getRank() + "_of_" + cards.get(position).getSuit(),
//                                        "drawable",
//                                        context.getPackageName()));
//                        card2.getImg().refreshDrawableState();
//                        card2.getImg().invalidate();
//                        card2.getImg().postInvalidate();

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


//                                    cards.forEach(card -> card.getImg().setImageResource(context.getResources()
//                                            .getIdentifier("shirt",
//                                                    "drawable",
//                                                    context.getPackageName())));
                                    card1.getImg().setImageResource(context.getResources()
                                            .getIdentifier("shirt",
                                                    "drawable",
                                                    context.getPackageName()));
                                    card2.getImg().setImageResource(context.getResources()
                                            .getIdentifier("shirt",
                                                    "drawable",
                                                    context.getPackageName()));
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

}
