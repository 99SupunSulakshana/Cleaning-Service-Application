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

        CardView sell = (CardView) findViewById(R.id.sellCard);
        CardView viewsells = (CardView) findViewById(R.id.viewAdds);
        CardView priceBtn = (CardView) findViewById(R.id.priceCard);
        CardView reviewcard = (CardView) findViewById(R.id.reviewsCard);
        CardView allreviewcard = (CardView) findViewById(R.id.allreviews);
        CardView aboutUs = (CardView) findViewById(R.id.aboutUs);
        CardView userList = (CardView) findViewById(R.id.allUsersCard);
        CardView cleanList = (CardView) findViewById(R.id.cleanerList);
        CardView profile = (CardView) findViewById(R.id.myProfile);
        Button logout = (Button) findViewById(R.id.logoutBtnA);

        sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sell();
            }
        });

        viewsells.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allAdds();
            }
        });

        priceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prices();
            }
        });

        reviewcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reviewsCreate();
            }
        });

        allreviewcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewreview();
            }
        });

        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                about();
            }
        });

        userList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Users();
            }
        });

        cleanList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleaner();
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profile();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
    }

    // Button Clickable functions.....
    public void prices(){
        Intent intent = new Intent(this, Prices.class);
        startActivity(intent);
    }

    public void sell(){
        Intent intent = new Intent(this, createAdd.class);
        startActivity(intent);
    }

    public void about(){
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }

    public void Users(){
        Intent intent = new Intent(this, DisplayUsers.class);
        startActivity(intent);
    }

    public void cleaner(){
        Intent intent = new Intent(this, Workers.class);
        startActivity(intent);
    }

    public void allAdds(){
        Intent intent = new Intent(this, AdvertisementDisplay.class);
        startActivity(intent);
    }

    public void reviewsCreate(){
        Intent intent = new Intent(this, Review.class);
        startActivity(intent);
    }

    public void viewreview(){
        Intent intent = new Intent(this, DisplayReviews.class);
        startActivity(intent);
    }

    public void profile(){
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }

    public void logout(){
        Intent intent = new Intent(this, UserLogin.class);
        startActivity(intent);
        this.finish();
        System.exit(0);
    }
}