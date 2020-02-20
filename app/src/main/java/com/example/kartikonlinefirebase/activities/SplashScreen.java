package com.example.kartikonlinefirebase.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.kartikonlinefirebase.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
         final int SPLASH_DISPLAY_LENGTH = 500;


        new Handler().postDelayed(() -> {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(getApplicationContext(), Login2FireStore.class);
                SplashScreen.this.startActivity(mainIntent);
                SplashScreen.this.finish();

        }, SPLASH_DISPLAY_LENGTH);
    }
}
