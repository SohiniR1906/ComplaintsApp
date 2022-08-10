package com.example.complaintsapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.complaintsapp.Complaints.Complaindb;
import com.example.complaintsapp.Complaints.Complaint;
import com.example.complaintsapp.Complaints.ComplaintAdapter;

import java.util.ArrayList;

public class CmplaintStatusScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmplaint_status_screen);
        ListView complains = findViewById(R.id.complaint_status_list);
        Intent intent=getIntent();
        String email=intent.getStringExtra("Email");
        Complaindb db = new Complaindb(this);
        ArrayList<Complaint> list = db.query2(email);
        ComplaintAdapter adapter = new ComplaintAdapter(this, list);
        complains.setAdapter(adapter);
    }
}