package com.example.challengerapproaching.utils;

import static java.lang.Integer.parseInt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;

/**********************************************************************
 * Class that handles database logic and managing the data within.
 * Used for updating what events exist, adding data, removing data,
 * changing data, and querying on that data.
 *********************************************************************/
public class DatabaseHelper extends SQLiteOpenHelper {

  /**
   * TAG variable for Logged messages.
   */
  private static final String TAG = "DatabaseHelper";

  /**
   * String for the name of the Events database table.
   */
  private static final String TABLE_NAME = "Events_Table";

  /**
   * Variable for the column that Event ID's will be stored.
   */
  private static final String COL1 = "ID";

  /**
   * Variable for the column that Event Name's will be stored.
   */
  private static final String COL2 = "NAME";

  /**
   * Variable for the column that Event Date's will be stored.
   */
  private static final String COL3 = "DATE";

  /********************************************************************
   * Constructor for creating the database.
   * @param context the context the database is created for.
   *******************************************************************/
  public DatabaseHelper(final Context context) {
    super(context, TABLE_NAME, null, 1);
  }

  /********************************************************************
   * Method for determining what happens when upgrading the table to
   * a newer version, and when changes are made to the table.
   * @param dbEvents The instance of the database to be changed.
   * @param oldVersion the previous version of the database.
   * @param newVersion the current version of the database.
   *******************************************************************/
  @Override
  public void onUpgrade(final SQLiteDatabase dbEvents,
                        final int oldVersion,
                        final int newVersion) {
    dbEvents.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    onCreate(dbEvents);
  }

  /********************************************************************
   * Method for creation of the database. Details the table key as
   * well as the values that should be within each column.
   * @param dbName the instance of data base to be created for.
   *******************************************************************/
  @Override
  public void onCreate(final SQLiteDatabase dbName) {
    // String to represent the SQL code for creating a table.
    final String createTable = "CREATE Table " + TABLE_NAME
            + "(\n" + COL1 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL2 + " CHAR(255) NOT NULL, "
            + COL3 + " CHAR(255) NOT NULL );";
    dbName.execSQL(createTable);
  }

  /********************************************************************
   * method that appends or "adds" data to the database.
   * @param item1 the name of the event to be added.
   * @param item2 the date of the event to be added.
   * @return whether or not the data was inserted.
   *******************************************************************/
  public boolean addData(final String item1, final String item2) {
    // Values to be inserted within the database.
    final ContentValues contentValues = new ContentValues();
    contentValues.put(COL2, item1);
    contentValues.put(COL3, item2);

    // Logger information for what is being inserted into the database.
    Log.d(TAG, "addData: Adding " + item1 + " to " + TABLE_NAME);
    Log.d(TAG, "addData: Adding " + item2 + " to " + TABLE_NAME);

    // Gets a writable database
    final SQLiteDatabase dbName = this.getWritableDatabase();

    // method call to insert the data into the table.
    final long result = dbName.insert(TABLE_NAME, null, contentValues);

    if (result == -1) {
      return false;
    } else {
      return true;
    }
  }

  /********************************************************************
   * Method to return all a list of events inside the database.
   * Essentially just queries for the entire table.
   * @return an Array List of all the events in the database.
   *******************************************************************/
  public ArrayList<Event> getAllData() {
    // Variable for the array of events.
    final ArrayList<Event> events = new ArrayList<>();

    // Writable version of the database.
    final SQLiteDatabase dbName = this.getWritableDatabase();

    // String to represent the query.
    final String query = "SELECT * FROM " + TABLE_NAME;

    // Cursor which points to the data queried.
    final Cursor data = dbName.rawQuery(query, null);

    // Check if the database has any events.
    if (data.moveToFirst()) {
      // While there are events add them tp the event list.
      do {

        final Event eventInput = new Event();
        eventInput.setIdName(data.getInt(data.getColumnIndex(COL1)));
        eventInput.setName(data.getString(data.getColumnIndex(COL2)));
        eventInput.setDate(data.getString(data.getColumnIndex(COL3)));
        events.add(eventInput);

      } while (data.moveToNext());

    }

    /* Loop through the event list and display logged data of each
    event within the event list. */
    for (int i = 0; i < events.size(); i++) {
      Log.d(TAG, "Events List Id: " + i + " "
              + events.get(i).getIdName());
      Log.d(TAG, "Events List Name: " + i + " "
              + events.get(i).getName());
      Log.d(TAG, "Events List Date: " + i + " "
              + events.get(i).getDate());
    }
    // Return the event list.
    return events;
  }

  /********************************************************************
   * Method to retrieve the ID of a given event date from the database.
   * @param date The date whose ID is wanted to be obtained.
   * @return What data was found.
   *******************************************************************/
  public Cursor getDateID(final String date) {
    final SQLiteDatabase dbName = this.getWritableDatabase();
    final String query = "SELECT " + COL1 + " FROM " + TABLE_NAME
            + " WHERE " + COL3 + " = '" + date + "'";
    final Cursor data = dbName.rawQuery(query, null);
    return data;
  }

  /********************************************************************
   * Method for updating the events name within the database.
   * @param newName the new name to set for the event.
   * @param idName the id that this event is at.
   * @param oldName the current name of the event in the database.
   *******************************************************************/
  public void updateName(final String newName, final int idName, final String oldName) {
    final SQLiteDatabase dbName = this.getWritableDatabase();
    final String query = "UPDATE " + TABLE_NAME + " SET " + COL2
            + " = '" + newName + "' Where " + COL1 + " = '" + idName + "'"
            + " AND " + COL2 + " = '" + oldName + "'";
    Log.d(TAG, "updateName: query: " + query);
    Log.d(TAG, "updateName: Setting name to " + newName);
    dbName.execSQL(query);
  }

  /********************************************************************
   * Method for updating the events date within the database.
   * @param newDate the new date to set for the event.
   * @param idName the id that this event is at.
   * @param oldDate the current date of the event in the database.
   *******************************************************************/
  public void updateDate(final String newDate, final int idName, final String oldDate) {
    final SQLiteDatabase dbName = this.getWritableDatabase();
    final String query = "UPDATE " + TABLE_NAME + " SET " + COL3
            + " = '" + newDate + "' Where " + COL1 + " = '" + idName + "'"
            + " AND " + COL3 + " = '" + oldDate + "'";
    Log.d(TAG, "updateName: query: " + query);
    Log.d(TAG, "updateName: Setting name to " + newDate);
    dbName.execSQL(query);
  }

  /********************************************************************
   * Method for removing an event from the database.
   * @param idName the idName of the event to be removed.
   * @param name the name of the event.
   * @param date the date of the event.
   *******************************************************************/
  public void deleteEvent(final int idName, final String name, final String date) {
    final SQLiteDatabase dbName = this.getWritableDatabase();
    final String query = "DELETE FROM " + TABLE_NAME + " WHERE "
            + COL1 + " = '" + idName + "'" + " AND " + COL3
            + " = '" + date + "'";
    Log.d(TAG, "deleteName: query: " + query);
    Log.d(TAG, "deleteName: Deleting Event: " + name + " on " + date);
    dbName.execSQL(query);
  }

  /********************************************************************
   * Mehtod for getting the earliest date inside the
   * database.
   * @return the earliest event.
   *******************************************************************/
  public Event getMostRecent() {
    // Variable that will hold the most recent date.
    final Event mostRecent = new Event("", "");

    // Variable for the current event being looked at.
    final Event curEvent = new Event();

    // String for parsing the date for comparison.
    String dateParts;

    // The current events date.
    int[] curTime = {0,0,0};

    // The most recent date.
    int[] time = {0,0,0};

    // Get the writable database.
    final SQLiteDatabase dbName = this.getWritableDatabase();

    // Query the entire table.
    final String query = "SELECT * FROM " + TABLE_NAME;

    // Set the cursor to point at the data.
    final Cursor data = dbName.rawQuery(query, null);

    // Log that query was ran.
    Log.d(TAG, "Query Ran");

    // Check if any events exist within the database.
    if (data.moveToFirst()) {
      do {
        // set the current event to the event pointed at by cursor.
        curEvent.setName(data.getString(data.getColumnIndex(COL2)));
        curEvent.setDate(data.getString(data.getColumnIndex(COL3)));

        // Set the date parse to the current event date.
        parseDate(curEvent.getDate(), curTime);

        // Check if there isn't a most recent date amd assign it.
        if (mostRecent.getDate().equals("")) {
          mostRecent.setName(curEvent.getName());
          mostRecent.setDate(curEvent.getDate());
        } else {
          // Now get the values for the date.
          parseDate(mostRecent.getDate(), time);

          // Compare the Two dates and see which one is earlier..
          if (curTime[2] < time[2]) {
            mostRecent.setName(curEvent.getName());
            mostRecent.setDate(curEvent.getDate());
          } else if (curTime[2] == time[2] && curTime[0] < time[0]) {
            mostRecent.setName(curEvent.getName());
            mostRecent.setDate(curEvent.getDate());
          } else if (curTime[2] == time[2] && curTime[0] == time[0]
                  && curTime[1] < time[1]) {
            mostRecent.setName(curEvent.getName());
            mostRecent.setDate(curEvent.getDate());
          }
        }
        // log most recent at each step in the loop.
        Log.d(TAG, "Most Recent Date: " + mostRecent.getDate());
      } while (data.moveToNext());
    }
    // Return the earliest event.
    return mostRecent;
  }

  /********************************************************************
   * Method for determining what the next earliest event is from a
   * given date.
   * @param mostRecent an event to be compared against.
   * @return an event that is next earliest from the passed in event.
   *******************************************************************/
  public Event nextMostRecent(final Event mostRecent) {
    // Variable for the next earliest event.
    final Event nextMost = new Event("", "");

    // An array list to hold all the events in the database.
    final ArrayList<Event> eventList = getAllData();

    // Current Date Array.
    int[] curTime = {0,0,0};

    // Next Most Recent Time Array.
    int[] time = {0,0,0};



    // For each loop to compare the events in the database.
    for (final Event e : eventList) {

      // Parse current event and set month, day, year.
      parseDate(e.getDate(),curTime);

      // Log the event that was just parsed.
      Log.d(TAG, "Event: " + e.getDate() + " " + e.getName());

      /* Check if the current event is also the most recent date.
         Or if the most recent date does not exist. */
      if (e.getDate().equals(mostRecent.getDate())
              || mostRecent.getDate().equals("")) {
        continue;
      } else if (nextMost.getDate().equals("")) {
        // Parse the most recent date.
        parseDate(mostRecent.getDate(),time);

        /* check that the current event is not earlier than the most
           recent date passed into the method. */
        if (curTime[2] <= time[2] && curTime[0] <= time[0]
            && curTime[1] <= time[1]) {
          continue;
        } else {
          nextMost.setIdName(e.getIdName());
          nextMost.setDate(e.getDate());
          nextMost.setName(e.getName());
        }
      } else {  // Compare dates.
        // Parse most recent again.
        parseDate(mostRecent.getDate(),time);
        // Check that current event isn't before this date again.
        if (curTime[2] <= time[2] && curTime[0] <= time[0]
            && curTime[1] <= time[1]) {
          continue;
        } else {
          // Now Parse the current earliest date value.
          parseDate(nextMost.getDate(), time);

          // Compare date to current event.
          if (curTime[2] < time[2]) {
            nextMost.setIdName(e.getIdName());
            nextMost.setName(e.getName());
            nextMost.setDate(e.getDate());
          } else if (curTime[2] == time[2] && curTime[0] < time[0]) {
            nextMost.setIdName(e.getIdName());
            nextMost.setName(e.getName());
            nextMost.setDate(e.getDate());
          } else if (curTime[2] <= time[2] && curTime[0] <= time[0]
              && curTime[1] <= time[1]) {
            nextMost.setIdName(e.getIdName());
            nextMost.setName(e.getName());
            nextMost.setDate(e.getDate());
          }
        }
      }
    }

    // return the next earliest date from most recent.
    return nextMost;
  }

  /********************************************************************
   * Method for getting the number of events that are currently in the
   * database.
   * @return the number of events within the database.
   *******************************************************************/
  public int getNumEvents() {
    // Number of events.
    int count = 0;

    // Writable database.
    final SQLiteDatabase dbName = this.getWritableDatabase();

    // Query to get the entire table.
    final String query = "SELECT * FROM " + TABLE_NAME;

    // Point at it.
    final Cursor data = dbName.rawQuery(query, null);

    // Check that it's not empty.
    if (data.moveToFirst()) {
      // Loop and increase count as long as there is another event.
      do {
        count++;
      } while (data.moveToNext());
    } else {
      return count;
    }
    return count;
  }

  /********************************************************************
   * Parse Date method that separates the date from the string.
   * @param date the date in string form.
   * @param time an array for the month day and year.
   *******************************************************************/
  private void parseDate(String date, int[] time){
    // Log the Parsed date and assign the date values.
    Log.d(TAG, "Database Current Date: " + date);
    time[0] = parseInt(date.substring(0,
        date.indexOf("/")));
    date = date.substring(date.indexOf("/") + 1);
    Log.d(TAG, "Database Current Date minus month: " + date);
    time[1] = parseInt(date.substring(0,
        date.indexOf("/")));
    date = date.substring(date.indexOf("/") + 1);
    Log.d(TAG, "Database Current Year: " + date);
    time[2] = parseInt(date);
  }
}
