package com.example.challengerapproaching.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;


public class databaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";

    private static final String TABLE_NAME = "Events_table";
    private static final String COL1 = "ID";
    private static final String COL2 = "NAME";
    private static final String COL3 = "DATE";


    public databaseHelper(Context context){
        super(context, TABLE_NAME,null, 1);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE Table " + TABLE_NAME +
                "(\n" + COL1 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL2 + " CHAR(255) NOT NULL, "
                + COL3 + " CHAR(255) NOT NULL );";
        db.execSQL(createTable);
    }

    public boolean addData(String item1, String item2) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, item1);
        contentValues.put(COL3, item2);

        Log.d(TAG, "addData: Adding " + item1 + " to " + TABLE_NAME);
        Log.d(TAG, "addData: Adding " + item2 + " to " + TABLE_NAME);

        long result = db.insert(TABLE_NAME,null,contentValues);

        if (result == -1){
            return  false;
        }
        else{
            return true;
        }
    }

    public ArrayList<event> getAllData(){
        ArrayList<event> events = new ArrayList<event>();
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);

        if (data.moveToFirst()) {
            do {
                event ev = new event();
                ev.setId(data.getInt(data.getColumnIndex(COL1)));
                ev.setName(data.getString(data.getColumnIndex(COL2)));
                ev.setDate(data.getString(data.getColumnIndex(COL3)));
                events.add(ev);
            } while(data.moveToNext());
        }
        for(int i = 0; i < events.size(); i++) {
            Log.d(TAG, "Events List Id: " + i + " " + events.get(i).getId());
            Log.d(TAG, "Events List Name: " + i + " " + events.get(i).getName());
            Log.d(TAG, "Events List Date: " + i + " " + events.get(i).getDate());
        }
        return events;
    }

//    public Cursor getNameID(String name){
//        SQLiteDatabase db = this.getWritableDatabase();
//        String query = "SELECT " + COL1 + " FROM " + TABLE_NAME +
//                " WHERE " + COL3 + " = '" + name + "'";
//        Cursor data = db.rawQuery(query, null);
//        return data;
//    }

    public Cursor getDateID(String date){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COL1 + " FROM " + TABLE_NAME +
                " WHERE " + COL3 + " = '" + date + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public void updateName(String newName, int id, String oldName){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL2 +
                " = '" + newName + "' Where " + COL1 + " = '" + id + "'" +
                " AND " + COL2 + " = '" + oldName + "'";
        Log.d(TAG, "updateName: query: " + query);
        Log.d(TAG, "updateName: Setting name to " + newName);
        db.execSQL(query);
    }

    public void updateDate(String newDate, int id, String oldDate){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL3 +
                " = '" + newDate + "' Where " + COL1 + " = '" + id + "'" +
                " AND " + COL3 + " = '" + oldDate + "'";
        Log.d(TAG, "updateName: query: " + query);
        Log.d(TAG, "updateName: Setting name to " + newDate);
        db.execSQL(query);
    }

    public void deleteEvent(int id, String name, String date){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE "
                + COL1 + " = '" + id + "'" + " AND " + COL3
                + " = '" + date + "'";
        Log.d(TAG, "deleteName: query: " + query);
        Log.d(TAG, "deleteName: Deleting Event: " + name + " on " +  date);
        db.execSQL(query);

    }

    public event getMostRecent(){
        event mostRecent = new event("None", "None");
        event curEvent = new event();
        String dateParts;
        int curMonth, curDay, curYear;
        int month, day, year;
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        Log.d(TAG, "Query Ran");
        if (data.moveToFirst()){
            do {
                curEvent.setId(data.getInt(data.getColumnIndex(COL1)));
                curEvent.setName(data.getString(data.getColumnIndex(COL2)));
                curEvent.setDate(data.getString(data.getColumnIndex(COL3)));
                dateParts = curEvent.getDate();
                Log.d(TAG,"Database Current Date: " + dateParts);
                curMonth = parseInt(dateParts.substring(0,dateParts.indexOf("/")));
                dateParts = dateParts.substring(dateParts.indexOf("/")+1);
                Log.d(TAG,"Database Current Date minus month: " + dateParts);
                curDay = parseInt(dateParts.substring(0, dateParts.indexOf("/")));
                dateParts = dateParts.substring(dateParts.indexOf("/")+1);
                Log.d(TAG,"Database Current Year: " + dateParts);
                curYear = parseInt(dateParts);

                if (mostRecent.getDate().equals("None")) {
                    mostRecent.setName(curEvent.getName());
                    mostRecent.setDate(curEvent.getDate());
                }
                else{
                    dateParts = mostRecent.getDate();
                    month = parseInt(dateParts.substring(0,dateParts.indexOf("/")));
                    dateParts = dateParts.substring(dateParts.indexOf("/")+1);
                    day = parseInt(dateParts.substring(0, dateParts.indexOf("/")));
                    dateParts = dateParts.substring(dateParts.indexOf("/")+1);
                    year = parseInt(dateParts);

                    if(curYear < year){
                        mostRecent.setId(curEvent.getId());
                        mostRecent.setName(curEvent.getName());
                        mostRecent.setDate(curEvent.getDate());
                    }
                    else if(curYear == year && curMonth < month){
                        mostRecent.setId(curEvent.getId());
                        mostRecent.setName(curEvent.getName());
                        mostRecent.setDate(curEvent.getDate());
                    }
                    else if(curYear == year && curMonth == month && curDay < day){
                        mostRecent.setId(curEvent.getId());
                        mostRecent.setName(curEvent.getName());
                        mostRecent.setDate(curEvent.getDate());
                    }
                }
                Log.d(TAG, "Most Recent Date: " + mostRecent.getDate());
            } while(data.moveToNext());
        }
        return mostRecent;
    }

    public int getNumEvents(){
        int count = 0;
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        if(data.moveToFirst()){
            do{
                count++;
            } while(data.moveToNext());
        }
        else{
            return count;
        }
        return count;
    }
}
