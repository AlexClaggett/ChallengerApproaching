package com.example.challengerapproaching;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.challengerapproaching.utils.ListDataActivity;
import com.example.challengerapproaching.utils.databaseHelper;
import com.example.challengerapproaching.utils.event;
import com.example.challengerapproaching.utils.eventDialog;

import java.util.Calendar;

/**********************************************************************
 Event Activity for ChallengerApproaching App. Functions as a reminder,
 tracker, notifier of created and upcoming events.
 Currently allows event creation and allows the user to edit the name.
 Does not save event created.

 @authors Alex Clagget, Brad Samack, Katie Cussans, Tristan Kingsley
 @version v1.0 First Release
 *********************************************************************/
public class Events_Activity extends AppCompatActivity implements eventDialog.EventDialogListener {

  databaseHelper eventDatabase;
  event mostRecent = new event();
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
  private TextView upcomingEvent;
  /**
   * Button for creating an event.
   */
  private Button button;

  private Button viewEvent;

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
    upcomingEvent = findViewById(R.id.mostRecent);
    eventDatabase = new databaseHelper(this);
    mostRecent = eventDatabase.getMostRecent();
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
        if(eventDatabase.getNumEvents() == 0){
          toastMessage("Currently No Events Are Scheduled.");
        }
        else {
          Intent intent = new Intent(Events_Activity.this, ListDataActivity.class);
          startActivity(intent);
        }
      }
    });
    Log.d(TAG, "Most recent?: " + mostRecent.getDate());
    upcomingEvent.setText(mostRecent.getName() + "\n" + mostRecent.getDate());

  }

  public void openDialog() {
    eventDialog newEvent = new eventDialog();
    newEvent.show(getSupportFragmentManager(), "create event");
  }

  @Override
  public void applyText(String name, String date, Calendar actDate) {
    eventName.setText(name);
    eventDate.setText(date);
    if (eventName.length() != 0 && eventDate.length() != 0){
//        Intent intent = new Intent(Intent.ACTION_EDIT);
//        intent.setType("vnd.android.cursor.item/event");
//        intent.putExtra("beginTime", actDate.getTimeInMillis());
//        intent.putExtra("allDay", true);
//        intent.putExtra("rrule", "FREQ=YEARLY");
//       // intent.putExtra("endTime", eventDate.getText()+60*60*1000);
//        intent.putExtra("title", eventName.getText());
//      startActivity(intent);
          AddData(name, date);
      mostRecent = eventDatabase.getMostRecent();
      upcomingEvent.setText(mostRecent.getName() + "\n" + mostRecent.getDate());
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
