package com.example.challengerapproaching.utils;

/**********************************************************************
 * Class that handles what an Event is and what it holds inside.
 *********************************************************************/
public class Event {
  /** The ID of the Event. */
  private int id;

  /** The NAME of the Event. */
  private String name;

  /** The DATE of the Event. */
  private String date;

  /********************************************************************
   * Constructor for initializing an empty event.
   *******************************************************************/
  public Event() {
    id = -1;
    name = "None";
    date = "None";
  }

  /********************************************************************
   * Constructor for initializing an event with a name and date.
   * @param name the name of the event.
   * @param date the date of the event.
   *******************************************************************/
  public Event(String name, String date) {
    this.id = -1;
    this.name = name;
    this.date = date;
  }

  /********************************************************************
   * Constructor for initializing an event with an id, name, and date.
   * @param id the id of the event.
   * @param name the name of the event.
   * @param date the date of the event.
   *******************************************************************/
  public Event(int id, String name, String date) {
    this.id = id;
    this.name = name;
    this.date = date;
  }

  /********************************************************************
   * Method for retrieving the event's ID.
   * @return the events ID.
   *******************************************************************/
  public int getId() {
    return id;
  }

  /********************************************************************
   * Method for setting the event's ID.
   * @param id the ID to give the event.
   *******************************************************************/
  public void setId(int id) {
    this.id = id;
  }

  /********************************************************************
   * Method for retrieving the name of the event.
   * @return the events name.
   *******************************************************************/
  public String getName() {
    return name;
  }

  /********************************************************************
   * Method for setting the name of the event.
   * @param name the NAME to give the event.
   *******************************************************************/
  public void setName(String name) {
    this.name = name;
  }

  /********************************************************************
   * Method to get the events date.
   * @return the date the event takes place on.
   *******************************************************************/
  public String getDate() {
    return this.date;
  }

  /********************************************************************
   * Method for setting the date of the event.
   * @param date the date to set the event to.
   *******************************************************************/
  public void setDate(String date) {
    this.date = date;
  }
}
