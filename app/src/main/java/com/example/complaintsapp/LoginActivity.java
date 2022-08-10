package com.example.complaintsapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.complaintsapp.Data_employee.Empdb;

public class LoginActivity extends AppCompatActivity {
    EditText name;
    EditText email;
    EditText password;
    String emailstring;

    Button complaintbutton;
    Button view_complaint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Empdb db = new Empdb(this);
        name = findViewById(R.id.edit_text_name);
        email = findViewById(R.id.edit_text_email);
        password = findViewById(R.id.edit_text_password);
        complaintbutton = findViewById(R.id.button_login_complaint);
        view_complaint = findViewById(R.id.button_complaint_status);
        complaintbutton.setOnClickListener(view -> {
            String namestring = name.getText().toString();
            emailstring = email.getText().toString();
            String passwordstring = password.getText().toString();
            if (namestring.isEmpty() || emailstring.isEmpty() || passwordstring.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Please enter your name/email/password", Toast.LENGTH_SHORT).show();
            } else {
                String a = db.Query(namestring, emailstring, passwordstring);
                if (a == "-1") {
                    Toast.makeText(LoginActivity.this, "Please sign up", Toast.LENGTH_SHORT).show();
                } else {
                    Intent ComplaintActivityIntent = new Intent(LoginActivity.this, ComplaintActivity.class);
                    ComplaintActivityIntent.putExtra("Machine_no", a);
                    ComplaintActivityIntent.putExtra("Email", emailstring);
                    startActivity(ComplaintActivityIntent);
                }
            }
        });
        view_complaint.setOnClickListener(view -> {
            String namestring = name.getText().toString();
            emailstring = email.getText().toString();
            String passwordstring = password.getText().toString();
            if (namestring.isEmpty() || emailstring.isEmpty() || passwordstring.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Please enter your name/email/password", Toast.LENGTH_SHORT).show();
            } else {
                String a = db.Query(namestring, emailstring, passwordstring);
                if (a == "-1") {
                    Toast.makeText(LoginActivity.this, "Please sign up", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(LoginActivity.this, CmplaintStatusScreen.class);
                    intent.putExtra("Email", emailstring);
                    startActivity(intent);
                }
            }
        });

    }
}