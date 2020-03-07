package com.example.challengerapproaching;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.view.View.*;

public class Events extends AppCompatActivity {
    Button setdate;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events);


        setdate = (Button) findViewById(R.id.daychoice);
        setdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.daychoice) {
                    v.setId(R.id.calendarView2);
                    v.setVisibility(VISIBLE);
                }
            }
        });
    }
}
