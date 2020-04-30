package com.pnj.application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Button button;
   InterstitialAd mInterstitialAd;
    AdView mAdView;
    Timer timer;
    ViewPager viewPager;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        ImageAdapterIntro adapter = new ImageAdapterIntro(this);
        viewPager.setAdapter(adapter);
        timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent i  = new Intent(MainActivity.this,container.class);
                startActivity(i);
            }
        },2000);
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);







        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

    }

    public void showads(){
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "Check Your Internet connection.");
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        showads();
    }
}

