package com.example.goregrant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class Front_page extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState == null) {
            Intent front_page = new Intent(this, Content_front_page.class);
            startActivity(front_page);
            navigationView.setCheckedItem(R.id.nav_view);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){

            case R.id.nav_add_request:

                Intent add_request= new Intent(this, Request.class);
                startActivity(add_request);
             break;

            case R.id.nav_see_requests:

                Intent see_request= new Intent(this, see_requests.class);
                startActivity(see_request);
                break;

            case R.id.nav_terms_conditions:

                Intent terms_and_cond= new Intent(this, Terms_and_conditions.class);
                startActivity(terms_and_cond);
                break;

            case R.id.nav_guidelines:

                Intent guidelines= new Intent(this, Guidelines.class);
                startActivity(guidelines);
                break;

            case R.id.nav_my_record:

                Intent record= new Intent(this, MyRecord.class);
                startActivity(record);
                break;

            case R.id.nav_settings:

                Intent settings= new Intent(this, Settings.class);
                startActivity(settings);
                break;

            case R.id.nav_profile:

                Intent profile= new Intent(this, Profile.class);
                startActivity(profile);
                break;

            case R.id.nav_logout:


                break;


        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else{
        super.onBackPressed();
    }
}}
