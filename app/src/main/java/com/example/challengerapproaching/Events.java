package com.example.challengerapproaching;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.Calendar;

public class Events extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView eventSetup;
    private DatePickerDialog.OnDateSetListener onDateSetListener;
    private LinearLayout lView;
    private int numDates = 0;
    private String dateName;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events);
        eventSetup = findViewById(R.id.tvEvent);
        lView = findViewById(R.id.dateList);
        eventSetup.setOnClickListener(v -> {
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dialog = new DatePickerDialog(
                    Events.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                    onDateSetListener, year, month, day);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
        });

        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                numDates++;
                dateName = "Date" + numDates + ": ";
                EditText newDate = new EditText(Events.this);
                newDate.setId(numDates);

                Log.d(TAG, "onDateSet: mm/dd/yyyy: " + month + "/" + dayOfMonth + "/" + year);
                String date = month + "/" + dayOfMonth + "/" + year;
                //eventSetup.setText((date));
                newDate.setTextSize(30);
                newDate.setText(dateName + date);


                lView.addView(newDate);
            }
        };

    };

}
