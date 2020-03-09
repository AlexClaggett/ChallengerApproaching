package com.example.challengerapproaching;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

/**********************************************************************
 Event Activity for ChallengerApproaching App. Functions as a reminder,
 tracker, notifier of created and upcoming events.
 Currently allows event creation and allows the user to edit the name.
 Does not save event created.

 @authors Alex Clagget, Brad Samack, Katie Cussans, Tristan Kingsley
 @version v1.0 First Release
 *********************************************************************/
public class Events extends AppCompatActivity {

  /**
   * Static string for sending Log information to the terminal.
   */
  private static final String TAG = "MainActivity";

  /**
   * Text View to select the desired date.
   */
  private TextView eventSetup;

  /**
   * date listener that presents the options to the user.
   */
  private DatePickerDialog.OnDateSetListener onDateSetListener;

  /**
   * Layout that holds the dates selected.
   */
  private LinearLayout lview;

  /**
   * Keeps track of how many dates have been chosen.
   */
  private int numDates = 0;

  /**
   * Naming format for default Event setup.
   */
  private String dateName;

  /********************************************************************
   * OnCreate method to initialize the Events screen to be presented
   * to the user.
   * @param savedInstanceState standard state parameter needed for
   *                           define a specific state.
   *******************************************************************/
  protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);

    // Change the view of the app to events
    setContentView(R.layout.events);

    // Initialize variables to their respective views
    eventSetup = findViewById(R.id.tvEvent);
    lview = findViewById(R.id.dateList);

    // Defines what happens when eventSetup is selected
    eventSetup.setOnClickListener(v -> {

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
              Events.this,
              android.R.style.Theme_Holo_Light_Dialog_MinWidth,
              onDateSetListener, year, month, day);
      // Set the windows background
      dialog.getWindow().setBackgroundDrawable(
              new ColorDrawable(Color.TRANSPARENT));

      // Tell the system to show the DatePickerDialog
      dialog.show();
    });

    // Initializes the onDateSetListener to a new object
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

        // Increment Number of Dates variable
        numDates++;

        // Create the beginning of the date name
        dateName = "Date" + numDates + ": ";

        // Create EditText view to hold the selected date
        EditText newDate = new EditText(Events.this);

        // Give the newDates id to the number of dates
        //newDate.setId(numDates);

        /* Print out a log to the terminal in order to verify date order
         and print out the date selected
       */
        Log.d(TAG, "onDateSet: mm/dd/yyyy: " + month + "/"
                + dayOfMonth + "/" + year);

        // Fill in the date selected
        String date = month + "/" + dayOfMonth + "/" + year;

        // Format size of the date
        newDate.setTextSize(30);

        // Set newDate text to the selected date
        newDate.setText(dateName + date);

        // Add newDate view to the layout variable
        lview.addView(newDate);
      }
    };
  }
}
