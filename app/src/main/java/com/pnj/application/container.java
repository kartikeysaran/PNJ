package com.pnj.application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class container extends AppCompatActivity {
    ViewPager viewPager;
    Dialog dialog;
    float x1,x2,y1,y2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        dialog = new Dialog(this);
        viewPager = (ViewPager)findViewById(R.id.view);

    }

    public void showpopup(){

        TextView close;
        close = (TextView)findViewById(R.id.closepop);

        dialog.setContentView(R.layout.swipeleft);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             dialog.dismiss();
            }
        });
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

    }

    public boolean onTouchEvent(MotionEvent touchEvent){
        switch(touchEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                y1 = touchEvent.getY();

            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                y2 = touchEvent.getY();

                if(x1<x2){

                   showpopup();

                }
                else if(x1>x2){
                   dialog.dismiss();
                }
        }
        return false;
    }
}
