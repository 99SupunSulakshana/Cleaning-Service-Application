package com.example.cleanerservice.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cleanerservice.R;

public class CleanerLanding extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cleaner_landing);

        CardView jobCard = (CardView) findViewById(R.id.jobCardC);
        CardView cleanersCard = (CardView) findViewById(R.id.cleanersCard);
        CardView profileCard = (CardView) findViewById(R.id.cleanerProfilecard);
        CardView appUsersCard = (CardView) findViewById(R.id.cleanerAllUsers);
        CardView reviewCard = (CardView) findViewById(R.id.cleanerReviews);
        CardView allReviewCard = (CardView) findViewById(R.id.cleanerReviewsAll);
        CardView aboutusCard = (CardView) findViewById(R.id.cleanerAboutUs);
        CardView servicesCard = (CardView) findViewById(R.id.cleanerServices);
        Button logout = (Button) findViewById(R.id.logoutBtnC);

        jobCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jobCard();
            }
        });

        cleanersCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allcleanersCard();
            }
        });

        profileCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profileCard();
            }
        });

        appUsersCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignedUsersCard();
            }
        });

        reviewCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reviewsCard();
            }
        });

        allReviewCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allreviewCard();
            }
        });

        aboutusCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aboutCard();
            }
        });

        servicesCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                serviceCard();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutCard();
            }
        });

    }

    public void jobCard(){
        Intent intent = new Intent(this, AdvertisementDisplay.class);
        startActivity(intent);
    }

    public void allcleanersCard(){
        Intent intent = new Intent(this, Workers.class);
        startActivity(intent);
    }

    public void profileCard(){
        Intent intent = new Intent(this, CleanerProfile.class);
        startActivity(intent);
    }

    public void SignedUsersCard(){
        Intent intent = new Intent(this, DisplayUsers.class);
        startActivity(intent);
    }

    public void reviewsCard(){
        Intent intent = new Intent(this, Review.class);
        startActivity(intent);
    }

    public void allreviewCard(){
        Intent intent = new Intent(this, DisplayReviews.class);
        startActivity(intent);
    }

    public void aboutCard(){
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }

    public void serviceCard(){
        Intent intent = new Intent(this, Prices.class);
        startActivity(intent);
    }

    public void logoutCard(){
        Intent intent = new Intent(this, ConstrLogin.class);
        startActivity(intent);
        finish();
    }


}