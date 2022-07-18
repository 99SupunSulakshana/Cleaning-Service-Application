package com.example.cleanerservice.DBHandler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.cleanerservice.model.Advertisement;
import com.example.cleanerservice.model.Constructor;
import com.example.cleanerservice.model.User;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    public DBHandler(@Nullable Context context) {
        super(context,"db_clean_services1",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql="CREATE TABLE tblUser(uID INTEGER PRIMARY KEY, FULLNAME VARCHAR(25), EMAIL VARCHAR(25),PHONE INTEGER, ADDRESS VARCHAR(50), POSTAL VARCHAR(20), HOMETOWN VARCHAR(20), PASSWORD VARCHAR(20), CHARACTOR VARCHAR(20))";
        sqLiteDatabase.execSQL(sql);
        sql="CREATE TABLE tblConstructor(cID INTEGER PRIMARY KEY, FULLNAME VARCHAR(25),NIC VARCHAR(20), DOB VARCHAR(20), GENDER VARCHAR(20), EMAIL VARCHAR(50), PHONE INTEGER, ADDRESS VARCHAR(50), POSTAL VARCHAR(20), HOMETOWN VARCHAR(50), PASSWORD VARCHAR(30), ABOUTME VARCHAR(250), CHARACTOR VARCHAR(20))";
        sqLiteDatabase.execSQL(sql);
        sql="CREATE TABLE tblAdvertisement(aID INTEGER PRIMARY KEY, FULLNAME VARCHAR(50), LOCATION VARCHAR(50), DESCRIPTION VARCHAR(250), PACKAGENAME VARCHAR(50), PACKAGEPRICE VARCHAR(20), FRONTIMAGE BLOG, EMAIL VARCHAR(50), CONTACT INTEGER, DATE VARCHAR(50))";
        sqLiteDatabase.execSQL(sql);
        sql="CREATE TABLE tblReview(rID INTEGER PRIMARY KEY, NAME VARCHAR(50), MESSAGE VARCHAR(225), CREATEAT VARCHAR(50))";
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
        sql="DROP TABLE IF EXISTS tblReview";
        db.execSQL(sql);
    }

    public long insert_user(User user){

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

public long insert_cleaner(Constructor constructor){
    SQLiteDatabase db = getWritableDatabase();
    ContentValues contentValues = new ContentValues();
    contentValues.put("cID", constructor.getId());
    contentValues.put("FULLNAME", constructor.getFullName());
    contentValues.put("NIC", constructor.getNic());
    contentValues.put("DOB", constructor.getDob());
    contentValues.put("GENDER", constructor.getGender());
    contentValues.put("EMAIL", constructor.getEmail());
    contentValues.put("PHONE", constructor.getPhone());
    contentValues.put("ADDRESS", constructor.getAddress());
    contentValues.put("POSTAL", constructor.getPostalCode());
    contentValues.put("HOMETOWN", constructor.getHomeTown());
    contentValues.put("PASSWORD", constructor.getPassword());
    contentValues.put("ABOUTME", constructor.getAboutMe());
    contentValues.put("CHARACTOR", constructor.getType());


    return db.insert("tblConstructor",null, contentValues);
}

public long insert_add(Advertisement advertisement){
    SQLiteDatabase db = getWritableDatabase();
    ContentValues contentValues = new ContentValues();
    contentValues.put("aID", advertisement.getAddId());
    contentValues.put("FULLNAME", advertisement.getAddName());
    contentValues.put("LOCATION", advertisement.getAddLocation());
    contentValues.put("DESCRIPTION", advertisement.getAddDescription());
    contentValues.put("PACKAGENAME", advertisement.getAddPackageName());
    contentValues.put("PACKAGEPRICE", advertisement.getAddPackagePrice());
    contentValues.put("FRONTIMAGE", advertisement.getAddFrontImage());
    contentValues.put("EMAIL", advertisement.getAddEmail());
    contentValues.put("CONTACT", advertisement.getAddContact());
    contentValues.put("DATE", advertisement.getAddDate());

    return db.insert("tblAdvertisement", null, contentValues);
}

public Boolean checkusernamepassword(String useremail, String userpassword){
    SQLiteDatabase db = getReadableDatabase();
    Cursor cursor = db.rawQuery("SELECT * FROM tblUser where EMAIL=? and PASSWORD=?", new String[] {useremail,userpassword});
    if(cursor.getCount()>0)
        return true;
    else
        return false;
}

public Boolean checkcredits(String conname, String conpassword){
    SQLiteDatabase db = getReadableDatabase();
    Cursor cursor = db.rawQuery("SELECT * FROM tblConstructor where EMAIL=? and PASSWORD=?", new String[] {conname,conpassword});
    if(cursor.getCount()>0)
        return true;
    else
        return false;
}

    public ArrayList<User> viewAllUsers(){
        SQLiteDatabase db = getReadableDatabase();
        String sql="SELECT * FROM tblUser";
        Cursor cursor = db.rawQuery(sql,null);
        int count = cursor.getCount();
        ArrayList<User> users = new ArrayList<User>();
        if(count!=0){
            while (cursor.moveToNext()){
                User user = new User();
                user.setId(cursor.getInt(0));
                user.setFullName(cursor.getString(1));
                user.setEmail(cursor.getString(2));
                user.setPhoneNumber(cursor.getInt(3));
                user.setAddress(cursor.getString(4));
                user.setPostalCode(cursor.getString(5));
                user.setHomeTown(cursor.getString(6));
                users.add(user);
            }
        }
        return users;
    }

    public ArrayList<Constructor> viewAllCleaners(){
        SQLiteDatabase db = getReadableDatabase();
        String sql="SELECT * FROM tblConstructor";
        Cursor cursor = db.rawQuery(sql,null);
        int count = cursor.getCount();
        ArrayList<Constructor> constructors = new ArrayList<Constructor>();
        if(count!=0){
            while (cursor.moveToNext()){
                Constructor constructor = new Constructor();
                constructor.setId(cursor.getInt(0));
                constructor.setFullName(cursor.getString(1));
                constructor.setEmail(cursor.getString(2));
                constructor.setDob(cursor.getString(3));
                constructor.setGender(cursor.getString(4));
                constructor.setEmail(cursor.getString(5));
                constructor.setPhone(cursor.getInt(6));
                constructor.setAddress(cursor.getString(7));
                constructor.setPostalCode(cursor.getString(8));
                constructor.setHomeTown(cursor.getString(9));
                constructor.setPassword(cursor.getString(10));
                constructor.setAboutMe(cursor.getString(11));
                constructor.setType(cursor.getString(12));
                constructors.add(constructor);
            }
        }
        return constructors;
    }

    public ArrayList<Advertisement> viewAllAdds(){
        SQLiteDatabase db = getReadableDatabase();
        String sql="SELECT * FROM tblAdvertisement";
        Cursor cursor = db.rawQuery(sql,null);
        int count = cursor.getCount();
        ArrayList<Advertisement> advertisements = new ArrayList<Advertisement>();
        if(count!=0){
            while (cursor.moveToNext()){
                Advertisement advertisement = new Advertisement();
                advertisement.setAddId(cursor.getInt(0));
                advertisement.setAddName(cursor.getString(1));
                advertisement.setAddLocation(cursor.getString(2));
                advertisement.setAddDescription(cursor.getString(3));
                advertisement.setAddPackageName(cursor.getString(4));
                advertisement.setAddPackagePrice(cursor.getString(5));
                advertisement.setAddFrontImage(cursor.getBlob(6));
                advertisement.setAddEmail(cursor.getString(7));
                advertisement.setAddContact(cursor.getInt(8));
                advertisement.setAddDate(cursor.getString(9));
                advertisements.add(advertisement);
            }
        }
        return advertisements;
    }

}
