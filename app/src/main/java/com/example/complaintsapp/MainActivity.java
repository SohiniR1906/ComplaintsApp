package com.example.complaintsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button complaintbutton;
    Button signupButton;
    Button adminButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        complaintbutton=findViewById(R.id.button_complaint);
        signupButton=findViewById(R.id.button_signup);
        adminButton=findViewById(R.id.button_admin);
        complaintbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginActivityIntent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(loginActivityIntent);

            }
        });

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signupActivityIntent = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(signupActivityIntent);
            }
        });

        adminButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent adminActivityIntent = new Intent(MainActivity.this, AdminActivity.class);
                startActivity(adminActivityIntent);
            }
        });

    }
}