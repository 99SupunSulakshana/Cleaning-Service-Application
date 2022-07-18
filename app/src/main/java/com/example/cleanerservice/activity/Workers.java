package com.example.cleanerservice.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.cleanerservice.DBHandler.DBHandler;
import com.example.cleanerservice.R;
import com.example.cleanerservice.adpters.CleanerAdapter;
import com.example.cleanerservice.model.Constructor;

import java.util.ArrayList;
import java.util.List;

public class Workers extends AppCompatActivity {

    ArrayList<Constructor> constructors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workers);

        ListView workList = (ListView) findViewById(R.id.workersListView);
        DBHandler db = new DBHandler(this);
        try{
            constructors = db.viewAllCleaners();
            if (constructors.size() >0){
                CleanerAdapter cleanerAdapter = new CleanerAdapter(this, constructors);
                workList.setAdapter(cleanerAdapter);
            }else{
                Toast.makeText(this, "No Cleaners", Toast.LENGTH_SHORT).show();
            }

        }catch (Exception e){
            Log.e("Error :", e.getMessage());
        }
    }
}