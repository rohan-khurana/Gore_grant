package com.example.goregrant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;

import com.google.android.material.textfield.TextInputLayout;

public class Profile extends AppCompatActivity {
    TextInputLayout t1,t2,t3,t4,t5,t6;
    EditText e1,e2,e3,e4,e5,e6;
    RadioButton r1,r2,r3;
    Spinner s1;
    Switch aSwitch;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        t1=findViewById(R.id.text_layout_name);
        t2=findViewById(R.id.text_layout_age);
        t3=findViewById(R.id.text_layout_dob);
        t4=findViewById(R.id.text_layout_city);
        t5=findViewById(R.id.text_layout_district);
        t6=findViewById(R.id.text_layout_pin_code);

        e1=findViewById(R.id.text_edit_name);
        e2=findViewById(R.id.text_edit_age);
        e3=findViewById(R.id.text_edit_dob);
        e4=findViewById(R.id.city);
        e5=findViewById(R.id.district);
        e6=findViewById(R.id.pin_code);

        r1=findViewById(R.id.gender_male);
        r2=findViewById(R.id.gender_female);
        r3=findViewById(R.id.gender_others);

        s1=findViewById(R.id.blood_grp);

        aSwitch=findViewById(R.id.available);

        button=findViewById(R.id.save_button);
    }
}
