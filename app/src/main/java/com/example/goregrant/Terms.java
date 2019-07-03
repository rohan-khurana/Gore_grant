package com.example.goregrant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

public class Terms extends AppCompatActivity {
    CheckBox c1,c2,c3,c4;
    ImageView imageView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms);

        c1= findViewById(R.id.check_available);
        c2= findViewById(R.id.check_above_18);
        c3= findViewById(R.id.check_show_details);
        c4= findViewById(R.id.check_agree);
        imageView = findViewById(R.id.img_transit);
        button = findViewById(R.id.btn_register);
        button.setEnabled(false);

        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Terms.this, Terms_and_conditions.class);
                startActivity(intent);
            }
        });

        if(c1.isChecked()|| c2.isChecked() || c3.isChecked() || c4.isChecked())//25
        {
            imageView.setImageResource(R.drawable.box_back_gradient_fill);
        }


        if(c1.isChecked()&& c2.isChecked() || c1.isChecked()&& c3.isChecked() || c1.isChecked()&& c4.isChecked() ||
                c2.isChecked()&& c3.isChecked() || c2.isChecked()&& c4.isChecked() || c3.isChecked()&& c4.isChecked()) //50
        {
            imageView.setImageResource(R.drawable.box_back_gradient_fill);
        }


        if(c1.isChecked()&& c2.isChecked()&& c3.isChecked() || c1.isChecked()&& c2.isChecked()&& c4.isChecked() ||
          c1.isChecked()&& c3.isChecked()&& c4.isChecked() || c2.isChecked()&& c3.isChecked()&& c4.isChecked() )//75
        {
            imageView.setImageResource(R.drawable.box_back_gradient_fill);
        }


        if(c1.isChecked()&& c2.isChecked()&& c3.isChecked()&& c4.isChecked())//100
        {
            imageView.setImageResource(R.drawable.box_back_gradient_fill);
            button.setEnabled(true);
        }

    }
}
