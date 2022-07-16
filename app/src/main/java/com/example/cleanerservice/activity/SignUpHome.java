package com.example.cleanerservice.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cleanerservice.R;

public class SignUpHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_home);

        Button home  = (Button) findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHouseOwner();
            }
        });

        Button constructor = (Button) findViewById(R.id.constBtn);
        constructor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openConstructor();
            }
        });
    }

    public void openHouseOwner(){
        Intent intent = new Intent(this, Registration.class);
        startActivity(intent);
    }

    public void openConstructor(){
        Intent intent = new Intent(this, Registration2.class);
        startActivity(intent);
    }
}