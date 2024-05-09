package com.fare4z.mycv;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "mycvApps.db" ;
    private static final int DATABASE_VERSION = 1;

   public DatabaseHelper (Context context) {
       super(context, DATABASE_NAME, null, DATABASE_VERSION);
   }

    // Define the table creation SQL statement
    private static final String TABLE_CREATE_USER = "CREATE TABLE IF NOT EXISTS tblUser " +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "fullname TEXT, " +
            "email TEXT, " +
            "nric TEXT, " +
            "password TEXT)";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tblUser");
        onCreate(db);
    }
}
