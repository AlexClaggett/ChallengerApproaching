package com.example.challengerapproaching.utils;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.challengerapproaching.R;
import java.util.ArrayList;

/**********************************************************************
 * Class for Listing the events held within the database. Is used for
 * selecting a date the user wishes to edit.
 *
 * @authors Alex Clagget, Brad Samack, Katie Cussans, Tristan Kingsley
 * @version v2.0 Second Release
 *********************************************************************/
public class ListDataActivity extends AppCompatActivity {

  /**
   * Tag for looking up Logged information in Logcat.
   */
  private static final String TAG = "ListDataActivity";

  /**
   * The database that the events are contained within.
   */
  private DatabaseHelper eventDatabase;

  /**
   * A ListView for the displaying the events to the screen.
   */
  private ListView eventsList;

  /******************************************************************
   * onCreate method for ListDataActivity. Holds the logic for
   * everything that happens within the activity.
   * @param savedInstance Required parameter for the
   *                          instance state.
   *****************************************************************/
  @Override
  protected void onCreate(final @Nullable Bundle savedInstance) {
    super.onCreate(savedInstance);

    // Sets the current view to the list_layout.
    setContentView(R.layout.list_layout);

    // Initialize the events list to the list_view.
    eventsList = findViewById(R.id.list_view);

    // Initialize the database.
    eventDatabase = new DatabaseHelper(this);

    // Mehtod call to the bulk of the underlying logic.
    populateListView();
  }

  /******************************************************************
   * Method for creating the list of events within the database.
   * Also used for determining what happens when selecting an event
   * and calling the EditdDtaActivity to edit the events.
   *****************************************************************/
  private void populateListView() {
    // Log to signal when populating the list is occurring.
    Log.d(TAG, "populateListView: Displaying data in ListView.");

    // Make an array list of events to hold all events.
    ArrayList<Event> eventList;

    /* Initialize eventList by getting all the data
    in the database. */
    eventList = eventDatabase.getAllData();

    /* Make another array list to hold the event name as a
     *  combination of the name and date. */
    final ArrayList<String> eventTitle = new ArrayList<>();

    /* Loop through event list to add the name and dates to the
     *  event title array list. */
    for (int i = 0; i < eventList.size(); i++) {
      eventTitle.add(eventList.get(i).getName() + "\n" + eventList.get(i).getDate());
    }

    // Create and initialize an adapter to set content of the list.
    final ListAdapter adapter = new ArrayAdapter<String>(this,
        android.R.layout.simple_list_item_1, eventTitle) {
      /**********************************************************
       * Method that formats the contents of the list with a
       * desired format in mind.
       * @param position the position of the view.
       * @param convertView view to be converted.
       * @param parent the parent of this view.
       * @return the updated view.
       *********************************************************/
      @NonNull
      @Override
      public View getView(final int position,
                          final @Nullable View convertView,
                          final @NonNull ViewGroup parent) {
        View view = super.getView(position, convertView,
            parent);

        // Create and initialize a default text view.
        TextView textView = view.findViewById(
            android.R.id.text1);

        // Set the textViews color to white.
        textView.setTextColor(Color.WHITE);

        // Set the text views size to 30sp.
        textView.setTextSize(30);

        // return the view with this format.
        return view;
      }
    };

    // Set the adapter for the event list to populate the list.
    eventsList.setAdapter(adapter);

    // Make a constant event list for reference within onItemClick.
    final ArrayList<Event> finalEventList = eventList;

    // Set an on item click listener for the event list
    eventsList.setOnItemClickListener(
        new AdapterView.OnItemClickListener() {
          /**************************************************
           * method for determining what happens when a view
           * is selected within the event list.
           * @param adapterView the adapter the view is from.
           * @param view the view selected.
           * @param i the index within the ArrayAdapter.
           * @param l some other needed parameter.
           *************************************************/
          public void onItemClick(final AdapterView<?> adapterView,
                                  final View view, final int i, final long l) {
            // Set name to the event at the same index as view.
            final String name = (finalEventList.get(i).getName());

            // Set date to the event at the same index as view.
            final String date = (finalEventList.get(i).getDate());

            /* Log to check the item selected is the correct
                event. */
            Log.d(TAG, "onItemClick: You Clicked on "
                + eventTitle.get(i));

            /* Cursor to retrieve the event at the ID of the events
               date from the database. */
            final Cursor data = eventDatabase.getDateID(date);

            // Initialize the itemID
            int itemID = -1;

            // Check that the database isn't empty.
            while (data.moveToNext()) {
              itemID = data.getInt(0);
            }
            // Check that we were able to get the events ID.
            if (itemID > -1) {
              // Log to check the value of the ID.
              Log.d(TAG, "onItemClick: The ID is: " + itemID);

              // Create the intent for editing the data.
              final Intent editScreenIntent = new Intent(
                  ListDataActivity.this,
                  EditDataActivity.class);

              // Add the Event details to the intent.
              editScreenIntent.putExtra("id", itemID);
              editScreenIntent.putExtra("name", name);
              editScreenIntent.putExtra("date", date);

              // Log that the Edit Activity is being called.
              Log.d(TAG, "attempting to start edit screen");

              // Start the edit activity.
              startActivityForResult(editScreenIntent, 1);
            } else {
              toastMessage("No ID associated with that name");
            }
            data.close();
          }
        });
  }

  /******************************************************************
   * Method for checking if the last value within the database was
   * deleted. If so, then force this activity to also finish.
   * @param requestCode a given requestCode.
   * @param resultCode the resulting code from the child.
   * @param data the data from the intent.
   *****************************************************************/
  @Override
  protected void onActivityResult(final int requestCode, final int resultCode,
                                  final @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (resultCode == 0) {
      finish();
      this.setResult(0);
    }
  }

  /******************************************************************
   * Method for displaying a message to the user if an error occurs.
   * @param message the message to be displayed.
   *****************************************************************/
  private void toastMessage(final String message) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
  }
}
