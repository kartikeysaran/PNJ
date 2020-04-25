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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class container extends AppCompatActivity {
    ViewPager viewPager;
    Dialog dialog;
    float x1,x2,y1,y2;
    ImageView home,menu,game,news;

    Button pnjwebview,legalwebview,risewebview,achievewebview,antiqueswebview,digitalwebview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        home = findViewById(R.id.home);
        menu = findViewById(R.id.menu);
        game = findViewById(R.id.game);
        news = findViewById(R.id.news);



        dialog = new Dialog(this);
        viewPager = (ViewPager)findViewById(R.id.view);

        pnjwebview = findViewById(R.id.pnjwebview);
        legalwebview = findViewById(R.id.legalwebview);
        risewebview = findViewById(R.id.risewebview);
        achievewebview = findViewById(R.id.achievewebview);
        antiqueswebview = findViewById(R.id.antiqueswebview);
        digitalwebview = findViewById(R.id.digitalwebview);

        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(container.this,game.class);
                startActivity(i);
            }
        });
        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(container.this,news.class);
                startActivity(i);
        }
        });



        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showpopup();
            }
        });



        pnjwebview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(container.this,hubwebview.class);
                startActivity(i);
            }
        });
        legalwebview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(container.this,legalwebview.class);
                startActivity(i);

            }
        });
        risewebview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(container.this,risewebview.class);
                startActivity(i);

            }
        });
        achievewebview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(container.this,achievewebview.class);
                startActivity(i);

            }
        });
        antiqueswebview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(container.this,antiqueswebview.class);
                startActivity(i);

            }
        });
        digitalwebview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(container.this,digitalwebview.class);
                startActivity(i);

            }
        });



    }

    public void showpopup(){



        dialog.setContentView(R.layout.swipeleft);
        TextView close,hub,legal,antiques,rise,digital,achieve;
        hub = (TextView)dialog.findViewById(R.id.pnjhub);
        legal = (TextView)dialog.findViewById(R.id.legal);
        antiques = (TextView)dialog.findViewById(R.id.antiques);
        rise = (TextView)dialog.findViewById(R.id.rise);
        digital = (TextView)dialog.findViewById(R.id.dsc);
        achieve = (TextView)dialog.findViewById(R.id.achieve);
        close = (TextView)dialog.findViewById(R.id.closepop);

        hub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(container.this,hubwebview.class);
                startActivity(i);
            }
        });
        legal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(container.this,legalwebview.class);
                startActivity(i);

            }
        });
        rise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(container.this,risewebview.class);
                startActivity(i);

            }
        });
        digital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(container.this,digitalwebview.class);
                startActivity(i);

            }
        });
        achieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(container.this,achievewebview.class);
                startActivity(i);

            }
        });
        antiques.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(container.this,antiqueswebview.class);
                startActivity(i);

            }
        });
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
        return false; }




}
