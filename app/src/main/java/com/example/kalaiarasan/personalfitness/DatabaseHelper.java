package com.example.kalaiarasan.personalfitness;



import android.content.ContentValues;

import android.content.Context;

import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context applicationContext, String s, Context context, int i) {

        super(context, "mylife.db", null, 1);

    }


    public Boolean chkemail(String email) {

        if (getReadableDatabase().rawQuery("Select * from user where email=?", new String[]{email}).getCount() > 0) {

            return Boolean.valueOf(false);

        }

        return Boolean.valueOf(true);

    }



    public Boolean emailpassword(String email, String password) {

        if (getReadableDatabase().rawQuery("select * from user where email=? and password=?", new String[]{email, password}).getCount() > 0) {

            return Boolean.valueOf(true);

        }

        return Boolean.valueOf(false);

    }


    public Boolean insert(String email, String password) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put("email", email);

        contentValues.put("password", password);

        if (sqLiteDatabase.insert("user", null, contentValues) == -1) {

            return Boolean.valueOf(false);

        }

        return Boolean.valueOf(true);

    }



    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table user (email text primary key, password text)");

    }



    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("drop table if exists user");

    }

}