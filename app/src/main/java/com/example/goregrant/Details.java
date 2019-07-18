package com.example.goregrant;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import static android.R.layout.simple_dropdown_item_1line;
import static android.R.layout.simple_spinner_item;

public class Details extends AppCompatActivity {

    private EditText date, name, age;
    private DatePickerDialog datePickerDialog;
    private TextInputLayout t1,t2,t3,t4;
    private ProgressDialog loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

       Spinner spinner = findViewById(R.id.blood_grp);

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

        ArrayAdapter<String> adapter = new ArrayAdapter<>(Details.this, simple_spinner_item, Blood_categories);
        adapter.setDropDownViewResource(simple_dropdown_item_1line);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

        date = findViewById(R.id.dob);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);

        t1= findViewById(R.id.text_layout_name);
        t2= findViewById(R.id.text_layout_dob);
        t3= findViewById(R.id.text_layout_age);
        t4= findViewById(R.id.text_layout_blood);

        date.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog

                datePickerDialog = new DatePickerDialog(Details.this, new DatePickerDialog.OnDateSetListener() {

                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // set day of month , month and year value in the edit text
                        date.setText(dayOfMonth + "/"
                                + (monthOfYear + 1) + "/" + year);


                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });



//        private void ifAnyDetailIsEmpty(){
//            int user_name = name.getText().toString().trim().length();
//            int  user_age= age.getText().toString().trim().length();
//            int user_dob = date.getText().toString().trim().length();
//            int user_blood_grp = spinner.getSelectedItem().toString().trim().length();
//
//
//            int flag = 0;
//
//            if (user_name == 0 || user_age == 0 || user_dob == 0 ||user_blood_grp ==0) {
//                if (user_name == 0) {
//                    t1.setError("This field needs to be filled");
//
//                }
//                if (user_dob==0) {
//
//
//                    t2.setError("This field needs to be filled");
//                }
//                if (user_age == 0)
//                {
//
//                    t3.setError("This field needs to be filled");
//                }
//
//                if (user_blood_grp == 0) {
//
//                    t4.setError("This field needs to be filled");
//                }
//
//
//            }
//
//
//        }


        Button buttonConfirm = findViewById(R.id.details_button);
        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loadingBar.setTitle("Saving data");
                loadingBar.setMessage("Please Wait..");
                loadingBar.show();
                Intent intent = new Intent(Details.this, Location.class);
                startActivity(intent);
            }
        });

    }
}
