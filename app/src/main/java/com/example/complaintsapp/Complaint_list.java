package com.example.complaintsapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.complaintsapp.Complaints.Complaindb;
import com.example.complaintsapp.Complaints.Complaint;
import com.example.complaintsapp.Complaints.ComplaintAdapter;

import java.util.ArrayList;

public class Complaint_list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_list);
        ListView complains=findViewById(R.id.complaint_list);
        Complaindb db = new Complaindb(this);
        ArrayList<Complaint> list=db.query();
        ComplaintAdapter adapter=new ComplaintAdapter(this,list);
       complains.setAdapter(adapter);

       complains.setOnItemClickListener((adapterView, view, i, l) -> {
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setTitle("Is the complaint resolved?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                             db.update("COMPLETED",i+1);
                             finish();
                        }
                    })
                    .setNegativeButton("No", null);
            AlertDialog exit=builder.create();
            exit.show();
        });
    }
}