package com.example.sse.interfragmentcommratingbar;


import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;

import java.lang.reflect.Field;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class LowerFragment extends Fragment {


    ArrayList<Drawable> drawables;  //keeping track of our images

    private int currDrawableIndex =0;
    private ImageView imgRateMe;
    private RatingBar ratingBar;


    public LowerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_lower, container, false);
        imgRateMe = (ImageView) v.findViewById(R.id.imgRateMe);
        ratingBar = (RatingBar) v.findViewById(R.id.ratingBar);

        return v;
    }

    public void Dochange (int i)
    {
        getDrawables();
        if (i==0){
            if (currDrawableIndex == 0)
                currDrawableIndex = drawables.size() - 1;
            else
                currDrawableIndex--;

            imgRateMe.setImageDrawable(drawables.get(currDrawableIndex));

        }
        else
        {
            if (currDrawableIndex == drawables.size() - 1)
                currDrawableIndex = 0;
            else
                currDrawableIndex++;

            imgRateMe.setImageDrawable(drawables.get(currDrawableIndex));

        }

    }
    //REF: http://stackoverflow.com/questions/31921927/how-to-get-all-drawable-resources

    public void getDrawables() {
        Field[] drawablesFields = com.example.sse.interfragmentcommratingbar.R.drawable.class.getFields();
        drawables = new ArrayList<>();

        String fieldName;
        for (Field field : drawablesFields) {
            try {
                fieldName = field.getName();
                Log.i("LOG_TAG", "com.your.project.R.drawable." + fieldName);
                if (fieldName.startsWith("animals_"))  //only add drawable resources that have our prefix.
                    drawables.add(getResources().getDrawable(field.getInt(null)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}


