package com.example.goregrant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mikhaellopez.circularfillableloaders.CircularFillableLoaders;

public class Circle_loader extends AppCompatActivity {
    CircularFillableLoaders circularFillableLoaders;
    int progress=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_loader);

        circularFillableLoaders = findViewById(R.id.circularFillableLoaders);
        circularFillableLoaders.setMaxHeight(200);

        while(progress>=10)
        {
            circularFillableLoaders.setProgress(progress);
            progress-=10;
        }
    }
}
