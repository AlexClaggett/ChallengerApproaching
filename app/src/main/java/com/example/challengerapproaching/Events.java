package com.example.challengerapproaching;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import com.example.challengerapproaching.utils.ListDataActivity;
import com.example.challengerapproaching.utils.databaseHelper;
import com.example.challengerapproaching.utils.eventDialog;

/**********************************************************************
 Event Activity for ChallengerApproaching App. Functions as a reminder,
 tracker, notifier of created and upcoming events.
 Currently allows event creation and allows the user to edit the name.
 Does not save event created.

 @authors Alex Clagget, Brad Samack, Katie Cussans, Tristan Kingsley
 @version v1.0 First Release
 *********************************************************************/
public class Events extends AppCompatActivity implements eventDialog.EventDialogListener {

  databaseHelper eventDatabase;
  /**
   * Static string for sending Log information to the terminal.
   */
  private static final String TAG = "Events";

  /**
   * Text View to show the name for event given.
   */
  private TextView eventName;

  /**
   * Text View to show the date of the event.
   */
  private TextView eventDate;

  /**
   * Button for creating an event.
   */
  private Button button;

  private Button viewEvent;

  private CalendarView eventsCalendar;

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
    button = findViewById(R.id.eventCreation);
    eventName = findViewById(R.id.tView);
    eventDate = findViewById(R.id.dView);
    viewEvent = findViewById(R.id.viewevent);
    eventsCalendar = findViewById(R.id.eventsCalendar);
    eventDatabase = new databaseHelper(this);

    // Set onClick Listener for event creation
    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        openDialog();
      }
    });

    viewEvent.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(Events.this, ListDataActivity.class);
        startActivity(intent);
      }
    });

    eventsCalendar.setBackgroundColor(android.R.style.Theme_Holo_Light_DarkActionBar);
  }

  public void openDialog() {
    eventDialog newEvent = new eventDialog();
    newEvent.show(getSupportFragmentManager(), "create event");
  }

  @Override
  public void applyText(String name, String date) {
    eventName.setText(name);
    eventDate.setText(date);
    if (eventName.length() != 0 && eventDate.length() != 0){
          AddData(name, date);
    }
    else{
        toastMessage("You must put something for the date and name");
    }
  }

  public void AddData(String newName, String newDate){
    boolean insertData = eventDatabase.addData(newName, newDate);
  }

  private void toastMessage(String message) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
  }
}
