package com.example.complaintsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.complaintsapp.Data_employee.Empdb;
import com.example.complaintsapp.Data_employee.Employee;

public class SignupActivity extends AppCompatActivity {

    EditText nameNew;
    EditText emailNew;
    EditText machineNo;
    EditText passwordNew;
    Button signUpComplaintButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Empdb db = new Empdb(this);
        nameNew=findViewById(R.id.edit_text_nameSignup);
        emailNew=findViewById(R.id.edit_text_emailSignup);
        machineNo=findViewById(R.id.edit_text_machineNo);
        passwordNew=findViewById(R.id.edit_text_passwordSignup);
        signUpComplaintButton=findViewById(R.id.button_signUp_complaint);

        signUpComplaintButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameNewString= nameNew.getText().toString();
                String emailNewString= emailNew.getText().toString();
                String machineNoString= machineNo.getText().toString();
                String passwordNewString= passwordNew.getText().toString();
                if(nameNewString.isEmpty() || emailNewString.isEmpty() || machineNoString.isEmpty() || passwordNewString.isEmpty()){
                    Toast.makeText(SignupActivity.this, "Please enter all the required details!",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(SignupActivity.this, "YOU HAVE BEEN REGISTERED!",Toast.LENGTH_SHORT).show();
                    Employee emp=new Employee(nameNewString,emailNewString,machineNoString,passwordNewString);
                    boolean res=db.addEmp(emp);
                    if(res==true) {
                        Intent ComplaintActivityIntent = new Intent(SignupActivity.this, ComplaintActivity.class);
                        ComplaintActivityIntent.putExtra("Email",emailNewString);
                        ComplaintActivityIntent.putExtra("Machine_no", machineNoString);
                        startActivity(ComplaintActivityIntent);
                    }
                    else
                        Toast.makeText(SignupActivity.this, "Signup Failed. Try Again",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}