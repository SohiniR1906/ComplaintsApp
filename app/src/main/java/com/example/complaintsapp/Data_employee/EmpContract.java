package com.example.complaintsapp.Data_employee;

import android.provider.BaseColumns;

public final class EmpContract {

    private EmpContract(){};
    public final static class EmpEntry implements BaseColumns{
        public final static String TABLE_NAME="Employees";
        public final static String _ID=BaseColumns._ID;
        public final static String COLUMN_NAME="Name";
        public final static String COLUMN_EMAIL="Email";
        public final static String COLUMN_MACHINE="Machine";
        public final static String COLUMN_PASSWORD="Password";


    }
}
