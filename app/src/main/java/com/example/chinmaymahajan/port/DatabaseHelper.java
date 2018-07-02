package com.example.chinmaymahajan.port;



import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "MovieDetails";

    // Labels table name
    private static final String NAME_TABLE = "movieName";
    private static final String DATE_TABLE = "movieDate";
    private static final String TIME_TABLE = "movieTime";
    private static final String SEATS_TABLE = "movieSeats";

    // Labels Table Columns names
    private static final String KEY_ID = "id";
    private static final String NAME_COL = "Name";
    private static final String DATE_COL = "Date";
    private static final String TIME_COL = "Time";
    private static final String SEATS_COL = "Seats";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Category table create query
        String NAMEtABLE = "CREATE TABLE " + NAME_TABLE + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + NAME_COL + " TEXT)";

        String DATEtABLE = "CREATE TABLE " + DATE_TABLE + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + DATE_COL + " TEXT)";

        String TIMEtABLE = "CREATE TABLE " + TIME_TABLE + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + TIME_COL + " TEXT)";

        String SEATStABLE = "CREATE TABLE " + SEATS_TABLE + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + SEATS_COL + " TEXT)";

        db.execSQL(NAMEtABLE);
        db.execSQL(DATEtABLE);
        db.execSQL(SEATStABLE);
        db.execSQL(TIMEtABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + NAME_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + DATE_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + TIME_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + SEATS_TABLE);

        // Create tables again
        onCreate(db);
    }

    /**
     * Inserting new lable into lables table
     * */
    void insertMovie(MovieObject movieObject){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME_COL, movieObject.getName());
        db.insert(NAME_TABLE, null, values);

        ContentValues values2 = new ContentValues();
        values2.put(DATE_COL, movieObject.getDate());
        db.insert(DATE_TABLE, null, values2);

        ContentValues values3 = new ContentValues();
        values3.put(TIME_COL, movieObject.getTime());
        db.insert(TIME_TABLE, null, values3);

        ContentValues values4 = new ContentValues();
        values4.put(SEATS_COL, movieObject.getSeats());
        db.insert(SEATS_TABLE, null, values4);

        // Inserting Row
        db.close(); // Closing database connection
    }


    /**
     * Getting all labels
     * returns list of labels
     * */
    public List<String> getAllNames(){
        List<String> names = new ArrayList<String>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + NAME_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                names.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        db.close();

        // returning lables
        return names;
    }

    public List<String> getAllSeats(){
        List<String> names = new ArrayList<String>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + SEATS_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                names.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        db.close();

        // returning lables
        return names;
    }

    public List<String> getAllTimes(){
        List<String> names = new ArrayList<String>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TIME_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                names.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        db.close();

        // returning lables
        return names;
    }

    public List<String> getAllDates(){
        List<String> names = new ArrayList<String>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + DATE_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                names.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        db.close();

        // returning lables
        return names;
    }

}
