package com.example.challengerapproaching.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

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
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
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

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public Cursor getItemID(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COL1 + " FROM " + TABLE_NAME +
                " WHERE " + COL2 + " = '" + name + "'";
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

    public void deleteEvent(int id, String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE "
                + COL1 + " = '" + id + "'" + " AND " + COL2
                + " = '" + name + "'";
        Log.d(TAG, "deleteName: query: " + query);
        Log.d(TAG, "deleteName: Deleting Event: " + name);
        db.execSQL(query);

    }
}
