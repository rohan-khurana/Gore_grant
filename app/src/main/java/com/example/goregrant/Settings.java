package com.example.goregrant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Switch;

public class Settings extends AppCompatActivity {

    Switch s1,s2,s3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        s1=findViewById(R.id.notification_sms);
        s2=findViewById(R.id.notification_emails);
        s3=findViewById(R.id.available);

    }
}
