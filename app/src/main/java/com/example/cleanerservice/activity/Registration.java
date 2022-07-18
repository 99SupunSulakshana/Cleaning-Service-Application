package com.example.cleanerservice.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

import java.text.CollationElementIterator;

public class Registration extends AppCompatActivity {

    DBHandler db;

    EditText id, fullname, email, phone, address, postalcode, hometwon, password;
    Spinner charctor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        db = new DBHandler(this);

        id = (EditText) findViewById(R.id.custId);
        fullname = (EditText) findViewById(R.id.custFullName);
        email = (EditText) findViewById(R.id.custEmail);
        phone = (EditText) findViewById(R.id.custPhone);
         address = (EditText) findViewById(R.id.custAddress);
        postalcode = (EditText) findViewById(R.id.custPostalCode);
         hometwon = (EditText) findViewById(R.id.custHTown);
        password = (EditText) findViewById(R.id.custPassword);
        charctor = (Spinner) findViewById(R.id.custspinner);
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
                   user.setType(charctor.getSelectedItem().toString());
                   if(db.insert_user(user) > 0){
                       Toast.makeText(Registration.this, "User Added Successfully", Toast.LENGTH_SHORT).show();
                       clear();
                       redirect();
                   }
                }catch (Exception e){
                    Log.e("Error", e.getMessage());
                    Toast.makeText(Registration.this, "Please Try Again..", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void redirect(){
        Intent intent = new Intent(Registration.this, UserLogin.class);
        startActivity(intent);
    }

    public void clear(){

        id.setText("");
        fullname.setText("");
        email.setText("");
        phone.setText("");
        address.setText("");
        postalcode.setText("");
        hometwon.setText("");
        password.setText("");
    }

}

