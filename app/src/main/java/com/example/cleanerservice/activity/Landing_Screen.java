package com.example.cleanerservice.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cleanerservice.R;

public class Landing_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_screen);

        CardView priceBtn = (CardView) findViewById(R.id.priceCard);
        CardView aboutUs = (CardView) findViewById(R.id.aboutUs);

        priceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prices();
            }
        });

        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                about();
            }
        });

    }

    // Button Clickable functions.....
    public void prices(){
        Intent intent = new Intent(this, Prices.class);
        startActivity(intent);
    }

    public void about(){
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }
}