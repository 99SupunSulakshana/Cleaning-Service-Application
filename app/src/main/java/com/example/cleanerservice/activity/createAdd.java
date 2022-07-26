package com.example.cleanerservice.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.cleanerservice.DBHandler.DBHandler;
import com.example.cleanerservice.R;
import com.example.cleanerservice.model.Advertisement;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class createAdd extends AppCompatActivity {

    DBHandler db;
    EditText id, name, location, description, packagePrice, email, contact, date;
    Spinner packageName;
    ImageView pic1;
    byte imageByte[];
    String price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_add);

        db = new DBHandler(this);

        id = (EditText) findViewById(R.id.addId);
        name = (EditText) findViewById(R.id.addName);
        location = (EditText) findViewById(R.id.addLocation);
        description = (EditText) findViewById(R.id.addDesc);
        packagePrice = (EditText) findViewById(R.id.addPrice);
        email = (EditText) findViewById(R.id.addEmail);
        contact = (EditText) findViewById(R.id.addContact);
        packageName = (Spinner) findViewById(R.id.addspinner);
        pic1 = (ImageView) findViewById(R.id.logo1);
        date = (EditText) findViewById(R.id.addDate);
        Button save = (Button) findViewById(R.id.saveAdd);

        id.setText("1");
        name.setText("M Malsha");
        location.setText("Eheliyagoda, Rathnepura");
        description.setText("We have some cleaning job vacancies in this time period. Any person or organization can apply this.");
        email.setText("mm@gmail.com");
        contact.setText("0711327510");
        pic1.setImageResource(R.drawable.home);
        date.setText("2022/07/17 Valid Dates = 7");

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.packages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        packageName.setAdapter(adapter);


        pic1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.putExtra("crop","true");
                intent.putExtra("aspectX",0);
                intent.putExtra("aspectY",0);
                intent.putExtra("outputX",150);
                intent.putExtra("outputY",150);
                intent.putExtra("return-data","true");
                startActivityForResult(Intent.createChooser(intent,"SELECT IMAGE"),111);
            }
        });

        packageName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(packageName.getSelectedItem().toString().equals("Apartment")){
                    packagePrice.setText("$450.0");
                }else if(packageName.getSelectedItem().toString().equals("DomesticHouse")){
                    packagePrice.setText("$250.0");
                }else if(packageName.getSelectedItem().toString().equals("Regular")){
                    packagePrice.setText("$750.0");
                }else if(packageName.getSelectedItem().toString().equals("Deep")){
                    packagePrice.setText("$ 1250.0");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Advertisement advertisement = new Advertisement();
                try{
                    advertisement.setAddId(Integer.parseInt(id.getText().toString()));
                    advertisement.setAddName(name.getText().toString());
                    advertisement.setAddLocation(location.getText().toString());
                    advertisement.setAddDescription(description.getText().toString());
                    advertisement.setAddPackageName(packageName.getSelectedItem().toString());
                    advertisement.setAddPackagePrice(packagePrice.getText().toString());
                    advertisement.setAddFrontImage(imageByte);
                    advertisement.setAddEmail(email.getText().toString());
                    advertisement.setAddContact(Integer.parseInt(contact.getText().toString()));
                    advertisement.setAddDate(date.getText().toString());
                    if(db.insert_add(advertisement)>0){
                        Toast.makeText(createAdd.this, "Advertisement Created!!", Toast.LENGTH_SHORT).show();
                        reset();
                    }
                }catch(Exception e){
                    Log.e("Error", e.getMessage());
                    Toast.makeText(createAdd.this, "Cannot Create Advertisement!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void reset(){
        id.setText("");
        name.setText("");
        location.setText("");
        description.setText("");
        email.setText("");
        pic1.setImageResource(0);
        contact.setText("");
        packagePrice.setText("");

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 111){
            if( data !=null){
                Uri uri = data.getData();
                try{
                        Bitmap bitmap1 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
                        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
                        bitmap1.compress(Bitmap.CompressFormat.PNG, 0, arrayOutputStream);
                        imageByte = arrayOutputStream.toByteArray();
                        pic1.setImageBitmap(bitmap1);

                }catch(IOException e){
                    Log.e("Error : ", e.getMessage());
                }
            }
        }
    }


}