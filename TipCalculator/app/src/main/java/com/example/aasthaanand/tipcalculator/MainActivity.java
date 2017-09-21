package com.example.aasthaanand.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText amount;
    private TextView tipamt;
    private TextView ttl;
    private SeekBar seeker;
    private TextView skbar;
    private int tipPercentValue = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amount = (EditText) findViewById(R.id.amount);
        tipamt = (TextView) findViewById(R.id.tipamt);
        ttl = (TextView) findViewById(R.id.ttl);
        seeker = (SeekBar) findViewById(R.id.seeker);
        skbar = (TextView) findViewById(R.id.skbar);


        seeker.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tipPercentValue = progress;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                double amt = 0;
                skbar.setText(tipPercentValue + "%");
                if (amount.getText().toString().equals("") || amount.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Specify the amount!", Toast.LENGTH_LONG).show();

                }
                if (tipPercentValue == 0)
                {
                    tipamt.setText("$0.00");
                    ttl.setText("$0.00");
                }
                else {
                    double tiponamt = (Double.parseDouble(amount.getText().toString()) * tipPercentValue)/100;
                    amt = Double.parseDouble(amount.getText().toString()) + tiponamt;
                    amt = (double) Math.round(amt * 100) / 100;
                    tipamt.setText("$" +tiponamt);
                    ttl.setText("$" + amt);
                }




            }
        });




    }
}
