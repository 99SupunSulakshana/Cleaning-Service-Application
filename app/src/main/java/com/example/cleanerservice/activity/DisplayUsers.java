package com.example.cleanerservice.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cleanerservice.DBHandler.DBHandler;
import com.example.cleanerservice.R;
import com.example.cleanerservice.adpters.UserAdapter;
import com.example.cleanerservice.model.User;

import java.util.ArrayList;

public class DisplayUsers extends AppCompatActivity {

    ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_users);

        ListView userList = (ListView) findViewById(R.id.userListView);
        DBHandler db = new DBHandler(this);

        try{
            users = db.viewAllUsers();
            if(users.size()>0) {
                UserAdapter userAdapter = new UserAdapter(this, users);
                userList.setAdapter(userAdapter);
            }else{
                Toast.makeText(this, "No users available", Toast.LENGTH_SHORT).show();
            }

        }catch (Exception e){

        }
    }
}