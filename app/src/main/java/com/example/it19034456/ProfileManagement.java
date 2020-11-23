package com.example.it19034456;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import Database.DBHelper;

import static java.security.AccessController.getContext;

public class ProfileManagement extends AppCompatActivity {
    EditText username,dob,password;
    Button updateprofile,add;
    RadioButton male,female;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_management);

        username=findViewById(R.id.unp);
        dob=findViewById(R.id.dp);
        password=findViewById(R.id.pp);
        updateprofile=findViewById(R.id.bp);
        add=findViewById(R.id.addp);
        male=findViewById(R.id.rb1p);
        female=findViewById(R.id.rb2p);

        updateprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent x = new Intent(getApplicationContext(),EditProfile.class);
                startActivity(x);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(male.isChecked()){
                    gender  ="male";
                }
                else
                    gender = "female";
                DBHelper dbHelper = new DBHelper(getApplicationContext());
                long newID=dbHelper.addinfo(username.getText().toString(),password.getText().toString(),dob.getText().toString(),gender);
                Toast.makeText(ProfileManagement.this,"add user"+newID, Toast.LENGTH_SHORT).show();

                Intent a = new Intent(getApplicationContext(),EditProfile.class);
                startActivity(a);
            }
        });
    }
}