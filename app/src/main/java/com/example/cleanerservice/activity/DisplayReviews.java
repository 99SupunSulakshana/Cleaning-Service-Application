package com.example.cleanerservice.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.cleanerservice.DBHandler.DBHandler;
import com.example.cleanerservice.R;
import com.example.cleanerservice.adpters.ReviewAdapter;
import com.example.cleanerservice.model.Reviews;

import java.util.ArrayList;

public class DisplayReviews extends AppCompatActivity {
    ArrayList<Reviews> reviews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_reviews);

        ListView rListView = (ListView) findViewById(R.id.reviewListView);
        DBHandler db = new DBHandler(this);

        try{
            reviews = db.viewAllreviews();
            if(reviews.size() >0){
                ReviewAdapter reviewAdapter = new ReviewAdapter(this, reviews);
                rListView.setAdapter(reviewAdapter);
            }else{
                Toast.makeText(this, "No Reviews available", Toast.LENGTH_SHORT).show();
            }

        }catch(Exception e){
            Log.e("Error :", e.getMessage());
        }
    }
}