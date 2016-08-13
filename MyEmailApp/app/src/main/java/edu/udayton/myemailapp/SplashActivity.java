package edu.udayton.myemailapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {
    public static final long DELAY=5000;//5000 millisecs = 5seconds
    private MediaPlayer ourSong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //display the actionBar icon
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        ourSong=MediaPlayer.create(SplashActivity.this,R.raw.campaign);
        ourSong.start();

        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                finish();

                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
            }
        };

        Timer opening=new Timer();
        opening.schedule(task,DELAY);
    }

    @Override
    protected void onPause(){
        super.onPause();
        ourSong.release();
    }
}
