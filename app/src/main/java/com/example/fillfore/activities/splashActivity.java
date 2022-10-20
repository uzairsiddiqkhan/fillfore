package com.example.fillfore.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.fillfore.R;
import com.example.fillfore.activities.modeActivity;

public class splashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



//this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Thread thread = new Thread(){

            @Override
            public void run() {
                super.run();



                try {
                    sleep(3000);

                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent intent =new Intent(splashActivity.this, modeActivity.class);
                    startActivity(intent);
                    finish();
                }


            }

        }; thread.start();



    }

}