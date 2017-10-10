package com.example.mlfan.w4_p3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class East extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.east_layout);

        /*Find view references */
        Button btnEast = (Button) findViewById(R.id.btnEast);

        /*Set click listener*/
        btnEast.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent NextScreen = new Intent(East.this, Home.class);
                //NextScreen.putExtra("SourceEvent", " OnClick");  //Ref. http://stackoverflow.com/questions/17286942/passing-string-to-another-activity-without-using-intent-extras-in-android
                startActivity(NextScreen);
            }


        });
    }
}
