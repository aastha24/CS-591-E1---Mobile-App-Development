package com.example.sse.lect2_activitylifecycle_logging_savingstate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class MainActivity extends AppCompatActivity {

    private static final String MyFlag = "LECT2_FLAG";  //this will be our trail of breadcrumbs for logging events.
    private static int eventCount = 0;


    private Button btnConvert;
    private EditText inp;
    private EditText out;
    private RadioButton radioButtontemp;
    private RadioButton radioButtonCtoF;
    private RadioGroup radioGrouptemp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        eventCount++;
        Log.i(MyFlag, intToStr(eventCount) + ": Activity onCreate State Transition");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//Our view references

        btnConvert = (Button) findViewById(R.id.btnConvert);
        inp = (EditText) findViewById(R.id.inp);
        out = (EditText) findViewById(R.id.out);
        radioButtonCtoF = (RadioButton) findViewById(R.id.radioButtonCtoF);
        radioGrouptemp = (RadioGroup) findViewById(R.id.radioGrouptemp);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String C, F;
                Double DegC, DegF;

                int selectId = radioGrouptemp.getCheckedRadioButtonId();
                radioButtontemp = (RadioButton) findViewById(selectId);

                if (radioButtontemp == radioButtonCtoF)
                {
                    C = inp.getText().toString();
                    try{
                        DegC = Double.parseDouble(C);
                        DegF = DegC*9.0/5.0 + 32;
                        DegF = (double) Math.round(DegF * 100) / 100;
                        F = DegF.toString() + " F";
                        out.setText(F);
                    } catch (NumberFormatException e)
                    {
                        Log.i("Debugger", "invalid input");
                    }
                }

                else
                {
                    F = inp.getText().toString();
                    try{
                        DegF = Double.parseDouble(F);
                        DegC = (DegF - 32) * 5.0/9.0;
                        DegC = (double) Math.round(DegC * 100) / 100;
                        C = DegC.toString() + " C";
                        out.setText(C);
                    } catch (NumberFormatException e) {
                        Log.i("Debugger", "invalid input");
                    }
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

