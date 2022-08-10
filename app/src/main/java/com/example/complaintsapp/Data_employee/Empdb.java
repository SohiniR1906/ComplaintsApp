package com.example.complaintsapp.Data_employee;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Empdb extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Employeedb";

    public Empdb(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Creating the database table
     */

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_USERSTABLE= " CREATE TABLE "+ EmpContract.EmpEntry.TABLE_NAME +"("
                + EmpContract.EmpEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + EmpContract.EmpEntry.COLUMN_NAME+ " TEXT NOT NULL, "
                + EmpContract.EmpEntry.COLUMN_EMAIL + " TEXT, "
                + EmpContract.EmpEntry.COLUMN_MACHINE + " TEXT, "
                + EmpContract.EmpEntry.COLUMN_PASSWORD +" TEXT );";
        db.execSQL(CREATE_USERSTABLE);
        InsertUserData(db,"Sohini Rudra", "sr19@gmail.com", "1", "helloworld");
        InsertUserData(db,"A", "A", "2", "1");
    }

    /**
     * Inserting values inside the database table
     */

    private void InsertUserData(SQLiteDatabase db,String name,String email,String machine_no ,String password)
    {

        ContentValues values=new ContentValues();
        values.put(EmpContract.EmpEntry.COLUMN_NAME,name);
        values.put(EmpContract.EmpEntry.COLUMN_EMAIL,email);
        values.put(EmpContract.EmpEntry.COLUMN_MACHINE ,machine_no);
        values.put(EmpContract.EmpEntry.COLUMN_PASSWORD ,password);
        db.insert(EmpContract.EmpEntry.TABLE_NAME,null,values);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
     *
     * Adding new employees to database
     */
    public boolean addEmp(Employee emp) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(EmpContract.EmpEntry.COLUMN_NAME,emp.getName());
        values.put(EmpContract.EmpEntry.COLUMN_EMAIL ,emp.getEmail());
        values.put(EmpContract.EmpEntry.COLUMN_MACHINE,emp.getMachine());
        values.put(EmpContract.EmpEntry.COLUMN_PASSWORD ,emp.getPassword());

        // Inserting Row
        long result=db.insert(EmpContract.EmpEntry.TABLE_NAME, null, values);
        if(result==-1)
            return false;
        else
            return true;
    }

    /**
     * Query to database
     */

    public String Query(String name, String email, String password) {
        SQLiteDatabase db=this.getReadableDatabase();
        String Query = "SELECT * FROM " + EmpContract.EmpEntry.TABLE_NAME + " WHERE " + EmpContract.EmpEntry.COLUMN_NAME  + " = '" + name+ "' AND " + EmpContract.EmpEntry.COLUMN_EMAIL +" = '"+email+"' AND " + EmpContract.EmpEntry.COLUMN_PASSWORD +" = '"+password+"'";
        Cursor cursor = db.rawQuery(Query, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return "-1";
        }
        String ans = null;
        if(cursor.moveToFirst())
        {
            int column=cursor.getColumnIndex(EmpContract.EmpEntry.COLUMN_MACHINE);
            ans=cursor.getString(column);
        }
        cursor.close();
        if(ans==null)
            ans="-1";
        return ans;
    }


}