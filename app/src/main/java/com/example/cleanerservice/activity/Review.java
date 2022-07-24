package com.example.cleanerservice.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cleanerservice.DBHandler.DBHandler;
import com.example.cleanerservice.R;
import com.example.cleanerservice.model.Reviews;

public class Review extends AppCompatActivity {

    EditText id, name, message, createAt;
    Button save;
    DBHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        db = new DBHandler(this);

        id = findViewById(R.id.reviewId);
        name = findViewById(R.id.reviewName);
        message = findViewById(R.id.reviewMsg);
        createAt = findViewById(R.id.reviewcrt);
        save = findViewById(R.id.savervw);

        id.setText("1");
        name.setText("M Malsha");
        message.setText("“Got a lot done in short amount of time. House looks and smells great!”");
        createAt.setText("2022/07/21");

         save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Reviews reviews = new Reviews();
                String Id = id.getText().toString();
                String Name = name.getText().toString();
                String Message = message.getText().toString();
                String CreateAt = createAt.getText().toString();

                try{
                    if(TextUtils.isEmpty(Id) || TextUtils.isEmpty(Name) || TextUtils.isEmpty(Message) || TextUtils.isEmpty(CreateAt))
                        Toast.makeText(Review.this, "All Fields Required!!!", Toast.LENGTH_SHORT).show();
                    else {
                        reviews.setId(Integer.parseInt(Id));
                        reviews.setName(Name);
                        reviews.setMessage(Message);
                        reviews.setCreateAt(CreateAt);
                        if (db.insert_review(reviews) > 0) {
                            clear();
                            Toast.makeText(Review.this, "Review Inserted!", Toast.LENGTH_SHORT).show();

                        }
                    }
                }catch (Exception e){
                    Log.e("Error", e.getMessage());
                    Toast.makeText(Review.this, "Cannot Insert", Toast.LENGTH_SHORT).show();
                    clear();
                }
            }
        });

    }


    public void clear(){
        id.setText("");
        name.setText("");
        message.setText("");
        createAt.setText("");
    }
}