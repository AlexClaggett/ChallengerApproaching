package com.example.challengerapproaching.utils;

import static java.lang.Integer.parseInt;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import java.util.Calendar;

/**********************************************************************
 * Class for Editing the contents of an event. Allows for the date
 * to be changed, the name to be changed, and allows for the user to
 * send the event details to their calendar and create an event there.
 *********************************************************************/
public class EditDataActivity extends AppCompatActivity {

  /**
   * TAG for specifying where the logged content came from.
   */
  private static final String TAG = "EditDataActivity";

  /**
   * Button that represents the Save button for saving the event.
   */
  private Button btnSave;

  /**
   * Button that represents the Delete button to remove events.
   */
  private Button btnDelete;

  /**
   * Button that represents sending the event to the default calendar
   * app.
   */
  private Button calendarSave;

  /**
   * EditText that represents the name of the event.
   */
  private EditText editableName;

  /**
   * TextView that represents the date of the event.
   */
  private TextView editableDate;

  /**
   * Date Picker Dialog for event selection.
   */
  private DatePickerDialog.OnDateSetListener onDateSetListener;

  /**
   * Database that hold the events.
   */
  private DatabaseHelper eventDatabase;

  /**
   * String to represent the event name that was selected.
   */
  private String selectedName;

  /**
   * String to represent the event date that was selected.
   */
  private String selectedDate;

  /**
   * Int to represent the selected event ID.
   */
  private int selectedId;

  /********************************************************************
   * onCreate method for determining what happens when starting the
   * editDataActivity.
   * @param savedInstance required variable for android activity.
   *******************************************************************/
  @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
  @Override
  protected void onCreate(final @Nullable Bundle savedInstance) {
    super.onCreate(savedInstance);

    // Set the content view to the edit data layout.
    setContentView(R.layout.edit_data_layout);

    // Initialize the save button.
    btnSave = findViewById(R.id.savebtn);

    // Initialize the delete button.
    btnDelete = findViewById(R.id.delbtn);

    // Initialize the save calendar button.
    calendarSave = findViewById(R.id.calendar_Save);

    // Initialize the editable name view.
    editableName = findViewById(R.id.editable_name);

    // Initialize the editable date view.
    editableDate = findViewById(R.id.editable_date);

    // Initialize the database.
    eventDatabase = new DatabaseHelper(this);

    // Retrieve the contents passed from ListDataActivity.
    final Intent receivedIntent = getIntent();

    // Set the Selected Variables to the values passed by ListData.
    selectedId = receivedIntent.getIntExtra("id", -1);
    selectedName = receivedIntent.getStringExtra("name");
    selectedDate = receivedIntent.getStringExtra("date");

    // Set the text for the event name and date selected.
    editableName.setText(selectedName);
    editableDate.setText(selectedDate);

    /* Set the onclick listener for the editable date to use
       the date picker dialog for date selection. */
    editableDate.setOnClickListener(v -> {

      // Get today's date on the calendar..
      final Calendar cal = Calendar.getInstance();

      // Set the parts of the date to today's date.
      final int year = cal.get(Calendar.YEAR);
      final int month = cal.get(Calendar.MONTH);
      final int day = cal.get(Calendar.DAY_OF_MONTH);

      // Create and initialize the date picker dialog.
      final DatePickerDialog dialog = new DatePickerDialog(
          this,
          android.R.style.Theme_Holo_Dialog_MinWidth,
          onDateSetListener, year, month, day);
      // Call the window.
      dialog.getWindow().setBackgroundDrawable(
          new ColorDrawable(Color.TRANSPARENT));

      // Show the date picker.
      dialog.show();
    });

    // Set up the on date set listener for the date picker.
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
      public void onDateSet(final DatePicker view, final int year, int month,
                            final int dayOfMonth) {
        // Adds one to the month because the calendar starts at 0
        month = month + 1;
        String date = "";
        date += month + "/";
        date += dayOfMonth + "/";
        date += year;
        editableDate.setText(date);
      }
    };

    /* Set the onclick listener for the save button.
       used lambda function to reduce code redundancy. */
    btnSave.setOnClickListener(v -> {
      // Get the Event name and date current on the screen.
      final String newName = editableName.getText().toString();
      final String newDate = editableDate.getText().toString();

      // Check if name or date changed.
      if (newName.equals(selectedName)
          && newDate.equals(selectedDate)) {
        finish();
        startActivity(getParentActivityIntent());
      } else if (!newName.equals("") && !newDate.equals("")) {
        // Check that Both name and date were changed.
        if (!newName.equals(selectedName)
            && !newDate.equals(selectedDate)) {
          eventDatabase.updateName(newName, selectedId, selectedName);
          eventDatabase.updateDate(newDate, selectedId, selectedDate);
          finish();
          startActivity(getParentActivityIntent());
        } else if (!newName.equals(selectedName)) {
          eventDatabase.updateName(newName, selectedId, selectedName);
          finish();
          startActivity(getParentActivityIntent());
        } else {
          eventDatabase.updateDate(newDate, selectedId, selectedDate);
          finish();
          startActivity(getParentActivityIntent());
        }
      } else {
        toastMessage("Name and Date may not be empty!");
      }
    });

    /* Set the onclick listener for the delete button.
       Uses lambda function to reduce redundant code.*/
    btnDelete.setOnClickListener(v -> {

      // Delete the event from the database.
      eventDatabase.deleteEvent(
          selectedId,
          selectedName,
          selectedDate);

      // Set the name to an empty string.
      editableName.setText("");

      // Set the date to an empty string.
      editableDate.setText("");

      // Give the user a message telling them the event was removed.
      toastMessage("Event was deleted.");

      // Finish the activity.
      finish();

      // Check if there are any more events in the database.
      if (eventDatabase.getNumEvents() > 0) {
        // If so return to the parent activity.
        startActivity(getParentActivityIntent());
      }
    });

    /* Set onclick listener for save to calendar button.
       Used lambda function to remove unneeded code. */
    calendarSave.setOnClickListener(v -> {
      // String to parse the selected date for the calendar.
      String dateParts = selectedDate;

      // Parse the month from the date.
      final int month =
          parseInt(dateParts.substring(0, dateParts.indexOf("/")));

      // Shrink the string.
      dateParts = dateParts.substring(dateParts.indexOf("/") + 1);

      // Parse the day.
      final int day =
          parseInt(dateParts.substring(0, dateParts.indexOf("/")));

      // Shrink the string again.
      dateParts = dateParts.substring(dateParts.indexOf("/") + 1);

      // Parse the yest.
      final int year = parseInt(dateParts);

      // Setup a calendar of today's date.
      final Calendar cal = Calendar.getInstance();

      // Set the date to the events date.
      cal.set(year, month, day);

      // Create an intent for calendar events.
      final Intent intent = new Intent(Intent.ACTION_EDIT);

      // Detail the type of intent.
      intent.setType("vnd.android.cursor.item/event");

      // Set the Date beginning and end time.
      intent.putExtra("beginTime", cal.getTimeInMillis());
      intent.putExtra("endTime", cal.getTimeInMillis() + 1000);

      // Determine how long it is for.
      intent.putExtra("allDay", true);

      // Set the event title.
      intent.putExtra("title", selectedName);

      // Start the phones default calendar app and create the event.
      startActivity(intent);
    });
  }

  /********************************************************************
   * Method to determine what happens when the activity is destoryed.
   * Returns a result value to the parent activity.
   *******************************************************************/
  public void onDestroy() {
    super.onDestroy();
    this.setResult(0);
  }

  /********************************************************************
   * Method for sending error, or content messages to the user.
   * @param message the message to be sent to the user.
   *******************************************************************/
  private void toastMessage(final String message) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
  }
}
