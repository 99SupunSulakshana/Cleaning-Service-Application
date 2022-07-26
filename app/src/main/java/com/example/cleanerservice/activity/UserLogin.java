package com.example.cleanerservice.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cleanerservice.DBHandler.DBHandler;
import com.example.cleanerservice.R;
import com.example.cleanerservice.sharedpreference.SessionManager;

public class UserLogin extends AppCompatActivity {
    DBHandler db;
    Cursor cursor;
    EditText email, password;
    private SessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        db = new DBHandler(this);
        session = new SessionManager(getApplicationContext());
//        if (session.isLoggedIn()){
//            Intent intent = new Intent(UserLogin.this, Landing_Screen.class);
//            startActivity(intent);
//        }
        session = new SessionManager(getApplicationContext());

        Button login = (Button) findViewById(R.id.loginBtn);
        Button register = (Button) findViewById(R.id.registerBtn);

        email = findViewById(R.id.useremail);
        password = findViewById(R.id.userpassword);

        email.setText("mm@gmail.com");
        password.setText("123m");


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = email.getText().toString();
                String pswrd = password.getText().toString();

                if(TextUtils.isEmpty(username) || TextUtils.isEmpty(pswrd))
                    Toast.makeText(UserLogin.this, "All Fields Required!!!", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = db.checkusernamepassword(username,pswrd);
                    if (checkuserpass==true){
                        Toast.makeText(UserLogin.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                        login();
                    }else{
                        Toast.makeText(UserLogin.this, "Login Failed", Toast.LENGTH_SHORT).show();
                        clean();
                    }
                }

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regsitration();
            }
        });
    }

    public void clean(){
        email.setText("");
        password.setText("");
    }
    public void login(){
        Intent intent = new Intent(this, Landing_Screen.class);
        startActivity(intent);
        session.setLogin(true);
        finish();
    }
    public void regsitration(){
        Intent intent = new Intent(this, SignUpHome.class);
        startActivity(intent);
    }
}