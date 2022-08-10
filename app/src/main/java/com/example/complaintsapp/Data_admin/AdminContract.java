package com.example.complaintsapp.Data_admin;

import android.provider.BaseColumns;

public final class AdminContract {

    private AdminContract(){};
    public final static class AdminEntry implements BaseColumns{
        public final static String TABLE_NAME="Admin";
        public final static String _ID=BaseColumns._ID;
        public final static String COLUMN_NAME="Name";
        public final static String COLUMN_EMAIL="Email";
        public final static String COLUMN_PASSWORD="Password";


    }
}
