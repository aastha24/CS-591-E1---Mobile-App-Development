package com.example.sse.interfragmentcommratingbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RatingBar;
import android.preference.PreferenceManager;
import android.content.SharedPreferences;

public class MainActivity extends AppCompatActivity implements UpperFragment.ControlFragmentListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public void leftbtn() {
        LowerFragment receivingFragment = (LowerFragment)getSupportFragmentManager().findFragmentById(R.id.LowerFragment);
        receivingFragment.Dochange(0);
    }

    @Override
    public void rightbtn() {
        LowerFragment receivingFragment = (LowerFragment)getSupportFragmentManager().findFragmentById(R.id.LowerFragment);
        receivingFragment.Dochange(1);
    }

}
