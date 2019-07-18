package com.example.goregrant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT =5000;
    private TextView text_app_name, text_app_tag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_app_name= findViewById(R.id.text_app_name);
        text_app_tag = findViewById(R.id.tag_line);

//        LinearLayout linearLayout = findViewById(R.id.main_layout);
//        AnimationDrawable animationDrawable = (AnimationDrawable) linearLayout.getBackground();
//        animationDrawable.setEnterFadeDuration(1000);
//        animationDrawable.setExitFadeDuration(2000);
//        animationDrawable.start();

        YoYo.with(Techniques.BounceInDown)
                .duration(1000)
                .playOn(text_app_name);

        YoYo.with(Techniques.BounceInUp)
                .duration(1000)
                .playOn(text_app_tag);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Sign_up.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
