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
import com.example.challengerapproaching.utils.ListDataActivity;
import com.example.challengerapproaching.utils.EventDialog;
import java.util.Calendar;

/**********************************************************************
 Event Activity for ChallengerApproaching App. Functions as a reminder,
 tracker, notifier of created and upcoming events.
 Currently allows event creation and allows the user to edit the name.
 Does not save event created.

 @authors Alex Clagget, Brad Samack, Katie Cussans, Tristan Kingsley
 @version v1.0 First Release
*********************************************************************/
public class EventsActivity extends AppCompatActivity implements EventDialog.EventDialogListener {

  DatabaseHelper eventDatabase;
  Event mostRecent[] = new Event[3];
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
  private TextView upcomingEvent[] = new TextView[3];
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
    upcomingEvent[0] = findViewById(R.id.mostRecent);
    upcomingEvent[1] = findViewById(R.id.mostRecent2);
    upcomingEvent[2] = findViewById(R.id.mostRecent3);
    eventDatabase = new DatabaseHelper(this);
    mostRecent[0] = eventDatabase.getMostRecent();
    mostRecent[1] = eventDatabase.nextMostRecent(mostRecent[0]);
    mostRecent[2] = eventDatabase.nextMostRecent(mostRecent[1]);
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
        if (eventDatabase.getNumEvents() == 0) {
          toastMessage("Currently No Events Are Scheduled.");
        } else {
          Intent intent = new Intent(EventsActivity.this, ListDataActivity.class);
          startActivityForResult(intent, 1);
        }
      }

    });
    Log.d(TAG, "Most recent?: " + mostRecent[0].getDate());
    if (mostRecent[0].getName().equals("")){
      upcomingEvent[0].setText("");
    }
    else {
      upcomingEvent[0].setText(mostRecent[0].getName() + "\n" + mostRecent[0].getDate());
      upcomingEvent[1].setText(mostRecent[1].getName() + "\n" + mostRecent[1].getDate());
      upcomingEvent[2].setText(mostRecent[2].getName() + "\n" + mostRecent[2].getDate());
    }
  }

  public void openDialog() {
    EventDialog newEvent = new EventDialog();
    newEvent.show(getSupportFragmentManager(), "create event");
  }

  @Override
  public void applyText(String name, String date, Calendar actDate) {
    eventName.setText(name);
    eventDate.setText(date);
    if (eventName.length() != 0 && eventDate.length() != 0) {
      addData(name, date);
      mostRecent[0] = eventDatabase.getMostRecent();
      Log.d(TAG, "NextMost 1");
      mostRecent[1] = eventDatabase.nextMostRecent(mostRecent[0]);
      Log.d(TAG, "NextMost 2");
      mostRecent[2] = eventDatabase.nextMostRecent(mostRecent[1]);
      upcomingEvent[0].setText(mostRecent[0].getName() + "\n" + mostRecent[0].getDate());

      upcomingEvent[1].setText(mostRecent[1].getName() + "\n" + mostRecent[1].getDate());
      upcomingEvent[2].setText(mostRecent[2].getName() + "\n" + mostRecent[2].getDate());
    } else {
      toastMessage("You must put something for the date and name");
    }
  }

  public void addData(String newName, String newDate) {
    boolean insertData = eventDatabase.addData(newName, newDate);
  }

  private void toastMessage(String message) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if(resultCode == 0){
      eventDate.setText("");
      eventName.setText("");
      upcomingEvent[0].setText("");
      upcomingEvent[1].setText("");
      upcomingEvent[2].setText("");
    }
  }
}
