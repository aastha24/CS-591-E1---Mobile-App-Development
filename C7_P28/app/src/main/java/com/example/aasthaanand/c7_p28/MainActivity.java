package com.example.aasthaanand.c7_p28;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private GestureDetector GD;

    private TextView flingtxt;


    private LinearLayout LLMain;
    private LinearLayout.LayoutParams LLP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);


        LLMain = new LinearLayout(MainActivity.this);

        LLMain.setOrientation(LinearLayout.VERTICAL);
        LLMain.setGravity(Gravity.CENTER);


        LLP = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT );
        LLP.setMargins(50,150,50,150);
        flingtxt = new TextView(this);
        flingtxt.setText("FLING ME!");
        flingtxt.setTextColor(Color.RED);
        flingtxt.setTextSize(24);
        flingtxt.setGravity(Gravity.CENTER);
        flingtxt.setLayoutParams(LLP);
        LLMain.addView(flingtxt);

        this.addContentView(LLMain, LLP);

        flingtxt.setOnTouchListener(new View.OnTouchListener()
        {
            public boolean onTouch(View v, MotionEvent event)
            {
                GD.onTouchEvent(event);
                return true;
            }
        });

        GD = new GestureDetector(this, new SimpleOnGestureListener()
        {
            @Override
            public boolean onDown(MotionEvent event) {

                return true;
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY)
            {
                int newY = (int) (e2.getY() - e1.getY());
                int newX = (int) (e2.getX() - e1.getX());

                if (Math.abs(velocityX) > 1000) {
                    flingtxt.setVisibility(View.INVISIBLE);
                    LLP.leftMargin = 60; //random location
                    LLP.topMargin = 50;
                    flingtxt.setVisibility(View.VISIBLE);
                    flingtxt.setLayoutParams(LLP);
                    return true;
                    }

                else
                    {
                    LLP.leftMargin = newX;
                    LLP.topMargin = newY;
                    flingtxt.setLayoutParams(LLP);
                    return true;
                }

            }

        });





    }





}
