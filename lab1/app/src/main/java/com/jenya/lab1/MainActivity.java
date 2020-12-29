package com.jenya.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private Button start;
    private ImageView view1, view2, view3, view4, view5, view6, view7, view8, view9, view10, view11, view12, view13, view14, view15, view16;
    private ImageView button1;
    private ImageView button2;
    int counter = 8;
    private RandomImageViewsUtil util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        util = new RandomImageViewsUtil();
        init();

        start.setOnClickListener(v -> {
            for (ImageView view : util.getListOfViews()) {
                init();
                view.setVisibility(View.VISIBLE);
                view.setBackgroundColor(getColor(R.color.black));
            }
            counter = 8;
            button1 = null;
            button2 = null;
        });

        for (ImageView view : util.getListOfViews()) {
            view.setOnClickListener(v -> {
                if (button1 == null & button1 != view) {
                    button1 = view;
                    view.setImageDrawable(util.getListOfImages().get(util.getListOfViews().indexOf(view)));
                } else if (button1 != view) {
                    button2 = view;
                    view.setImageDrawable(util.getListOfImages().get(util.getListOfViews().indexOf(view)));
                    checkWin();
                }
            });
        }
    }

    void checkWin(){
        for (ImageView view : util.getListOfViews()) {
            view.setClickable(false);
        }
        new Handler().postDelayed(() -> {
            Log.d("LOGGG", String.valueOf(button1.getDrawable().getConstantState().equals(button2.getDrawable().getConstantState())));
            Log.d("LOGGG", String.valueOf(button1.getDrawable().getConstantState()));
            Log.d("LOGGG", String.valueOf(button2.getDrawable().getConstantState()));
            if (button1.getDrawable().getConstantState().equals(button2.getDrawable().getConstantState())) {
                button1.setVisibility(View.INVISIBLE);
                button2.setVisibility(View.INVISIBLE);
                --counter;
                if (counter == 0) {
                    Toast.makeText(this, "Win", Toast.LENGTH_LONG).show();
                }
            } else {
                button1.setImageResource(R.color.design_default_color_on_secondary);
                button2.setImageResource(R.color.design_default_color_on_secondary);
            }
            button1 = null;
            button2 = null;
            for (ImageView view : util.getListOfViews()) {
                view.setClickable(true);
            }
        },1000);
    }

    void init(){
        start = findViewById(R.id.restart);
        view1 = findViewById(R.id.imageView1);
        view2 = findViewById(R.id.imageView2);
        view3 = findViewById(R.id.imageView3);
        view4 = findViewById(R.id.imageView4);
        view5 = findViewById(R.id.imageView5);
        view6 = findViewById(R.id.imageView6);
        view7 = findViewById(R.id.imageView7);
        view8 = findViewById(R.id.imageView8);
        view9 = findViewById(R.id.imageView9);
        view10 = findViewById(R.id.imageView10);
        view11 = findViewById(R.id.imageView11);
        view12 = findViewById(R.id.imageView12);
        view13 = findViewById(R.id.imageView13);
        view14 = findViewById(R.id.imageView14);
        view15 = findViewById(R.id.imageView15);
        view16 = findViewById(R.id.imageView16);
        util.setListOfViews(new ArrayList<>(Arrays.asList(view1, view2, view3, view4, view5, view6, view7, view8, view9,
                view10, view11, view12, view13, view14, view15, view16)));
        util.setListOfImages(new ArrayList<>(Arrays.asList(getDrawable(R.drawable.ic_a), getDrawable(R.drawable.ic_a),
                getDrawable(R.drawable.ic_b), getDrawable(R.drawable.ic_b), getDrawable(R.drawable.ic_c),
                getDrawable(R.drawable.ic_c), getDrawable(R.drawable.ic_d), getDrawable(R.drawable.ic_d),
                getDrawable(R.drawable.ic_e), getDrawable(R.drawable.ic_e), getDrawable(R.drawable.ic_f),
                getDrawable(R.drawable.ic_f), getDrawable(R.drawable.ic_g), getDrawable(R.drawable.ic_g),
                getDrawable(R.drawable.ic_h), getDrawable(R.drawable.ic_h))));
        for (ImageView view : util.getListOfViews()) {
            view.setImageResource(R.color.design_default_color_on_secondary);
        }
    }
}