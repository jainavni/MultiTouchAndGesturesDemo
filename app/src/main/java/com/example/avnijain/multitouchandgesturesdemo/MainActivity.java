package com.example.avnijain.multitouchandgesturesdemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    RelativeLayout relativeLayout;
    HashMap<Integer,View> map ;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            map = new HashMap<>();

            relativeLayout = (RelativeLayout) findViewById(R.id.relaiveLayout);
            relativeLayout.setOnTouchListener(new View.OnTouchListener(){

                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {

                    int index = motionEvent.getActionIndex();
                    int id = motionEvent.getPointerId(index);

                    if(motionEvent.getActionMasked()==MotionEvent.ACTION_DOWN)
                    {
                        float x = motionEvent.getX(index);
                        float y = motionEvent.getY(index);

                        View newView = new View(MainActivity.this);
                        newView.setLayoutParams(new LinearLayoutCompat.LayoutParams(100,100));
                        newView.setBackgroundColor(Color.BLACK);
                        newView.setX(x-50);
                        newView.setY(y-50);
                        map.put(id,newView);
                        relativeLayout.addView(newView);


                    }
                    else   if(motionEvent.getActionMasked()==MotionEvent.ACTION_POINTER_DOWN)
                    {
                        float x = motionEvent.getX(index);
                        float y = motionEvent.getY(index);

                        View newView = new View(MainActivity.this);
                        newView.setLayoutParams(new LinearLayoutCompat.LayoutParams(100,100));
                        newView.setBackgroundColor(Color.BLACK);
                        newView.setX(x-50);
                        newView.setY(y-50);
                        map.put(id,newView);
                        relativeLayout.addView(newView);

                    }
                    else   if(motionEvent.getActionMasked()==MotionEvent.ACTION_POINTER_UP)
                    {
                        View viewRemoved = map.get(id);
                        map.remove(id);
                        relativeLayout.removeView(viewRemoved);
                    }
                    else   if(motionEvent.getActionMasked()==MotionEvent.ACTION_UP)
                    {
                        View viewRemoved = map.get(id);
                        map.remove(id);
                        relativeLayout.removeView(viewRemoved);
                    }
                    else   if(motionEvent.getActionMasked()==MotionEvent.ACTION_MOVE)
                    {
                        for(int i: map.keySet()){
                            View v = map.get(i);
                            int ind = motionEvent.findPointerIndex(i);
                            float x = motionEvent.getX(ind);
                            float y = motionEvent.getY(ind);
                            v.setX(x-50);
                            v.setY(y-50);
                        }

                    }


                    return  true;
                }
            });

        }
    }
