package com.example.cleanerservice.DBHandler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.cleanerservice.model.User;

public class DBHandler extends SQLiteOpenHelper {

    public DBHandler(@Nullable Context context) {
        super(context,"db_clean",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql="CREATE TABLE tblUser(uID INTEGER PRIMARY KEY, FULLNAME VARCHAR(25), EMAIL VARCHAR(25),PHONE INTEGER, ADDRESS VARCHAR(50), POSTAL VARCHAR(20), HOMETOWN VARCHAR(20), PASSWORD VARCHAR(20), CHARACTOR VARCHAR(20))";
        sqLiteDatabase.execSQL(sql);
        sql="CREATE TABLE tblConstructor(cID INTEGER PRIMARY KEY, FULLNAME VARCHAR(25),NIC VARCHAR(20), DOB VARCHAR(20), GENDER VARCHAR(20), EMAIL VARCHAR(50), PHONE VARCHAR(20), ADDRESS VARCHAR(50), POSTAL VARCHAR(20), HOMETOWN VARCHAR(50), PASSWORD VARCHAR(30), ABOUTME VARCHAR(250), CHARACTOR VARCHAR(20))";
        sqLiteDatabase.execSQL(sql);
        sql="CREATE TABLE tblAdvertisement(aID INTEGER PRIMARY KEY, FULLNAME VARCHAR(50), LOCATION VARCHAR(50), DESCRIPTION VARCHAR(250), PACKAGENAME VARCHAR(50), PACKAGEPRICE VARCHAR(20), FRONTIMAGE BLOG, BACKIMAGE BLOG, INSIDEONE BLOG, INSIDETWO BLOG, EMAIL VARCHAR(50), CONTACT INTEGER)";
        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS tblUser";
        db.execSQL(sql);
        sql="DROP TABLE IF EXISTS tblConstructor";
        db.execSQL(sql);
        sql="DROP TABLE IF EXISTS tblAdvertisement";
        db.execSQL(sql);
    }

    public long insert_user( User user){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("uID", user.getId());
        contentValues.put("FULLNAME", user.getFullName());
        contentValues.put("EMAIL", user.getEmail());
        contentValues.put("PHONE", user.getPhoneNumber());
        contentValues.put("ADDRESS", user.getAddress());
        contentValues.put("POSTAL", user.getPostalCode());
        contentValues.put("HOMETOWN", user.getHomeTown());
        contentValues.put("PASSWORD", user.getPassword());
        contentValues.put("CHARACTOR", user.getType());

        return db.insert("tblUser",null,contentValues);

    }

//    public ArrayList<Product> viewAllProducts(){
//        SQLiteDatabase db = getReadableDatabase();
//        String sql="SELECT * FROM tblProduct";
//        Cursor cursor = db.rawQuery(sql,null);
//        int count = cursor.getCount();
//        ArrayList<Product> products = new ArrayList<Product>();
//        if(count!=0){
//            while (cursor.moveToNext()){
//                Product product = new Product();
//                product.setPrdId(cursor.getInt(0));
//                product.setpName(cursor.getString(1));
//                product.setpPrice(cursor.getString(2));
//                product.setpCategory(cursor.getString(3));
//                product.setDesc(cursor.getString(4));
//                product.setImg(cursor.getBlob(5));
//                products.add(product);
//            }
//        }
//        return products;
//    }

}
