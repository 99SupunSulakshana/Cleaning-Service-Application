package com.example.cleanerservice.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.cleanerservice.DBHandler.DBHandler;
import com.example.cleanerservice.R;
import com.example.cleanerservice.adpters.AdvertisemntAdapter;
import com.example.cleanerservice.model.Advertisement;

import java.util.ArrayList;


public class AdvertisementDisplay extends AppCompatActivity {

    ArrayList<Advertisement> advertisements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertisement_display);

        ListView addlist = (ListView) findViewById(R.id.addListView);
        DBHandler db = new DBHandler(this);
        try{
            advertisements = db.viewAllAdds();
            if(advertisements.size() >0) {
                AdvertisemntAdapter advertisemntAdapter = new AdvertisemntAdapter(this, advertisements);
                addlist.setAdapter(advertisemntAdapter);
            }else{
                Toast.makeText(this, "No Adds Here...", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            Log.e("Error :", e.getMessage());
        }

    }
}