package com.example.cleanerservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

import com.example.cleanerservice.activity.ConstrLogin;
import com.example.cleanerservice.activity.UserLogin;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setIcon(R.drawable.ic_baseline_logout_24);


        Button btn = (Button) findViewById(R.id.homeBtn);
        Button login = (Button) findViewById(R.id.constBtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegistration();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();
            }
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.main_menu, menu);
//        return true;
//    }

    public void openRegistration(){
        Intent intent = new Intent(this, UserLogin.class);
        startActivity(intent);
    }
    public void openLogin(){
        Intent intent = new Intent(this, ConstrLogin.class);
        startActivity(intent);
    }
}