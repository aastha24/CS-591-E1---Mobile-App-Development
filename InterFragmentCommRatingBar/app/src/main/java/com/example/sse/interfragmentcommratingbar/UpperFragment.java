package com.example.sse.interfragmentcommratingbar;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpperFragment extends Fragment {

    private Button btnLeft;
    private Button btnRight;

    public UpperFragment() {
        // Required empty public constructor
    }

    public interface ControlFragmentListener {            //this is just an interface definition.
        void leftbtn();
        void rightbtn();
    }

    ControlFragmentListener CFL;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        CFL = (ControlFragmentListener) context;  //context is a handle to the main activity, let's bind it to our interface.
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_upper, container, false);

        btnLeft = (Button) v.findViewById(R.id.btnLeft);
        btnRight = (Button) v.findViewById(R.id.btnRight);

        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CFL.leftbtn();  //CFL is a handle to our MainActivity, we are sending it a left button click.
            }
        });

        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CFL.rightbtn();  //CFL is a handle to our MainActivity, we are sending it a right button click.
            }
        });

        return v;
    }

}
