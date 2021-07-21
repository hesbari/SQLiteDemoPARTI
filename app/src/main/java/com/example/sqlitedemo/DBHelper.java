package com.example.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;
/*
creating a helper object helps to create, open, manage the database. this method approach
is always return very quickly because the databe is not created or opented until the method
is called
 */

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // you construct the dabase (USERDATA.DB)
        //SQL to create a table...
        db.execSQL("create Table userdetails(name Text primary key, contact Text, dob Text)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop Table if exists Userdetails");

    }

    public Boolean insertuserdata(String name, String contact, String dob){

        SQLiteDatabase DB = this.getWritableDatabase(); // return a DB that is writable
        ContentValues CV = new ContentValues(); // which keep things in pairs (key,value)
        CV.put("name",name);
        CV.put("contact",contact);
        CV.put("dob",dob);

        long result = DB.insert("Userdetails",null,CV);
        Log.d("RESULT-ROW", "insertuserdata: "+result);

        return result != -1;
    }


}
