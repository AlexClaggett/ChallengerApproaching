package com.example.challengerapproaching.utils;

public class event {
    private int id;
    private String name;
    private String date;

    public event() {
        id = -1;
        name = "None";
        date = "None";
    }

    public event(int ID, String Name, String Date){
        this.id = ID;
        this.name = Name;
        this.date = Date;
    }

    public event(String name, String date){
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
