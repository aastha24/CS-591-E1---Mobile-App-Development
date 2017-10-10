package com.example.mlfan.w4_p3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class North extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.north_layout);

        /*Find view references */
        Button btnNorth = (Button) findViewById(R.id.btnNorth);

        /*Set click listener*/
        btnNorth.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent NextScreen = new Intent(North.this, Home.class);
                //NextScreen.putExtra("SourceEvent", " OnClick");  //Ref. http://stackoverflow.com/questions/17286942/passing-string-to-another-activity-without-using-intent-extras-in-android
                startActivity(NextScreen);
            }


        });
    }
}
