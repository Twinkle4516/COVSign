package com.example.rig_covsign;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import static com.example.rig_covsign.R.id.bottom_navigation;

public class set extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);

        // Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(bottom_navigation);

        // Set Set Selected
        bottomNavigationView.setSelectedItemId((R.id.set));

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.Chat:
                        startActivity(new Intent(getApplicationContext(), Chat.class));
                        overridePendingTransition(0, 0);
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), Homscrn.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.panic:
                        startActivity(new Intent(getApplicationContext(), panic.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.set:
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
