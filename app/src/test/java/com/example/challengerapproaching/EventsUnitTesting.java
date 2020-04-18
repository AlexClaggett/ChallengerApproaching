package com.example.challengerapproaching;

import com.example.challengerapproaching.utils.Event;
import org.junit.Assert;
import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class EventsUnitTesting {//NOPMD

    /** Event Default Constructor*/
    @Test
    public void Event_Default_Constructor (){//NOPMD
        final Event event = new Event();
        Assert.assertEquals("None", event.getName());
        Assert.assertEquals("None",event.getDate());
        Assert.assertEquals(-1, event.getIdName());
    }

    /**Event Constructor for No ID*/
    @Test
    public void Event_NO_ID_Constructor (){//NOPMD
        final String name = "Smash";//NOPMD
        final String date = "4/17/2020";//NOPMD
        final Event event = new Event(name, date);
        Assert.assertEquals(name, event.getName());
        Assert.assertEquals(date,event.getDate());
        Assert.assertEquals(-1, event.getIdName());
    }

    /**Event Constructor with ID*/
    @Test
    public void Event_WITH_ID_Constructor (){//NOPMD
        final int dataId = 5;//NOPMD
        final String name = "Smush";//NOPMD
        final String date = "4/20/2020";//NOPMD
        final Event event = new Event(dataId, name, date);
        Assert.assertEquals(name, event.getName());
        Assert.assertEquals(date,event.getDate());
        Assert.assertEquals(dataId, event.getIdName());
    }

    /**Setter of Events*/
    @Test
    public void Event_Setters (){//NOPMD
        final Event event = new Event(5,"Smash", "4/15/2020");
        event.setName("S");
        Assert.assertEquals("S", event.getName());
        event.setDate("4/31/2020");
        Assert.assertEquals("4/31/2020", event.getDate());
        event.setIdName(123);
        Assert.assertEquals(123, event.getIdName());
    }
}