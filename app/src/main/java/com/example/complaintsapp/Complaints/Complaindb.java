package com.example.complaintsapp.Complaints;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class Complaindb extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "complaindb";

    public Complaindb(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Creating the database table
     */

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_USERSTABLE = " CREATE TABLE " + ComplainContract.ComplainEntry.TABLE_NAME + "("
                + ComplainContract.ComplainEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ComplainContract.ComplainEntry.COLUMN_TYPE + " TEXT NOT NULL, "
                + ComplainContract.ComplainEntry.COLUMN_MACHINE + " TEXT, "
                + ComplainContract.ComplainEntry.COLUMN_DESCRIPTION + " TEXT, "
                + ComplainContract.ComplainEntry.COLUMN_EMAIL + " TEXT, "
                + ComplainContract.ComplainEntry.COLUMN_STATUS + " TEXT );";
        db.execSQL(CREATE_USERSTABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
     * Adding new employees to database
     */
    public boolean addComplain(Complaint complain) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ComplainContract.ComplainEntry.COLUMN_TYPE, complain.getType());
        values.put(ComplainContract.ComplainEntry.COLUMN_MACHINE, complain.getMachine());
        values.put(ComplainContract.ComplainEntry.COLUMN_DESCRIPTION, complain.getDescription());
        values.put(ComplainContract.ComplainEntry.COLUMN_EMAIL, complain.getemail());
        values.put(ComplainContract.ComplainEntry.COLUMN_STATUS, complain.getStatus());

        // Inserting Row
        long result = db.insert(ComplainContract.ComplainEntry.TABLE_NAME, null, values);
        if (result == -1)
            return false;
        else
            return true;
    }

    /**
     * Query to database
     */

    public ArrayList<Complaint> query() {
        ArrayList<Complaint> complain = new ArrayList<Complaint>();
        String selectQuery = "SELECT  * FROM " + ComplainContract.ComplainEntry.TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                int column_id=cursor.getColumnIndex(ComplainContract.ComplainEntry._ID);
                String id=cursor.getString(column_id);
                int column_type=cursor.getColumnIndex(ComplainContract.ComplainEntry.COLUMN_TYPE);
                String type=cursor.getString(column_type);
                int column_machine=cursor.getColumnIndex(ComplainContract.ComplainEntry.COLUMN_MACHINE);
                String machine=cursor.getString(column_machine);
                int column_description=cursor.getColumnIndex(ComplainContract.ComplainEntry.COLUMN_DESCRIPTION);
                String description=cursor.getString(column_description);
                int column_email=cursor.getColumnIndex(ComplainContract.ComplainEntry.COLUMN_EMAIL);
                String email=cursor.getString(column_email);
                int column_status=cursor.getColumnIndex(ComplainContract.ComplainEntry.COLUMN_STATUS);
                String status=cursor.getString(column_status);
                Complaint complaint = new Complaint(id,type,machine,description,email,status);

                complain.add(complaint);
            } while (cursor.moveToNext());
        }

        return complain;
    }
    public ArrayList<Complaint> query2(String email1) {
        ArrayList<Complaint> complain = new ArrayList<Complaint>();
        String selectQuery = "SELECT  * FROM " + ComplainContract.ComplainEntry.TABLE_NAME+
                " WHERE "+ComplainContract.ComplainEntry.COLUMN_EMAIL+" = '"+email1+"'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                int column_id=cursor.getColumnIndex(ComplainContract.ComplainEntry._ID);
                String id=cursor.getString(column_id);
                int column_type=cursor.getColumnIndex(ComplainContract.ComplainEntry.COLUMN_TYPE);
                String type=cursor.getString(column_type);
                int column_machine=cursor.getColumnIndex(ComplainContract.ComplainEntry.COLUMN_MACHINE);
                String machine=cursor.getString(column_machine);
                int column_description=cursor.getColumnIndex(ComplainContract.ComplainEntry.COLUMN_DESCRIPTION);
                String description=cursor.getString(column_description);
                int column_email=cursor.getColumnIndex(ComplainContract.ComplainEntry.COLUMN_EMAIL);
                String email=cursor.getString(column_email);
                int column_status=cursor.getColumnIndex(ComplainContract.ComplainEntry.COLUMN_STATUS);
                String status=cursor.getString(column_status);
                Complaint complaint = new Complaint(id,type,machine,description,email,status);

                complain.add(complaint);
            } while (cursor.moveToNext());
        }

        return complain;
    }
    /**
     * Query to update status
     */
    public void update(String s, int i) {
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL("UPDATE "+ComplainContract.ComplainEntry.TABLE_NAME+" SET "+
                ComplainContract.ComplainEntry.COLUMN_STATUS+" = '"+s+"' "+ "WHERE "
                +ComplainContract.ComplainEntry._ID+" = "+ String.valueOf(i));
    }
}


