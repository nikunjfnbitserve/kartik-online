package com.example.kartikonlinefirebase.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.kartikonlinefirebase.R;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Logger.addLogAdapter(new AndroidLogAdapter());
        final int SPLASH_DISPLAY_LENGTH = 500;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(getApplicationContext(), LoginToFireStore.class);
                SplashScreen.this.startActivity(mainIntent);
                SplashScreen.this.finish();

             }
         }, SPLASH_DISPLAY_LENGTH);
    }
}
