package com.example.goregrant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import tyrantgit.explosionfield.ExplosionField;

public class see_requests extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_requests);
        final ExplosionField mExplosionField = ExplosionField.attach2Window(this);

        Button b = findViewById(R.id.donate_btn);
        b.setOnClickListener(new View.OnClickListener() {
                                 @Override
                                 public void onClick(View view) {
                                     mExplosionField.explode(view);
                                     //add to record
                                     //implicit intent to call the requester
                                 }
                             }
        );
    }
}
