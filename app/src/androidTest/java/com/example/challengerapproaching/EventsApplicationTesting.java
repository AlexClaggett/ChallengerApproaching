package com.example.challengerapproaching;

import android.content.Context;
import androidx.test.core.app.ApplicationProvider;
import android.database.Cursor;
import android.util.Log;
import com.example.challengerapproaching.utils.DatabaseHelper;
import com.example.challengerapproaching.utils.Event;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class EventsApplicationTesting {

    /**Context for testing*/
    private final transient Context context = ApplicationProvider.getApplicationContext();

    /**Tag for testing*/
    private static final String TAG = "UNIT_TESTING";

    /**Names for testing*/
    private final transient String[] testNames = { "a", "b", "c", "d" };

    /**Dates for testing*/
    private final transient String[] testDates = { "4/17/2020", "5/17/2020",
        "6/17/2020", "7/17/2020" };

    /** Test that A Database is created. */
    @Test
    public void DatabaseHelper_onCreate() {
        final DatabaseHelper helper = new DatabaseHelper(context);
        Assert.assertEquals("Events_Table",helper.getDatabaseName());
        helper.close();
    }

    /** Test adding data into the database and the data inside. */
    @Test
    public void DatabaseHelper_addData() {
        final DatabaseHelper helper = new DatabaseHelper(context);

        Assert.assertTrue(helper.addData("Smash", "4/17/18"));
        int dataId = -1;
        Log.d(TAG, "Date ID: " + dataId);
        final Cursor data = helper.getDateID("4/17/18");
        while(data.moveToNext()){
            dataId = data.getInt(0);
            boolean check = data.moveToNext();
        }
        Assert.assertTrue(dataId != -1);
        Assert.assertFalse(helper.addData(null,"4/17/2020"));
        Assert.assertFalse(helper.addData("EVENT!",null));
        data.close();
        helper.close();
    }

    /** Test getting the data and the values retrieved. */
    @Test
    public void DatabaseHelper_getAllData() {
        final DatabaseHelper helper = new DatabaseHelper(context);
        helper.addData("1", "5/5/2020");
        helper.addData("2", "5/6/2020");
        helper.addData("3", "5/7/2020");
        helper.addData("4", "5/8/2020");
        ArrayList<Event> events = new ArrayList<>();
        events = helper.getAllData();
        int count = 1;
        final String[] dates = {"5/5/2020", "5/6/2020", "5/7/2020","5/8/2020"};

        // Check Events in database
        for(final Event e: events){
            assert e.getName().equals(Integer.toString(count));
            assert e.getDate().equals(dates[count-1]);
            count++;
        }
        helper.close();
    }

    /** Test changing an event name and if it updated. */
    @Test
    public void DatabaseHelper_updateName(){
        final DatabaseHelper helper = new DatabaseHelper(context);
        helper.addData("1", "5/5/2020");
        int dataId = -1;
        Log.d(TAG, "Date ID: " + dataId);
        Cursor data;
        data = helper.getDateID("5/5/2020");
        while(data.moveToNext()){
            dataId = data.getInt(0);
        }
        helper.updateName("2",dataId,"1");
        ArrayList<Event> events = new ArrayList<>();
        events = helper.getAllData();
        assert events.get(0).getName().equals("2");
        helper.updateName("1abc2def",dataId,"2");
        assert events.get(0).getName().equals("2");
        helper.updateName("smash a bash",dataId,"1abc2def");
        assert events.get(0).getName().equals("smash a bash");
        helper.updateName("abc",dataId,"1");
        assert events.get(0).getName().equals("abc");
        helper.close();
    }

    /** Test changing the event date and if the value changed. */
    @Test
    public void DatabaseHelper_updateDate(){
        final DatabaseHelper helper = new DatabaseHelper(context);
        helper.addData("1", "5/5/2020");
        int dataId = -1;
        Log.d(TAG, "Date ID: " + dataId);
        final Cursor data = helper.getDateID("5/5/2020");
        while(data.moveToNext()){
            dataId = data.getInt(0);
        }
        helper.updateDate("5/10/2020",dataId,"5/5/2020");
        ArrayList<Event> events = new ArrayList<>();
        events = helper.getAllData();
        assert events.get(0).getName().equals("5/10/2020");
        helper.updateDate("7/10/2020",dataId,"5/10/2020");
        assert events.get(0).getName().equals("7/10/2020");
        helper.updateDate("9/20/3030",dataId,"7/10/2020");
        assert events.get(0).getName().equals("9/20/3030");
        helper.updateDate("1/20/1996",dataId,"9/20/3030");
        assert events.get(0).getName().equals("1/20/1996");
        helper.close();
    }

    /** Test Deleting event from the database and verifying its gone.*/
    @Test
    public void DatabaseHelper_DeleteEvent(){
        final DatabaseHelper helper = new DatabaseHelper(context);

        helper.addData("1", "55/555/2020");
        int dataId = -1;
        Log.d(TAG, "Date ID: " + dataId);
        Cursor data = helper.getDateID("55/555/2020");
        while(data.moveToNext()){
            dataId = data.getInt(0);
        }

        Log.d(TAG, "Date ID: " + dataId);
        assert dataId != -1;
        helper.deleteEvent(dataId,"1", "55/555/2020");
        dataId = -1;
        Log.d(TAG, "Date ID: " + dataId);
        data = helper.getDateID("55/555/2020");
        while(data.moveToNext()){
            dataId = data.getInt(0);
        }
        Log.d(TAG, "Date ID: " + dataId);

        Assert.assertTrue(dataId == -1);
        helper.close();
    }

    /** Test Most Recent Date. */
    @Test
    public void DatabaseHelper_MostRecent(){
        final DatabaseHelper helper = new DatabaseHelper(context);

        for(int i = 0; i < 4; i++){
            helper.addData(testNames[i], testDates[i]);
        }
        Event event;
        event = helper.getMostRecent();
        assert event.getName().equals(testNames[0]);
        assert event.getDate().equals(testDates[0]);
        helper.close();
    }

    /** Test Next Most Recent in database. */
    @Test
    public void DatabaseHelper_NextMostRecent(){
        final DatabaseHelper helper = new DatabaseHelper(context);

        for(int i = 0; i < 4; i++){
            helper.addData(testNames[i], testDates[i]);
        }
        Event event;
        event = helper.getMostRecent();
        event = helper.nextMostRecent(event);
        assert event.getName().equals(testNames[1]);
        assert event.getDate().equals(testDates[1]);
        helper.close();
    }

    /** Test retrieving the number of events in the database. */
    @Test
    public void DatabaseHelper_getNumEvents(){
        final DatabaseHelper helper = new DatabaseHelper(context);
        int total;
        for(int i = 0; i < 4; i++){
            helper.addData(testNames[i], testDates[i]);
        }
        total = helper.getNumEvents();
        assert total == 4;
        helper.close();
    }


}