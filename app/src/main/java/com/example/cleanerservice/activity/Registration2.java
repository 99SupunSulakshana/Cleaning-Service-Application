package com.example.cleanerservice.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.cleanerservice.DBHandler.DBHandler;
import com.example.cleanerservice.R;
import com.example.cleanerservice.model.Constructor;

public class Registration2 extends AppCompatActivity {

    DBHandler db;
    EditText id, fullname, nic, dob, email, phone, address, postal, hometown, password, aboutme;
    Spinner charactor;
    RadioButton male, female;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration2);

        db = new DBHandler(this);
        Button save = (Button) findViewById(R.id.saveCon);

        id = findViewById(R.id.conid);
        fullname = findViewById(R.id.conFullName);
        nic = findViewById(R.id.conNic);
        dob = findViewById(R.id.condob);
        male = findViewById(R.id.conMale);
        female = findViewById(R.id.conFemale);
        email = findViewById(R.id.conEmail);
        phone = findViewById(R.id.conPhone);
        address = findViewById(R.id.conAddress);
        postal = findViewById(R.id.conPostalCode);
        hometown = findViewById(R.id.conHometown);
        password = findViewById(R.id.conPassword);
        aboutme = findViewById(R.id.aboutMe);
        charactor = findViewById(R.id.spinner2);

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

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constructor constructor = new Constructor();
                try{
                    if(male.isChecked()){
                        gender = "Male";
                    }else{
                        gender = "Female";
                    }

                    constructor.setId(Integer.parseInt(id.getText().toString()));
                    constructor.setFullName(fullname.getText().toString());
                    constructor.setNic(nic.getText().toString());
                    constructor.setDob(dob.getText().toString());
                    constructor.setGender(gender);
                    constructor.setEmail(email.getText().toString());
                    constructor.setPhone(Integer.parseInt(phone.getText().toString()));
                    constructor.setAddress(address.getText().toString());
                    constructor.setPostalCode(postal.getText().toString());
                    constructor.setHomeTown(hometown.getText().toString());
                    constructor.setPassword(password.getText().toString());
                    constructor.setAboutMe(aboutme.getText().toString());
                    constructor.setType(charactor.getSelectedItem().toString());
                    if(db.insert_cleaner(constructor) >0){
                        Toast.makeText(Registration2.this, "Cleaner account created!", Toast.LENGTH_SHORT).show();
                        clearFields();
                        redirect();
                    }

                }catch (Exception e){
                    Log.e("Error", e.getMessage());
                    Toast.makeText(Registration2.this, "Please Try Again..", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void redirect(){
        Intent intent = new Intent(Registration2.this, ConstrLogin.class);
        startActivity(intent);
    }
    public void clearFields(){
        id.setText("");
        fullname.setText("");
        nic.setText("");
        dob.setText("");
        email.setText("");
        phone.setText("");
        address.setText("");
        postal.setText("");
        hometown.setText("");
        password.setText("");
        aboutme.setText("");

    }
}