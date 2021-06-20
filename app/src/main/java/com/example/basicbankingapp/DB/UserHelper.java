package com.example.basicbankingapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.basicbankingapp.DB.UserContract.UserEntry;
import com.example.basicbankingapp.Data.User;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(7860,'Deepak Pal', 'deeapk@gmail.com','9812','7895641238', 1200)");
        db.execSQL("insert into " + TABLE_NAME + " values(5862,'Ram Singth', 'ram@gmail.com','1698','8995641238', 7889)");
        db.execSQL("insert into " + TABLE_NAME + " values(7895,'Aman Kumar', 'aman@gmail.com','8896','7595645896', 1458)");
        db.execSQL("insert into " + TABLE_NAME + " values(1258,'Rohit kumar', 'rohit@gmail.com','2598','9995640038', 81255)");
        db.execSQL("insert into " + TABLE_NAME + " values(7410,'Shivangi Singh', 'shivangi@gmail.com','2569','9095648962', 2569)");
        db.execSQL("insert into " + TABLE_NAME + " values(8529,'Kmal kumar', 'kamal@gmail.com','9923','8855640238', 6525)");
        db.execSQL("insert into " + TABLE_NAME + " values(3698,'Raj Pandey', 'raj@gmail.com','9874','8895640215', 4548)");
        db.execSQL("insert into " + TABLE_NAME + " values(7853,'Aman Jain', 'aman@gmail.com','5896','9985021539', 25798)");
        db.execSQL("insert into " + TABLE_NAME + " values(4562,'Sanju Sharma', 'sanju@gmail.com','9878','9309565238', 1052569)");
        db.execSQL("insert into " + TABLE_NAME + " values(2365,'Rohit katiyar', 'rohit@gmail.com','2356','8292591201', 99259)");
        db.execSQL("insert into " + TABLE_NAME + " values(7854,'ram kumar pal', 'ramkumar@gmail.com','2656','9015641200', 98256)");
        db.execSQL("insert into " + TABLE_NAME + " values(3621,'Ramesh Kumar', 'ramesh@gmail.com','5897','9995641999', 11256)");
        db.execSQL("insert into " + TABLE_NAME + " values(1122,'Ashok maurya', 'ashok@gmail.com','2569','9119541001', 582589)");
        db.execSQL("insert into " + TABLE_NAME + " values(9512,'Shena Gaud', 'Shena@gmail.com','9892','6254642205', 35123)");
        db.execSQL("insert into " + TABLE_NAME + " values(7530,'Syam Kumar', 'syarmg@gmail.com','9652','6893641266', 1000)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}