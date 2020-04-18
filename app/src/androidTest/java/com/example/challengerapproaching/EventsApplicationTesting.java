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
    private Context context = ApplicationProvider.getApplicationContext();
    private static final String TAG = "UNIT_TESTING";
    private String[] testNames = { "a", "b", "c", "d" };
    private String[] testDates = { "4/17/2020", "5/17/2020",
        "6/17/2020", "7/17/2020" };

    /** Test that A Database is created. */
    @Test
    public void DatabaseHelper_onCreate() {
        DatabaseHelper db = new DatabaseHelper(context);
        Assert.assertEquals("Events_Table",db.getDatabaseName());
        db.close();
    }

    /** Test adding data into the database and the data inside. */
    @Test
    public void DatabaseHelper_addData() {
        DatabaseHelper db = new DatabaseHelper(context);

        Assert.assertTrue(db.addData("Smash", "4/17/18"));
        int id = -1;
        Log.d(TAG, "Date ID: " + id);
        Cursor data = db.getDateID("4/17/18");
        while(data.moveToNext()){
            id = data.getInt(0);
        }
        Assert.assertTrue(id != -1);
        Assert.assertFalse(db.addData(null,"4/17/2020"));
        Assert.assertFalse(db.addData("EVENT!",null));
        data.close();
        db.close();
    }

    /** Test getting the data and the values retrieved. */
    @Test
    public void DatabaseHelper_getAllData() {
        DatabaseHelper db = new DatabaseHelper(context);
        db.addData("1", "5/5/2020");
        db.addData("2", "5/6/2020");
        db.addData("3", "5/7/2020");
        db.addData("4", "5/8/2020");
        ArrayList<Event> ev = new ArrayList<>();
        ev = db.getAllData();
        int i = 1;
        String[] dates = {"5/5/2020", "5/6/2020", "5/7/2020","5/8/2020"};

        // Check Events in database
        for(Event e: ev){
            assert(e.getName().equals(Integer.toString(i)));
            assert(e.getDate().equals(dates[i-1]));
            i++;
        }
        db.close();
    }

    /** Test changing an event name and if it updated. */
    @Test
    public void DatabaseHelper_updateName(){
        DatabaseHelper db = new DatabaseHelper(context);
        db.addData("1", "5/5/2020");
        int id = -1;
        Log.d(TAG, "Date ID: " + id);
        Cursor data;
        data = db.getDateID("5/5/2020");
        while(data.moveToNext()){
            id = data.getInt(0);
        }
        db.updateName("2",id,"1");
        ArrayList<Event> ev = new ArrayList<>();
        ev = db.getAllData();
        assert(ev.get(0).getName().equals("2"));
        db.updateName("1abc2def",id,"2");
        assert(ev.get(0).getName().equals("2"));
        db.updateName("smash a bash",id,"1abc2def");
        assert(ev.get(0).getName().equals("smash a bash"));
        db.updateName("abc",id,"1");
        assert(ev.get(0).getName().equals("abc"));
        db.close();
    }

    /** Test changing the event date and if the value changed. */
    @Test
    public void DatabaseHelper_updateDate(){
        DatabaseHelper db = new DatabaseHelper(context);
        db.addData("1", "5/5/2020");
        int id = -1;
        Log.d(TAG, "Date ID: " + id);
        Cursor data = db.getDateID("5/5/2020");
        while(data.moveToNext()){
            id = data.getInt(0);
        }
        db.updateDate("5/10/2020",id,"5/5/2020");
        ArrayList<Event> ev = new ArrayList<>();
        ev = db.getAllData();
        assert(ev.get(0).getName().equals("5/10/2020"));
        db.updateDate("7/10/2020",id,"5/10/2020");
        assert(ev.get(0).getName().equals("7/10/2020"));
        db.updateDate("9/20/3030",id,"7/10/2020");
        assert(ev.get(0).getName().equals("9/20/3030"));
        db.updateDate("1/20/1996",id,"9/20/3030");
        assert(ev.get(0).getName().equals("1/20/1996"));
        db.close();
    }

    /** Test Deleting event from the database and verifying its gone.*/
    @Test
    public void DatabaseHelper_DeleteEvent(){
        DatabaseHelper db = new DatabaseHelper(context);

        db.addData("1", "55/555/2020");
        int id = -1;
        Log.d(TAG, "Date ID: " + id);
        Cursor data = db.getDateID("55/555/2020");
        while(data.moveToNext()){
            id = data.getInt(0);
        }

        Log.d(TAG, "Date ID: " + id);
        assert(id != -1);
        db.deleteEvent(id,"1", "55/555/2020");
        id = -1;
        Log.d(TAG, "Date ID: " + id);
        data = db.getDateID("55/555/2020");
        while(data.moveToNext()){
            id = data.getInt(0);
        }
        Log.d(TAG, "Date ID: " + id);

        Assert.assertTrue(id == -1);
        db.close();
    }

    /** Test Most Recent Date. */
    @Test
    public void DatabaseHelper_MostRecent(){
        DatabaseHelper db = new DatabaseHelper(context);

        for(int i = 0; i < 4; i++){
            db.addData(testNames[i], testDates[i]);
        }
        Event e;
        e = db.getMostRecent();
        assert(e.getName().equals(testNames[0]));
        assert(e.getDate().equals(testDates[0]));
        db.close();
    }

    /** Test Next Most Recent in database. */
    @Test
    public void DatabaseHelper_NextMostRecent(){
        DatabaseHelper db = new DatabaseHelper(context);

        for(int i = 0; i < 4; i++){
            db.addData(testNames[i], testDates[i]);
        }
        Event e;
        e = db.getMostRecent();
        e = db.nextMostRecent(e);
        assert(e.getName().equals(testNames[1]));
        assert(e.getDate().equals(testDates[1]));
        db.close();
    }

    /** Test retrieving the number of events in the database. */
    @Test
    public void DatabaseHelper_getNumEvents(){
        DatabaseHelper db = new DatabaseHelper(context);
        int total;
        for(int i = 0; i < 4; i++){
            db.addData(testNames[i], testDates[i]);
        }
        total = db.getNumEvents();
        assert(total == 4);
        db.close();
    }


}