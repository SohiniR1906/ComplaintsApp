package com.example.complaintsapp.Complaints;

import android.provider.BaseColumns;

public final class ComplainContract {

    private ComplainContract(){};
    public final static class ComplainEntry implements BaseColumns{
        public final static String TABLE_NAME="Complaint";
        public final static String _ID=BaseColumns._ID;
        public final static String COLUMN_TYPE="Type";
        public final static String COLUMN_MACHINE="Machine";
        public final static String COLUMN_DESCRIPTION="Description";
        public final static String COLUMN_EMAIL="Email";
        public final static String COLUMN_STATUS="Status";


    }
}
