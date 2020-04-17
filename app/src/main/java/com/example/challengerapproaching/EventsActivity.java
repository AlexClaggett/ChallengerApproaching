package com.example.challengerapproaching;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.utils.DatabaseHelper;
import com.example.challengerapproaching.utils.Event;
import com.example.challengerapproaching.utils.EventDialog;
import com.example.challengerapproaching.utils.ListDataActivity;

/**********************************************************************
 Event Activity for ChallengerApproaching App. Functions as an avenue
 for creating events, editing them, deleting them, and seeing which
 are coming up.

 @authors Alex Clagget, Brad Samack, Katie Cussans, Tristan Kingsley
 @version v2.0 Second Release
 *********************************************************************/
public class EventsActivity extends AppCompatActivity
    implements EventDialog.EventDialogListener {

  /**
   * Database Helper for creating a database of saved events.
   * */
  DatabaseHelper eventDatabase;

  /**
   *  Event array to hold the 3 most recent events.
   */
  Event[] mostRecent = new Event[3];

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
   * Text View array that holds the 3 upcoming events.
   */
  private TextView[] upcomingEvent = new TextView[3];

  /**
   * Button for creating an event.
   */
  private Button button;

  /**
   * Button for viewing the list of created events.
   */
  private Button viewEvent;

  /********************************************************************
   * OnCreate method to initialize the Events screen to be presented
   * to the user.
   * @param savedInstance standard state parameter needed for
   *                           define a specific state.
   *******************************************************************/
  protected void onCreate(Bundle savedInstance) {

    super.onCreate(savedInstance);

    // Change the view of the app to events.
    setContentView(R.layout.events);

    // Initialize variables to their respective views.
    button = findViewById(R.id.eventCreation);
    eventName = findViewById(R.id.tView);
    eventDate = findViewById(R.id.dView);
    viewEvent = findViewById(R.id.viewevent);
    upcomingEvent[0] = findViewById(R.id.mostRecent);
    upcomingEvent[1] = findViewById(R.id.mostRecent2);
    upcomingEvent[2] = findViewById(R.id.mostRecent3);
    eventDatabase = new DatabaseHelper(this);
    mostRecent[0] = eventDatabase.getMostRecent();
    mostRecent[1] = eventDatabase.nextMostRecent(mostRecent[0]);
    mostRecent[2] = eventDatabase.nextMostRecent(mostRecent[1]);

    // Set onClick Listener for event creation.
    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        openDialog();
      }
    });

    // On click listener for viewing events.
    viewEvent.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        // If there are no events inform the user.
        if (eventDatabase.getNumEvents() == 0) {
          toastMessage("Currently No Events Are Scheduled.");
        } else {
          final Intent intent = new Intent(EventsActivity.this,
              ListDataActivity.class);
          startActivityForResult(intent, 1);
        }
      }
    });

    // Log to check what the if the most recent date is correct.
    Log.d(TAG, "Most recent?: " + mostRecent[0].getDate());

    // If most recent doesn't exist don't set the text.
    if (mostRecent[0].getName().equals("")) {
      upcomingEvent[0].setText("");
    } else {
      upcomingEvent[0].setText(mostRecent[0].getName() + "\n"
          + mostRecent[0].getDate());
      upcomingEvent[1].setText(mostRecent[1].getName() + "\n"
          + mostRecent[1].getDate());
      upcomingEvent[2].setText(mostRecent[2].getName() + "\n"
          + mostRecent[2].getDate());
    }
  }

  /********************************************************************
   * openDialog method to explain what happens upon dialog call.
   *******************************************************************/
  public void openDialog() {
    final EventDialog newEvent = new EventDialog();
    newEvent.show(getSupportFragmentManager(), "create event");
  }

  /********************************************************************
   * applyText method for setting the event name and date after the
   * user creates a new event. Also adds the data to the database.
   * @param name the name of the event.
   * @param date the date of the event.
   *******************************************************************/
  @Override
  public void applyText(String name, String date) {
    // Set Event Name and Date.
    eventName.setText(name);
    eventDate.setText(date);

    // Check that the Name and Date are not empty.
    if (eventName.length() != 0 && eventDate.length() != 0) {
      // Add data to database.
      addData(name, date);
      // Get most recent date.
      mostRecent[0] = eventDatabase.getMostRecent();
      Log.d(TAG, "NextMost 1");
      // Get next most recent if it exists.
      mostRecent[1] = eventDatabase.nextMostRecent(mostRecent[0]);
      Log.d(TAG, "NextMost 2");
      // Get next most recent again if it exists.
      mostRecent[2] = eventDatabase.nextMostRecent(mostRecent[1]);

      // Update upcoming event if there was a change.
      upcomingEvent[0].setText(mostRecent[0].getName() + "\n"
          + mostRecent[0].getDate());
      upcomingEvent[1].setText(mostRecent[1].getName() + "\n"
          + mostRecent[1].getDate());
      upcomingEvent[2].setText(mostRecent[2].getName() + "\n"
          + mostRecent[2].getDate());
    } else {
      toastMessage("You must put something for the date and name");
    }
  }

  /********************************************************************
   * addData method tells the database to insert event into the
   * database.
   * @param newName The name of the event
   * @param newDate The date of the event
   *******************************************************************/
  public void addData(String newName, String newDate) {
    final boolean insertData = eventDatabase.addData(newName, newDate);
  }

  /********************************************************************
   * toastMessage for displaying in app messages to the user for
   * error messages.
   * @param message the message to be displayed to the user.
   *******************************************************************/
  private void toastMessage(String message) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
  }

  /********************************************************************
   * onActivityResult method that determines what happens when
   * listDataActivity finishes. If it finishes from an empty database
   * it resets the text of upcoming events.
   * @param requestCode the code requested.
   * @param resultCode the result from the child activity.
   * @param data the data from the intent.
   *******************************************************************/
  @Override
  protected void onActivityResult(int requestCode,
                                  int resultCode,
                                  @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    // If the code is 0 empty text.
    if (resultCode == 0) {
      eventDate.setText("");
      eventName.setText("");
      upcomingEvent[0].setText("");
      upcomingEvent[1].setText("");
      upcomingEvent[2].setText("");
    }
  }
}
