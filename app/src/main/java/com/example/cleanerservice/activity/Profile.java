package com.example.cleanerservice.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.cleanerservice.R;

public class Profile extends AppCompatActivity {


    EditText id, fullname, email, phone, address, postalcode, hometwon, password;
    Spinner charctor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        id = (EditText) findViewById(R.id.custIdA);
        fullname = (EditText) findViewById(R.id.custFullNameA);
        email = (EditText) findViewById(R.id.custEmailA);
        phone = (EditText) findViewById(R.id.custPhoneA);
        address = (EditText) findViewById(R.id.custAddressA);
        postalcode = (EditText) findViewById(R.id.custPostalCodeA);
        hometwon = (EditText) findViewById(R.id.custHTownA);
        password = (EditText) findViewById(R.id.custPasswordA);
        charctor = (Spinner) findViewById(R.id.custspinnerA);
        Button save = (Button) findViewById(R.id.saveCust);

        // Default Values Set into TextField. It's easy to Test Our App

        id.setText("1");
        fullname.setText("Madurangi Malsha");
        email.setText("mm@gmail.com");
        phone.setText("0711327510");
        address.setText("Ehaliyagoda, Rathanapura");
        postalcode.setText("123-EL");
        hometwon.setText("Rathnapura");
        password.setText("1234m");


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.charactors, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        charctor.setAdapter(adapter);
    }
}