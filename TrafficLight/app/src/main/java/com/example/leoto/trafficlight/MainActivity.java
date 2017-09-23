package com.example.leoto.trafficlight;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.leoto.trafficlight.R.color.red;


public class MainActivity extends AppCompatActivity {

    private static final String MyFlag = "Traffic_Light";  //this will be our trail of breadcrumbs for logging events.
    private static int eventCount = 0;
    private String color;


    private Button button;
    private TextView textLight;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        eventCount++;
        Log.i(MyFlag, intToStr(eventCount) + ": Activity onCreate State Transition");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//Our view references

        button = (Button) findViewById(R.id.button);
        textLight = (TextView) findViewById(R.id.textLight);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(MyFlag, "Current color :" + intToStr(textLight.getCurrentTextColor()));
                if (textLight.getCurrentTextColor() == -65536) {
                    textLight.setTextColor(getResources().getColor(R.color.green));
                    textLight.setText("Green");
                }
                else if (textLight.getCurrentTextColor() == -16744448) {
                    textLight.setTextColor(getResources().getColor(R.color.yellow));
                    textLight.setText("Yellow");
                }
                else if (textLight.getCurrentTextColor() == -256) {
                    textLight.setTextColor(getResources().getColor(R.color.red));
                    textLight.setText("Red");
                }
            }
        });


    }

    //Useful Notes:
    // ctrl-O is a shortcut to override base methods
    // Alt-Ins is a shortcut to overriding base methods and more.

    @Override
    protected void onPause() {
        eventCount++;
        Log.i(MyFlag, intToStr(eventCount) + ": Activity onPause State Transition");
        super.onPause();
    }


    @Override
    protected void onStart() {
        eventCount++;
        Log.i(MyFlag, intToStr(eventCount) + ": Activity onStart State Transition");
        super.onStart();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        eventCount++;
        Log.i(MyFlag, intToStr(eventCount) + ": Activity onSaveInstanceState State Transition");
        Log.i(MyFlag, "Bundling State of our views before they get destroyed");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        eventCount++;
        Log.i(MyFlag, intToStr(eventCount) + ": Activity onRestoreInstanceState State Transition");
        Log.i(MyFlag, "Retrieving our saved state from before... ");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onResume() {
        eventCount++;
        Log.i(MyFlag, intToStr(eventCount) + ": Activity onRestoreInstanceState State Transition");
        super.onResume();
    }


    //Handy Helpers...
    public String intToStr(Integer i)
    {
        return i.toString();
    }

    public int strToInt(String S)
    {
        return Integer.parseInt(S);
    }


}
