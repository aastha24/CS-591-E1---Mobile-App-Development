package com.example.aasthaanand.traffic_light;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout LLMain;
    private LinearLayout.LayoutParams LLP;
    Button button;
    TextView textlight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        LLMain = new LinearLayout(MainActivity.this);
        LLMain.setOrientation(LinearLayout.VERTICAL);
        LLMain.setGravity(Gravity.CENTER);

        LLP = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT  );
        LLP.gravity = Gravity.CENTER;
        textlight = new TextView(this);
        textlight.setText("Red");
        textlight.setTextColor(Color.RED);
        textlight.setTextSize(24);
        textlight.setLayoutParams(LLP);
        LLMain.addView(textlight);

        button = new Button(this);
        button.setText("Change Lights");
        button.setTextSize(20);
        button.setLayoutParams(LLP);
        LLMain.addView(button);

        this.addContentView(LLMain, LLP);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (textlight.getCurrentTextColor() == Color.YELLOW) {
                    textlight.setTextColor(Color.GREEN);
                    textlight.setText("Green");
                }
                else if (textlight.getCurrentTextColor() == Color.RED) {
                    textlight.setTextColor(Color.YELLOW);
                    textlight.setText("Yellow");
                }
                else if (textlight.getCurrentTextColor() == Color.GREEN) {
                    textlight.setTextColor(Color.RED);
                    textlight.setText("Red");
                }
            }
        });


    }
}
