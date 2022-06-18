package com.tss.bakeryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {
    private BottomNavigationView bottomNavigationView;
    Fragment fragment = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottomNavigationView = findViewById(R.id.bottomnavigation);
        bottomNavigationView.setOnItemSelectedListener(this);
        if (savedInstanceState == null) {
            Home fragment = new Home();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment)
                    .commit();
        }
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {

            case R.id.home_id:
                fragment = new Home();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment)
                        .commit();
                break;
            case R.id.cart_id:
                fragment = new Cart();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment)
                        .commit();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + id);
        }
        return true;
    }
}