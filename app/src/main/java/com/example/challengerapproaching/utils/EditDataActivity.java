package com.example.challengerapproaching.utils;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import java.util.Calendar;

public class EditDataActivity extends AppCompatActivity {

  private static final String TAG = "EditDataActivity";
  private Button btnSave;
  private Button btnDelete;
  private EditText editableName;
  private TextView editableDate;
  private DatePickerDialog.OnDateSetListener onDateSetListener;
  DatabaseHelper eventDatabase;

  private String selectedName;
  private String selectedDate;
  private int selectedId;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.edit_data_layout);
    btnSave = findViewById(R.id.savebtn);
    btnDelete = findViewById(R.id.delbtn);
    editableName = findViewById(R.id.editable_name);
    editableDate = findViewById(R.id.editable_date);
    eventDatabase = new DatabaseHelper(this);

    Intent receivedIntent = getIntent();
    selectedId = receivedIntent.getIntExtra("id", -1);
    selectedName = receivedIntent.getStringExtra("name");
    selectedDate = receivedIntent.getStringExtra("date");
    editableName.setText(selectedName);
    editableDate.setText(selectedDate);

    editableDate.setOnClickListener(v -> {
      Calendar cal = Calendar.getInstance();
      int year = cal.get(Calendar.YEAR);
      int month = cal.get(Calendar.MONTH);
      int day = cal.get(Calendar.DAY_OF_MONTH);


      DatePickerDialog dialog = new DatePickerDialog(
            this,
            android.R.style.Theme_Holo_Dialog_MinWidth,
            onDateSetListener, year, month, day);

      dialog.getWindow().setBackgroundDrawable(
            new ColorDrawable(Color.TRANSPARENT));
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
        date += month + "/";
        date += dayOfMonth + "/";
        date += year;
        editableDate.setText(date);
        }
    };

    btnSave.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
        String newName = editableName.getText().toString();
        String newDate = editableDate.getText().toString();
        if (newName.equals(selectedName) && newDate.equals(selectedDate)) {
            finish();
        } else if (!newName.equals("") && !newDate.equals("")) {
          if (!newName.equals(selectedName) && !newDate.equals(selectedDate)) {
                eventDatabase.updateName(newName,selectedId,selectedName);
                eventDatabase.updateDate(newDate,selectedId,selectedDate);
                finish();
                startActivity(getParentActivityIntent());
          } else if (!newName.equals(selectedName)) {
            eventDatabase.updateName(newName,selectedId,selectedName);
            finish();
            startActivity(getParentActivityIntent());
          } else {
            eventDatabase.updateDate(newDate,selectedId,selectedDate);
            finish();
            startActivity(getParentActivityIntent());
          }
        } else {
            toastMessage("Name and Date may not be empty!");
        }
      }
    });

    btnDelete.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        eventDatabase.deleteEvent(selectedId,selectedName,selectedDate);
        editableName.setText("");
        editableDate.setText("");
        toastMessage("removed from database");

        finish();
      }
    });
  }

  private void toastMessage(String message) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
  }
}
