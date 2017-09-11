package com.example.avnijain.multitouchandgesturesdemo;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class GestureActivity extends AppCompatActivity {

    RelativeLayout relativeLayout;
    GestureDetectorCompat gestureDetectorCompat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture);
        relativeLayout = (RelativeLayout)findViewById(R.id.relaiveLayout);

        relativeLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });

      //  gestureDetectorCompat = new GestureDetectorCompat(this,this);



    }
}
