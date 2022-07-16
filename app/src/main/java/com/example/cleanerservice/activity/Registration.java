package com.example.cleanerservice.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.cleanerservice.DBHandler.DBHandler;
import com.example.cleanerservice.R;
import com.example.cleanerservice.model.User;

public class Registration extends AppCompatActivity {

    DBHandler db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        EditText id = (EditText) findViewById(R.id.custId);
        EditText fullname = (EditText) findViewById(R.id.custFullName);
        EditText email = (EditText) findViewById(R.id.custEmail);
        EditText phone = (EditText) findViewById(R.id.custPhone);
        EditText address = (EditText) findViewById(R.id.custAddress);
        EditText postalcode = (EditText) findViewById(R.id.custPostalCode);
        EditText hometwon = (EditText) findViewById(R.id.custHTown);
        EditText password = (EditText) findViewById(R.id.custPassword);
        Spinner charctor = (Spinner) findViewById(R.id.custspinner);
        Button save = (Button) findViewById(R.id.saveCust);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.charactors, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        charctor.setAdapter(adapter);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                try{
                    user.setId(Integer.parseInt(id.getText().toString()));
                   user.setFullName(fullname.getText().toString());
                   user.setEmail(email.getText().toString());
                   user.setPhoneNumber(Integer.parseInt(phone.getText().toString()));
                   user.setAddress(address.getText().toString());
                   user.setPostalCode(postalcode.getText().toString());
                   user.setHomeTown(hometwon.getText().toString());
                   user.setPassword(password.getText().toString());
                   if(db.insert_user(user) > 0){
                       Toast.makeText(Registration.this, "User Added Successfully", Toast.LENGTH_SHORT).show();
                   }
                }catch (Exception e){
                    Log.e("Error", e.getMessage());
                    Toast.makeText(Registration.this, "Please Try Again..", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}