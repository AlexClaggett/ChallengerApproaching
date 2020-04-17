package com.example.challengerapproaching;

import com.example.challengerapproaching.utils.Event;
import org.junit.Assert;
import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class EventsUnitTesting {

    /** Event Default Constructor*/
    @Test
    public void Event_Default_Constructor (){
        Event e = new Event();
        Assert.assertEquals("None", e.getName());
        Assert.assertEquals("None",e.getDate());
        Assert.assertEquals(-1, e.getIdName());
    }

    /**Event Constructor for No ID*/
    @Test
    public void Event_NO_ID_Constructor (){
        String name = "Smash";
        String date = "4/17/2020";
        Event e = new Event(name, date);
        Assert.assertEquals(name, e.getName());
        Assert.assertEquals(date,e.getDate());
        Assert.assertEquals(-1, e.getIdName());
    }

    /**Event Constructor with ID*/
    @Test
    public void Event_WITH_ID_Constructor (){
        int id = 5;
        String name = "Smush";
        String date = "4/20/2020";
        Event e = new Event(id, name, date);
        Assert.assertEquals(name, e.getName());
        Assert.assertEquals(date,e.getDate());
        Assert.assertEquals(id, e.getIdName());
    }

    /**Setter of Events*/
    @Test
    public void Event_Setters (){
        Event e = new Event(5,"Smash", "4/15/2020");
        e.setName("S");
        Assert.assertEquals("S", e.getName());
        e.setDate("4/31/2020");
        Assert.assertEquals("4/31/2020", e.getDate());
        e.setIdName(123);
        Assert.assertEquals(123, e.getIdName());
    }
}