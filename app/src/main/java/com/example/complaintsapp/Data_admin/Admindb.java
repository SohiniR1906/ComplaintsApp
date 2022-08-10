package com.example.complaintsapp.Data_admin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Admindb extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Admindb";

    public Admindb(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Creating the database table
     */

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_USERSTABLE= " CREATE TABLE "+ AdminContract.AdminEntry.TABLE_NAME +"("
                + AdminContract.AdminEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + AdminContract.AdminEntry.COLUMN_NAME+ " TEXT NOT NULL, "
                + AdminContract.AdminEntry.COLUMN_EMAIL + " TEXT, "
                + AdminContract.AdminEntry.COLUMN_PASSWORD +" TEXT );";
        db.execSQL(CREATE_USERSTABLE);
        InsertUserData(db,"Sohini Rudra", "sohinirudra19@gmail.com",  "7044167521");
        InsertUserData(db,"aa", "aa",  "123");
    }

    /**
     * Inserting values inside the database table
     */

    private void InsertUserData(SQLiteDatabase db,String name,String email,String password)
    {

        ContentValues values=new ContentValues();
        values.put(AdminContract.AdminEntry.COLUMN_NAME,name);
        values.put(AdminContract.AdminEntry.COLUMN_EMAIL,email);
        values.put(AdminContract.AdminEntry.COLUMN_PASSWORD ,password);
        db.insert(AdminContract.AdminEntry.TABLE_NAME,null,values);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
     * Query to database
     */

    public int Query(String name, String email, String password) {
        SQLiteDatabase db=this.getReadableDatabase();
        String Query = "SELECT * FROM " + AdminContract.AdminEntry.TABLE_NAME + " WHERE " + AdminContract.AdminEntry.COLUMN_NAME  + " = '" + name+ "' AND " + AdminContract.AdminEntry.COLUMN_EMAIL +" = '"+email+"' AND " + AdminContract.AdminEntry.COLUMN_PASSWORD +" = '"+password+"'";
        Cursor cursor = db.rawQuery(Query, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return -1;
        }
       else
           return 1;
    }


}