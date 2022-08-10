package com.example.complaintsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.complaintsapp.Complaints.Complaindb;
import com.example.complaintsapp.Complaints.Complaint;

public class ComplaintActivity extends AppCompatActivity {

    RadioButton hardwarebutton;
    RadioButton softwarebutton;
    EditText complaintDescription;
    Button doneButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);
       Complaindb db = new Complaindb(this);
        Intent intent=getIntent();
        String email=intent.getStringExtra("Email");
        String machine=intent.getStringExtra("Machine_no");
        hardwarebutton=findViewById(R.id.button_hardware);
        softwarebutton=findViewById(R.id.button_software);
        complaintDescription=findViewById(R.id.edit_text_complaintDescription);
        doneButton=findViewById(R.id.button_done);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        String answer;
        String answer1=complaintDescription.getText().toString();
        if(hardwarebutton.isChecked()){
            answer="Hardware";

        } else if(softwarebutton.isChecked()){
            answer="Software";

        } else{
            answer="Others";
        }
        String status="PENDING";
                Complaint complain=new Complaint(answer,machine,answer1,email,status);
                db.addComplain(complain);
                Intent CompletedActivityIntent=  new Intent(ComplaintActivity.this,CompletedActivity.class);
                startActivity(CompletedActivityIntent);
            }
        });




    }
}