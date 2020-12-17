package com.example.defapp.controller;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.defapp.R;
import com.example.defapp.global.Constants;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                redirectUser();

            }
        }, Constants.SPLASH_DISPLAY_TIME);

    }

    private void redirectUser() {

        SharedPreferences preferences= getSharedPreferences(Constants.SHARED_PREFERENCE_NAME, MODE_PRIVATE);
        boolean is_connected = preferences.getBoolean(Constants.USER_CONNECTED, false);
        if(is_connected)
        {
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intent);

        }
        else {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);

        }
        finish();

    }
}

