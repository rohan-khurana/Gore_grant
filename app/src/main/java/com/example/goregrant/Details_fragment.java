package com.example.goregrant;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import static android.R.layout.simple_dropdown_item_1line;
import static android.R.layout.simple_spinner_item;

public class Details_fragment extends Fragment {



    EditText date_picker;
    EditText name,age;

    Calendar myCalender = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            myCalender.set(Calendar.YEAR, year);
            myCalender.set(Calendar.MONTH, month);
            myCalender.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }
    };

    private void updateLabel() {

        String myFormat = "yyyy-mm-dd";
        SimpleDateFormat sdf= new SimpleDateFormat(myFormat, Locale.US);
        date_picker.setText(sdf.format(myCalender.getTime()));
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = getView();
        assert view != null;

        final Button buttonConfirm = getView().findViewById(R.id.details_button);
        final Spinner spinner = view.findViewById(R.id.blood_grp);

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

        //Style and populate the spinner

        ArrayAdapter<String> data_adapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()).getApplicationContext(), simple_spinner_item, Blood_categories);

        // Dropdown layout style

        data_adapter.setDropDownViewResource(simple_dropdown_item_1line);

        //attaching data adapter to spinner
        spinner.setAdapter(data_adapter);

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


        date_picker = view.findViewById(R.id.dob);
        date_picker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                new DatePickerDialog(Objects.requireNonNull(getActivity()).getApplicationContext(), date, myCalender
                        .get(Calendar.YEAR), myCalender.get(Calendar.MONTH), myCalender.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        name= view.findViewById(R.id.name);
        final String user_name= name.getText().toString().trim();

        age= view.findViewById(R.id.age);
        final String user_age= age.getText().toString().trim();

        TextWatcher registerTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                buttonConfirm.setEnabled(!user_name.isEmpty() && !user_age.isEmpty());


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        name.addTextChangedListener(registerTextWatcher);
        age.addTextChangedListener(registerTextWatcher);




        return inflater.inflate(R.layout.fragment_details, container, false);
    }
}
