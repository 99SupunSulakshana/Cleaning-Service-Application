package com.example.cleanerservice.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.example.cleanerservice.R;

public class CleanerProfile extends AppCompatActivity {

    EditText id, fullname, nic, dob, email, phone, address, postal, hometown, password, aboutme;
    Spinner charactor;
    RadioButton male, female;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cleaner_profile);

        id = findViewById(R.id.conidc);
        fullname = findViewById(R.id.conFullNamec);
        nic = findViewById(R.id.conNicc);
        dob = findViewById(R.id.condobc);
        male = findViewById(R.id.conMalec);
        female = findViewById(R.id.conFemalec);
        email = findViewById(R.id.conEmailc);
        phone = findViewById(R.id.conPhonec);
        address = findViewById(R.id.conAddressc);
        postal = findViewById(R.id.conPostalCodec);
        hometown = findViewById(R.id.conHometownc);
        password = findViewById(R.id.conPasswordc);
        aboutme = findViewById(R.id.aboutMec);
        charactor = findViewById(R.id.spinner2c);

        id.setText("1");
        fullname.setText("Kusal Mendis");
        nic.setText("992656453V");
        dob.setText("1999/09/10");
        email.setText("kmendis@gmail.com");
        phone.setText("0711327510");
        address.setText("Rathnapura, Ehaliyagoda");
        postal.setText("123-B");
        hometown.setText("Rathnapura");
        password.setText("123P");
        aboutme.setText("To gain a Cleaning position with Carlitz Hotel where comprehensive cleaning skills, certification in public health, and 5 years of providing sanitation services will be put to maximum use.");

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.charactors, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        charactor.setAdapter(adapter);

    }
}