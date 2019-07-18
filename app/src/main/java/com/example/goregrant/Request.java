package com.example.goregrant;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static android.R.layout.simple_dropdown_item_1line;
import static android.R.layout.simple_spinner_item;

public class Request extends AppCompatActivity {

    Spinner s1,s2;
    RadioButton r1,r2,r3,r4;
    EditText e1,e2,e3;
    LinearLayout l1,l2;
    TextInputLayout textInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        s1=findViewById(R.id.blood_grp_requested);
        s2=findViewById(R.id.blood_units_requested);

        r1=findViewById(R.id.radio_time1);
        r2=findViewById(R.id.radio_time2);
        r3=findViewById(R.id.radio_time3);
        r4=findViewById(R.id.radio_time4);

        e1=findViewById(R.id.text_time_from);
        e2=findViewById(R.id.text_time_to);
        e3=findViewById(R.id.text_edit_msg);

        textInputLayout=findViewById(R.id.text_layout_msg);

        l1=findViewById(R.id.request_btn);
        l2=findViewById(R.id.cancel_btn);

        List<String> Blood_categories = new ArrayList<>();

        Blood_categories.add(0,"Blood Group");
        Blood_categories.add("A+");
        Blood_categories.add("A-");
        Blood_categories.add("A1+");
        Blood_categories.add("A1B+");
        Blood_categories.add("A1B-");
        Blood_categories.add("A2+");
        Blood_categories.add("A2B+");
        Blood_categories.add("A2B-");
        Blood_categories.add("AB+");
        Blood_categories.add("AB-");
        Blood_categories.add("B+");
        Blood_categories.add("B-");
        Blood_categories.add("O+");
        Blood_categories.add("O-");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(Request.this,simple_spinner_item, Blood_categories);
        adapter.setDropDownViewResource(simple_dropdown_item_1line);

        //attaching data adapter to spinner
        s1.setAdapter(adapter);

        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (parent.getItemAtPosition(position).equals("Blood Group"))
                {
                    Toast.makeText(parent.getContext(), "Please Select your Blood Group ", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    //on selecting a spinner item
                    String item= parent.getItemAtPosition(position).toString();

                    //show selected spinner item
                    Toast.makeText(parent.getContext(), "Selected: "+item, Toast.LENGTH_SHORT).show();
                }}

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });

        List<String> Blood_units = new ArrayList<>();
        Blood_units.add("Blood Units");
        Blood_units.add("1");
        Blood_units.add("2");
        Blood_units.add("3");
        Blood_units.add("4");
        Blood_units.add("5");
        Blood_units.add("6");
        Blood_units.add("7");
        Blood_units.add("8");

        ArrayAdapter<String> array_adapter = new ArrayAdapter<>(Request.this, simple_spinner_item, Blood_units);
        array_adapter.setDropDownViewResource(simple_dropdown_item_1line);
        s2.setAdapter(array_adapter);

        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (parent.getItemAtPosition(position).equals("Blood Units"))
                {
                    Toast.makeText(parent.getContext(), "Please Select number of  Blood Units ", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    //on selecting a spinner item
                    String item= parent.getItemAtPosition(position).toString();

                    //show selected spinner item
                    Toast.makeText(parent.getContext(), "Selected: "+item, Toast.LENGTH_SHORT).show();
                }}

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });


        e1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar mCurrentTime= Calendar.getInstance();
                int hour= mCurrentTime.get(Calendar.HOUR_OF_DAY);
                int min= mCurrentTime.get(Calendar.MINUTE);

                TimePickerDialog mTicker;
                mTicker = new TimePickerDialog(Request.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {

                        e1.setText(i+ ":"+ i1);

                    }
                },hour, min, true);
                mTicker.setTitle("Select Time");
                mTicker.show();
            }
        });

        e2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar mCurrentTime= Calendar.getInstance();
                int hour= mCurrentTime.get(Calendar.HOUR_OF_DAY);
                int min= mCurrentTime.get(Calendar.MINUTE);

                TimePickerDialog mTicker;
                mTicker= new TimePickerDialog(Request.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        e2.setText(i + ":" + i1);
                    }
                },hour,min,true);
                mTicker.setTitle("Select Time");
                mTicker.show();
            }
        });

           String message = e3.getText().toString().trim();

           //all these msgs are to b stored in databse

    }
}
