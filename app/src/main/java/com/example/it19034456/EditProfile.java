package com.example.it19034456;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.List;

import Database.DBHelper;

public class EditProfile extends AppCompatActivity {
    EditText username,dob,password;
    Button search,edit,delete;
    RadioButton male,female;
    String gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        username=findViewById(R.id.une);
        password=findViewById(R.id.pe);
        dob=findViewById(R.id.de);
        search=findViewById(R.id.b1e);
        edit=findViewById(R.id.b2e);
        delete=findViewById(R.id.b3e);
        male=findViewById(R.id.rb1e);
        female=findViewById(R.id.rb2e);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbHelper = new DBHelper(getApplicationContext());
                List user=  dbHelper.readallinfo(username.getText().toString());
                if(user.isEmpty()){
                    Toast.makeText(EditProfile.this,"no user", Toast.LENGTH_SHORT).show();
                    username.setText(null);

                }
                else
                {
                    Toast.makeText(EditProfile.this,"user found"+user.get(0).toString(), Toast.LENGTH_SHORT).show();
                    username.setText(user.get(0).toString());
                    dob.setText(user.get(1).toString());
                    password.setText(user.get(2).toString());
                    if(user.get(3).toString().equals("male")){
                        male.setChecked(true);
                    }else
                        female.setChecked(true);
                }
            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbHelper = new DBHelper(getApplicationContext());
                if(male.isChecked()){
                    gender  ="male";
                }
                else
                    gender = "female";
                Boolean status=dbHelper.updateInfor(username.getText().toString(),password.getText().toString(),dob.getText().toString(),gender);
                if(status){
                    Toast.makeText(EditProfile.this,"user ubdate", Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(EditProfile.this,"update filad", Toast.LENGTH_SHORT).show();
            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbHelper = new DBHelper(getApplicationContext());
                dbHelper.deleteinfo(username.getText().toString());
                Toast.makeText(EditProfile.this, "user delete", Toast.LENGTH_SHORT).show();
            }
        });
    }

}