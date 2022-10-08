package com.example.pushuptracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.BaseMenuPresenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private AdView mAdView;

    int countpush = 0;
    int countpull = 0;
    int countsquat = 0;
    int countpushbegin = 0;
    int countpullbegin = 0;
    int countsquatbegin= 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_main);



        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdClicked() {
                super.onAdClicked();
            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                super.onAdFailedToLoad(adError);
                mAdView.loadAd(adRequest);
            }

            @Override
            public void onAdImpression() {
                super.onAdImpression();
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
            }
        });


        TextView currentpushno = findViewById(R.id.currentpushno);
        TextView currentpullno = findViewById(R.id.currentpullno);
        TextView currentsquatno= findViewById(R.id.currentsquatno);
        TextView startpushno   = findViewById(R.id.startpushno);
        TextView startpullno   = findViewById(R.id.startpullno);
        TextView startsquatno  = findViewById(R.id.startsquatno);

        String currentpushnostring = currentpushno.getText().toString();
        String currentpullnostring = currentpushno.getText().toString();
        String currentsquatnostring= currentsquatno.getText().toString();
        String startpushnostring   = startpushno.getText().toString();
        String startpullnostring   = startpullno.getText().toString();
        String startsquatnostring  = startsquatno.getText().toString();

        ImageButton pushprogressbtn = (ImageButton) findViewById(R.id.pushprogressbtn);
        ImageButton pushdecreasebtn = (ImageButton) findViewById(R.id.pushdecreasebtn);
        ImageButton pushbeginbtn    = (ImageButton) findViewById(R.id.pushbeginbtn);
        ImageButton pullprogressbtn = (ImageButton) findViewById(R.id.pullprogressbtn);
        ImageButton pulldecreasebtn = (ImageButton) findViewById(R.id.pulldecreasebtn);
        ImageButton pullbeginbtn    = (ImageButton) findViewById(R.id.pullbeginbtn);
        ImageButton squatprogressbtn= (ImageButton) findViewById(R.id.squatprogressbtn);
        ImageButton squatdecreasebtn= (ImageButton) findViewById(R.id.squatdecreasebtn);
        ImageButton squatbeginbtn   = (ImageButton) findViewById(R.id.squatbeginbtn);

        pushprogressbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                countpush++;
                currentpushno.setText(""+countpush);
            }
        });
        pushdecreasebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countpush--;
                currentpushno.setText(""+countpush);
            }
        });
        pushbeginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countpushbegin++;
                startpushno.setText(""+countpushbegin);
            }
        });
        pullprogressbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countpull++;
                currentpullno.setText(""+countpull);
            }
        });
        pulldecreasebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countpull--;
                currentpullno.setText(""+countpull);
            }
        });
        pullbeginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countpullbegin++;
                startpullno.setText(""+countpullbegin);
            }
        });
        squatprogressbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countsquat++;
                currentsquatno.setText(""+countsquat);
            }
        });
        squatdecreasebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countsquat--;
                currentsquatno.setText(""+countsquat);
            }
        });
        squatbeginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countsquatbegin++;
                startsquatno.setText(""+countsquatbegin);
            }
        });

    }

}
