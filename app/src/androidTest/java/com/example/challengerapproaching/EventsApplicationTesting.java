package com.example.challengerapproaching;

import android.content.Context;
import androidx.test.core.app.ApplicationProvider;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.challengerapproaching.EventsActivity;
import com.example.challengerapproaching.utils.DatabaseHelper;
import com.example.challengerapproaching.utils.EditDataActivity;
import com.example.challengerapproaching.utils.Event;
import com.example.challengerapproaching.utils.EventDialog;
import com.example.challengerapproaching.utils.ListDataActivity;


import org.junit.Assert;
import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class EventsApplicationTesting {
    private Context context = ApplicationProvider.getApplicationContext();
    private static final String TAG = "UNIT_TESTING";
    @Test
    public void Event_Default_Constructor (){
        Event e = new Event();
        Assert.assertEquals("None", e.getName());
        Assert.assertEquals("None",e.getDate());
        Assert.assertEquals(-1, e.getId());
    }
    @Test
    public void Event_NO_ID_Constructor (){
        String name = "Smash";
        String date = "4/17/2020";
        Event e = new Event(name, date);
        Assert.assertEquals(name, e.getName());
        Assert.assertEquals(date,e.getDate());
        Assert.assertEquals(-1, e.getId());
    }
    @Test
    public void Event_WITH_ID_Constructor (){
        int id = 5;
        String name = "Smush";
        String date = "4/20/2020";
        Event e = new Event(id, name, date);
        Assert.assertEquals(name, e.getName());
        Assert.assertEquals(date,e.getDate());
        Assert.assertEquals(id, e.getId());
    }
    @Test
    public void Event_Setters (){
        Event e = new Event(5,"Smash", "4/15/2020");
        e.setName("S");
        Assert.assertEquals("S", e.getName());
        e.setDate("4/31/2020");
        Assert.assertEquals("4/31/2020", e.getDate());
        e.setId(123);
        Assert.assertEquals(123, e.getId());
    }

    @Test
    public void DatabaseHelper_onCreate() {
        DatabaseHelper db = new DatabaseHelper(context);
        Assert.assertEquals("Events_Table",db.getDatabaseName());
    }



}