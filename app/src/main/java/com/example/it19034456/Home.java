package com.example.it19034456;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Home extends AppCompatActivity {
    EditText username,password;
    Button login,register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        username=findViewById(R.id.unh);
        password=findViewById(R.id.ph);
        login=findViewById(R.id.b1h);
        register=findViewById(R.id.b2h);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(getApplicationContext(),ProfileManagement.class);
                startActivity(a);
            }
        });

    }
}