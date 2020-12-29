package com.jenya.lab23.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.jenya.lab23.R;
import com.jenya.lab23.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.host, MainFragment.newInstance(), null)
                    .commit();
        }
    }

}