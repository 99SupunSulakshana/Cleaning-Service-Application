package com.example.cleanerservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

import com.example.cleanerservice.activity.Landing_Screen;
import com.example.cleanerservice.activity.Registration;
import com.example.cleanerservice.activity.SignUpHome;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setIcon(R.drawable.ic_baseline_logout_24);


        Button btn = (Button) findViewById(R.id.registerBtn);
        Button login = (Button) findViewById(R.id.loginBtn);

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
        Intent intent = new Intent(this, SignUpHome.class);
        startActivity(intent);
    }
    public void openLogin(){
        Intent intent = new Intent(this, Landing_Screen.class);
        startActivity(intent);
    }
}