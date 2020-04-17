package com.example.challengerapproaching.utils;

public class Event {
  private int id;
  private String name;
  private String date;

  public Event() {
    id = -1;
    name = "None";
    date = "None";
  }


  public Event(String name, String date) {
    this.id = -1;
    this.name = name;
    this.date = date;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDate() {
    return this.date;
  }

  public void setDate(String date) {
    this.date = date;
  }
}
