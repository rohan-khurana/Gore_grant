package com.example.goregrant;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.storage.FirebaseStorage;

public class Register_fragment extends Fragment {



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = getView();
        assert view!= null;

        //above two statements are added as findViewById method was giving a warning that it will throw a null pointer exception

        //getView method was added as we can use findViewById method only after onCreate() method and not inside such methods

        final EditText editTextUsername = getView().findViewById(R.id.username);
        EditText editTextPassword = getView().findViewById(R.id.password);
        EditText editTextConfirm_password = getView().findViewById(R.id.confirm_password);
        EditText editTextMobile = getView().findViewById(R.id.mobile);
        EditText editTextEmail = getView().findViewById(R.id.email);
        final Button buttonConfirm = getView().findViewById(R.id.button_submit);



         TextWatcher registerTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String User_name_input = editTextUsername.getText().toString().trim();
                String Password_input = editTextUsername.getText().toString().trim();
                String Confirm_password_input = editTextUsername.getText().toString().trim();
                String Mobile_input = editTextUsername.getText().toString().trim();
                String Email_input = editTextUsername.getText().toString().trim();

                buttonConfirm.setEnabled(!User_name_input.isEmpty() && !Password_input.isEmpty() &&
                        !Confirm_password_input.isEmpty() && !Mobile_input.isEmpty() && !Email_input.isEmpty());


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        editTextUsername.addTextChangedListener(registerTextWatcher);
        editTextPassword.addTextChangedListener(registerTextWatcher);
        editTextConfirm_password.addTextChangedListener(registerTextWatcher);
        editTextMobile.addTextChangedListener(registerTextWatcher);
        editTextEmail.addTextChangedListener(registerTextWatcher);

        return inflater.inflate(R.layout.fragment_register, container, false);

        ProgressDialog loadingBar = new ProgressDialog();

        loadingBar.setTitle("Loading");
        loadingBar.setMessage("Please Wait..");
        loadingBar.show();




    }
}
