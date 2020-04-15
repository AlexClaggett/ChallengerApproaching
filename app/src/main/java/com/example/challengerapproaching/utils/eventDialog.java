package com.example.challengerapproaching.utils;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.challengerapproaching.R;

public class eventDialog extends AppCompatDialogFragment {
    private EditText editTextEventName;
    private TextView editTextEventDate;
    private EventDialogListener listener;
    private DatePickerDialog.OnDateSetListener onDateSetListener;
    public Calendar newDate;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_eventcreation, null);

        editTextEventName = view.findViewById(R.id.edit_eventname);
        editTextEventDate = view.findViewById(R.id.edit_eventDate);
        newDate = Calendar.getInstance();
        // Defines what happens when eventSetup is selected
        editTextEventDate.setOnClickListener(v ->{
            // Create calendar object equal to today's date
            Calendar cal = Calendar.getInstance();

            // Create year int to hold the calendar year
            int year = cal.get(Calendar.YEAR);

            // Create month int to hold the calendar month
            int month = cal.get(Calendar.MONTH);

            // Create day int to hold the calendar day
            int day = cal.get(Calendar.DAY_OF_MONTH);

            //Create DatePickerDialog object and initializes it
            DatePickerDialog dialog = new DatePickerDialog(
                    eventDialog.this.getActivity(),
                    android.R.style.Theme_Holo_Dialog_MinWidth,
                    onDateSetListener, year, month, day);
            // Set the windows background
            dialog.getWindow().setBackgroundDrawable(
                    new ColorDrawable(Color.TRANSPARENT));

            // Tell the system to show the DatePickerDialog
            dialog.show();
        });

        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            /***************************************************************
             * Class that defines what happens once a date is selected.
             *
             * @param view the datePicker view
             * @param year the year selected.
             * @param month the month selected
             * @param dayOfMonth the day of the month selected
             ***************************************************************/
            @Override
            public void onDateSet(DatePicker view, int year, int month,
                                  int dayOfMonth) {
                // Adds one to the month because the calendar starts at 0
                month = month + 1;
                String date = "";
                date += month +"/";
                date += dayOfMonth + "/";
                date += year;
                newDate.set(year,month,dayOfMonth);
                editTextEventDate.setText(date);
            }
        };
        builder.setView(view)
                .setTitle("Event Creation")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Create", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String eventName = editTextEventName.getText().toString();
                        String eventDate = editTextEventDate.getText().toString();
                        Log.d("EventDialog","New Date is: " + newDate.getTime());
                        listener.applyText(eventName, eventDate, newDate);
                    }
                });



        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            listener = (EventDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "Must implement EventDialog Listener");
        }
    }

    public interface EventDialogListener{
        void applyText(String eventName, String date, Calendar newDate);
    }
}



