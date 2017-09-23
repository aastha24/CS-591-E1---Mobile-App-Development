package com.shinji.tempcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvCelsius, tvFahrenheit;
    private SeekBar sbCelsius, sbFahrenheit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        tvCelsius = (TextView) findViewById(R.id.tvCelsius);
        tvFahrenheit = (TextView) findViewById(R.id.tvFahrenheit);
        sbCelsius = (SeekBar) findViewById(R.id.sbCelsius);
        sbFahrenheit = (SeekBar) findViewById(R.id.sbFahrenheit);

        sbCelsius.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                double Celsius = (double) progress;
                tvCelsius.setText(String.format("%.2f", Celsius));
                tvFahrenheit.setText(String.format("%.2f", Celsius * 1.8d + 32));
                sbFahrenheit.setProgress((int)Double.parseDouble(tvFahrenheit.getText().toString()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sbFahrenheit.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                double Fahrenheit = (double) progress;
                tvFahrenheit.setText(String.format("%.2f", Fahrenheit));
                tvCelsius.setText(String.format("%.2f", (Fahrenheit - 32) / 1.8d));
                sbCelsius.setProgress((int)Double.parseDouble(tvCelsius.getText().toString()));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }



}
