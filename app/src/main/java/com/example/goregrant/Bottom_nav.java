package com.example.goregrant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

public class Bottom_nav extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);

        BottomNavigationView bottom_nav = findViewById(R.id.bottom_navigation_sign_up);
        bottom_nav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_root,new Fragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()){

                        case R.id.register:
                            selectedFragment = new Fragment();
                            break;

                        case R.id.verification:
                            selectedFragment = new Fragment();
                            break;

                        case R.id.details:
                            selectedFragment = new Fragment();
                            break;

                        case R.id.location:
                            selectedFragment = new Fragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_root,

                            Objects.requireNonNull(selectedFragment)).commit();

                    return true;
                }
            };
}
