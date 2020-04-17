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
   * @param db The instance of the database to be changed.
   * @param oldVersion the previous version of the database.
   * @param newVersion the current version of the database.
   *******************************************************************/
  @Override
  public void onUpgrade(final SQLiteDatabase db,
                        final int oldVersion,
                        final int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    onCreate(db);
  }

  /********************************************************************
   * Method for creation of the database. Details the table key as
   * well as the values that should be within each column.
   * @param db the instance of data base to be created for.
   *******************************************************************/
  @Override
  public void onCreate(final SQLiteDatabase db) {
    // String to represent the SQL code for creating a table.
    final String createTable = "CREATE Table " + TABLE_NAME
            + "(\n" + COL1 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL2 + " CHAR(255) NOT NULL, "
            + COL3 + " CHAR(255) NOT NULL );";
    db.execSQL(createTable);
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
    final SQLiteDatabase db = this.getWritableDatabase();

    // method call to insert the data into the table.
    final long result = db.insert(TABLE_NAME, null, contentValues);

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
    final SQLiteDatabase db = this.getWritableDatabase();

    // String to represent the query.
    final String query = "SELECT * FROM " + TABLE_NAME;

    // Cursor which points to the data queried.
    final Cursor data = db.rawQuery(query, null);

    // Check if the database has any events.
    if (data.moveToFirst()) {
      // While there are events add them tp the event list.
      do {

        final Event ev = new Event();
        ev.setId(data.getInt(data.getColumnIndex(COL1)));
        ev.setName(data.getString(data.getColumnIndex(COL2)));
        ev.setDate(data.getString(data.getColumnIndex(COL3)));
        events.add(ev);

      } while (data.moveToNext());

    }

    /* Loop through the event list and display logged data of each
    event within the event list. */
    for (int i = 0; i < events.size(); i++) {
      Log.d(TAG, "Events List Id: " + i + " "
              + events.get(i).getId());
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
    final SQLiteDatabase db = this.getWritableDatabase();
    final String query = "SELECT " + COL1 + " FROM " + TABLE_NAME
            + " WHERE " + COL3 + " = '" + date + "'";
    final Cursor data = db.rawQuery(query, null);
    return data;
  }

  /********************************************************************
   * Method for updating the events name within the database.
   * @param newName the new name to set for the event.
   * @param id the id that this event is at.
   * @param oldName the current name of the event in the database.
   *******************************************************************/
  public void updateName(final String newName, final int id, final String oldName) {
    final SQLiteDatabase db = this.getWritableDatabase();
    final String query = "UPDATE " + TABLE_NAME + " SET " + COL2
            + " = '" + newName + "' Where " + COL1 + " = '" + id + "'"
            + " AND " + COL2 + " = '" + oldName + "'";
    Log.d(TAG, "updateName: query: " + query);
    Log.d(TAG, "updateName: Setting name to " + newName);
    db.execSQL(query);
  }

  /********************************************************************
   * Method for updating the events date within the database.
   * @param newDate the new date to set for the event.
   * @param id the id that this event is at.
   * @param oldDate the current date of the event in the database.
   *******************************************************************/
  public void updateDate(final String newDate, final int id, final String oldDate) {
    final SQLiteDatabase db = this.getWritableDatabase();
    final String query = "UPDATE " + TABLE_NAME + " SET " + COL3
            + " = '" + newDate + "' Where " + COL1 + " = '" + id + "'"
            + " AND " + COL3 + " = '" + oldDate + "'";
    Log.d(TAG, "updateName: query: " + query);
    Log.d(TAG, "updateName: Setting name to " + newDate);
    db.execSQL(query);
  }

  /********************************************************************
   * Method for removing an event from the database.
   * @param id the id of the event to be removed.
   * @param name the name of the event.
   * @param date the date of the event.
   *******************************************************************/
  public void deleteEvent(final int id, final String name, final String date) {
    final SQLiteDatabase db = this.getWritableDatabase();
    final String query = "DELETE FROM " + TABLE_NAME + " WHERE "
            + COL1 + " = '" + id + "'" + " AND " + COL3
            + " = '" + date + "'";
    Log.d(TAG, "deleteName: query: " + query);
    Log.d(TAG, "deleteName: Deleting Event: " + name + " on " + date);
    db.execSQL(query);
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

    // The current events month.
    int curMonth;

    // The current events day.
    int curDay;

    // The current events year.
    int curYear;

    // The most recent month.
    int month;

    // The most recent day.
    int day;

    // The most recent year.
    int year;

    // Get the writable database.
    final SQLiteDatabase db = this.getWritableDatabase();

    // Query the entire table.
    final String query = "SELECT * FROM " + TABLE_NAME;

    // Set the cursor to point at the data.
    final Cursor data = db.rawQuery(query, null);

    // Log that query was ran.
    Log.d(TAG, "Query Ran");

    // Check if any events exist within the database.
    if (data.moveToFirst()) {
      do {
        // set the current event to the event pointed at by cursor.
        curEvent.setId(data.getInt(data.getColumnIndex(COL1)));
        curEvent.setName(data.getString(data.getColumnIndex(COL2)));
        curEvent.setDate(data.getString(data.getColumnIndex(COL3)));

        // Set the date parse to the current event date.
        dateParts = curEvent.getDate();
        // Log the Parsed date and assign the date values.
        Log.d(TAG, "Database Current Date: " + dateParts);
        curMonth = parseInt(dateParts.substring(0,
                dateParts.indexOf("/")));
        dateParts = dateParts.substring(dateParts.indexOf("/") + 1);
        Log.d(TAG, "Database Current Date minus month: " + dateParts);
        curDay = parseInt(dateParts.substring(0,
                dateParts.indexOf("/")));
        dateParts = dateParts.substring(dateParts.indexOf("/") + 1);
        Log.d(TAG, "Database Current Year: " + dateParts);
        curYear = parseInt(dateParts);

        // Check if there isn't a most recent date amd assign it.
        if (mostRecent.getDate().equals("")) {
          mostRecent.setName(curEvent.getName());
          mostRecent.setDate(curEvent.getDate());
        } else {
          // Now reassign the int parser to the most recent event.
          dateParts = mostRecent.getDate();
          month = parseInt(dateParts.substring(0,
                  dateParts.indexOf("/")));
          dateParts = dateParts.substring(dateParts.indexOf("/") + 1);
          day = parseInt(dateParts.substring(0,
                  dateParts.indexOf("/")));
          dateParts = dateParts.substring(dateParts.indexOf("/") + 1);
          year = parseInt(dateParts);

          // Compare the Two dates and see which one is earlier..
          if (curYear < year) {
            mostRecent.setId(curEvent.getId());
            mostRecent.setName(curEvent.getName());
            mostRecent.setDate(curEvent.getDate());
          } else if (curYear == year && curMonth < month) {
            mostRecent.setId(curEvent.getId());
            mostRecent.setName(curEvent.getName());
            mostRecent.setDate(curEvent.getDate());
          } else if (curYear == year && curMonth == month
                  && curDay < day) {
            mostRecent.setId(curEvent.getId());
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

    // Data parse and date format same as mostRecent
    String dateParts;
    int curMonth;
    int curDay;
    int curYear;
    int month;
    int day;
    int year;

    // For each loop to compare the events in the database.
    for (final Event e : eventList) {

      // Parse current event and set month, day, year.
      dateParts = e.getDate();
      curMonth = parseInt(dateParts.substring(0,
              dateParts.indexOf("/")));
      dateParts = dateParts.substring(dateParts.indexOf("/") + 1);
      curDay = parseInt(dateParts.substring(0,
              dateParts.indexOf("/")));
      dateParts = dateParts.substring(dateParts.indexOf("/") + 1);
      curYear = parseInt(dateParts);

      // Log the event that was just parsed.
      Log.d(TAG, "Event: " + e.getDate() + " " + e.getName());

      /* Check if the current event is also the most recent date.
         Or if the most recent date does not exist. */
      if (e.getDate().equals(mostRecent.getDate())
              || mostRecent.getDate().equals("")) {
        continue;
      } else if (nextMost.getDate().equals("")) {
        // Parse the most recent date.
        dateParts = mostRecent.getDate();
        month = parseInt(dateParts.substring(0, dateParts.indexOf("/")));
        dateParts = dateParts.substring(dateParts.indexOf("/") + 1);
        day = parseInt(dateParts.substring(0, dateParts.indexOf("/")));
        dateParts = dateParts.substring(dateParts.indexOf("/") + 1);
        year = parseInt(dateParts);

        /* check that the current event is not earlier than the most
           recent date passed into the method. */
        if (curYear <= year && curMonth <= month && curDay <= day) {
          continue;
        } else {
          nextMost.setId(e.getId());
          nextMost.setDate(e.getDate());
          nextMost.setName(e.getName());
        }
      } else {  // Compare dates.
        // Parse most recent again.
        dateParts = mostRecent.getDate();
        month = parseInt(dateParts.substring(0, dateParts.indexOf("/")));
        dateParts = dateParts.substring(dateParts.indexOf("/") + 1);
        day = parseInt(dateParts.substring(0, dateParts.indexOf("/")));
        dateParts = dateParts.substring(dateParts.indexOf("/") + 1);
        year = parseInt(dateParts);
        // Check that current event isn't before this date again.
        if (curYear <= year && curMonth <= month && curDay <= day) {
          continue;
        } else {
          // Now Parse the current earliest date value.
          dateParts = nextMost.getDate();
          month = parseInt(dateParts.substring(0, dateParts.indexOf("/")));
          dateParts = dateParts.substring(dateParts.indexOf("/") + 1);
          day = parseInt(dateParts.substring(0, dateParts.indexOf("/")));
          dateParts = dateParts.substring(dateParts.indexOf("/") + 1);
          year = parseInt(dateParts);

          // Compare date to current event.
          if (curYear < year) {
            nextMost.setId(e.getId());
            nextMost.setName(e.getName());
            nextMost.setDate(e.getDate());
          } else if (curYear == year && curMonth < month) {
            nextMost.setId(e.getId());
            nextMost.setName(e.getName());
            nextMost.setDate(e.getDate());
          } else if (curYear == year && curMonth == month && curDay < day) {
            nextMost.setId(e.getId());
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
    final SQLiteDatabase db = this.getWritableDatabase();

    // Query to get the entire table.
    final String query = "SELECT * FROM " + TABLE_NAME;

    // Point at it.
    final Cursor data = db.rawQuery(query, null);

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
}
