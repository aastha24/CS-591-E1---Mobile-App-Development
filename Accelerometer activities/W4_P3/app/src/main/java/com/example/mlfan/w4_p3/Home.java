package com.example.mlfan.w4_p3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class Home extends Activity {

    private GestureDetectorCompat GD;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        GD = new GestureDetectorCompat(this, new GestureListener());
    }

    @Override
    // IMPORTANT
    public boolean onTouchEvent(MotionEvent event){
        this.GD.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    private static final int FLING_THRESHOLD = 30;
    private static final int FLING_VELOCITY_THRESHOLD = 30;

    class GestureListener extends GestureDetector.SimpleOnGestureListener {
        private static final String DEBUG_TAG = "Gestures";

        @Override
        public boolean onDown(MotionEvent event) {
            Log.d(DEBUG_TAG,"onDown: " + event.toString());
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2,
                               float velocityX, float velocityY) {
            Log.d(DEBUG_TAG, "onFling: " + e1.toString() + e2.toString());

            boolean result = false;

            float diffY = e2.getY() - e1.getY();
            float diffX = e2.getX() - e1.getX();
            if (Math.abs(diffX) > Math.abs(diffY)) {
                if (Math.abs(diffX) > FLING_THRESHOLD && Math.abs(velocityX) > FLING_VELOCITY_THRESHOLD) {
                    if (diffX > 0) {
                        onFlingRight();
                    } else {
                        onFlingLeft();
                    }
                }
                result = true;
            }
            else if (Math.abs(diffY) > FLING_THRESHOLD && Math.abs(velocityY) > FLING_VELOCITY_THRESHOLD) {
                if (diffY < 0) {
                    onFlingUp();
                } else {
                    onFlingDown();
                }
                result = true;
            }

            return result;
        }
    }

    public void onFlingRight() {
        //Intent NextScreen = new Intent("com.example.mlfan.w3_p4.East");
        Intent NextScreen = new Intent(Home.this, East.class);
        //NextScreen.putExtra("SourceEvent", "OnFling");
        startActivity(NextScreen);
    }

    public void onFlingLeft() {
        //Intent NextScreen = new Intent("com.example.mlfan.w3_p4.West");
        Intent NextScreen = new Intent(Home.this, West.class);
        //NextScreen.putExtra("SourceEvent", "OnFling");
        startActivity(NextScreen);
    }

    public void onFlingUp() {
        //Intent NextScreen = new Intent("com.example.mlfan.w3_p4.North");
        Intent NextScreen = new Intent(Home.this, North.class);
        //NextScreen.putExtra("SourceEvent", "OnFling");
        startActivity(NextScreen);
    }

    public void onFlingDown() {
        //Intent NextScreen = new Intent("com.example.mlfan.w3_p4.South");
        Intent NextScreen = new Intent(Home.this, South.class);
        //NextScreen.putExtra("SourceEvent", "OnFling");
        startActivity(NextScreen);
    }
}