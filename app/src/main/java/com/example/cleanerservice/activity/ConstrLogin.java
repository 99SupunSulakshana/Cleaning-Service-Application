package com.example.cleanerservice.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cleanerservice.DBHandler.DBHandler;
import com.example.cleanerservice.R;

public class ConstrLogin extends AppCompatActivity {

    EditText username,password;
    DBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constr_login);
        db = new DBHandler(this);

        Button login = (Button) findViewById(R.id.loginBtnCon);
        Button register = (Button) findViewById(R.id.registerBtn);
        username = findViewById(R.id.emailCon);
        password = findViewById(R.id.passwordCon);

        username.setText("kmendis@gmail.com");
        password.setText("123P");


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass))
                    Toast.makeText(ConstrLogin.this, "All Fields Required!!!", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuser = db.checkcredits(user,pass);
                    if (checkuser==true){
                        Toast.makeText(ConstrLogin.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                        login();
                    }else{
                        Toast.makeText(ConstrLogin.this, "Login Failed", Toast.LENGTH_SHORT).show();
                        clean();
                    }
                }

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }

    public void clean(){
        username.setText("");
        password.setText("");
    }

    public void login(){
        Intent intent = new Intent(this, CleanerLanding.class);
        startActivity(intent);
    }

    public void register(){
        Intent intent = new Intent(this, SignUpHome.class);
        startActivity(intent);
    }
}