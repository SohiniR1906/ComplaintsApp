package com.example.complaintsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.complaintsapp.Data_admin.Admindb;

public class AdminActivity extends AppCompatActivity {

    EditText name;
    EditText email;
    EditText password;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        Admindb db = new Admindb(this);
        name=findViewById(R.id.edit_text_nameAdmin);
        email=findViewById(R.id.edit_text_emailAdmin);
        password=findViewById(R.id.edit_text_passwordAdmin);
       button=findViewById(R.id.button_login_admin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namestring=name.getText().toString();
                String emailstring=email.getText().toString();
                String passwordstring=password.getText().toString();
                if(namestring.isEmpty() || emailstring.isEmpty() || passwordstring.isEmpty()){
                    Toast.makeText(AdminActivity.this,"Please enter your name/email/password",Toast.LENGTH_SHORT).show();
                } else{
                    int a=db.Query(namestring,emailstring,passwordstring);
                    if(a==-1){
                        Toast.makeText(AdminActivity.this,"Wrong details",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Intent ComplaintActivityIntent = new Intent(AdminActivity.this, Complaint_list.class);
                        startActivity(ComplaintActivityIntent);
                    }
                }
            }
        });
    }
}