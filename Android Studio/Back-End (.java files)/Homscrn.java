package com.example.rig_covsign;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import static com.example.rig_covsign.R.id.bottom_navigation;
import static com.example.rig_covsign.R.id.nav_view;

public class Homscrn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        NavigationView navigationView = findViewById(nav_view);
        navigationView.setItemIconTintList(null);

        final DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);
        findViewById(R.id.toolbar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        // Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(bottom_navigation);

        // Set Home Selected
        bottomNavigationView.setSelectedItemId((R.id.home));

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.Chat:
                        startActivity(new Intent(getApplicationContext(), Chat.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.home:
                        return true;
                    case R.id.panic:
                        startActivity(new Intent(getApplicationContext(), panic.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.set:
                        startActivity(new Intent(getApplicationContext(), set.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.veh:
                        startActivity(new Intent(getApplicationContext(), veh.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });


    }

}
