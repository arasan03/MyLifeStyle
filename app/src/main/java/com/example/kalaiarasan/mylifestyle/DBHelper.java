package com.example.kalaiarasan.mylifestyle;



import android.content.Context;

import android.database.Cursor;

import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteDatabase.CursorFactory;

import android.database.sqlite.SQLiteOpenHelper;



public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context, String name, CursorFactory factory, int version) {

        super(context, name, factory, version);

    }



    public void delete() {

        SQLiteDatabase db = getWritableDatabase();

        db.execSQL("DELETE FROM LOG");

        db.close();

    }



    public String getResult() {

        SQLiteDatabase db = getReadableDatabase();

        String result = BuildConfig.FLAVOR;

        Cursor cursor = db.rawQuery("SELECT * FROM LOG", null);

        while (cursor.moveToNext()) {

            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append(result);

            stringBuilder.append(cursor.getString(0));

            stringBuilder.append(" ");

            stringBuilder.append(cursor.getString(1));

            stringBuilder.append(": ");

            stringBuilder.append(cursor.getString(2));

            stringBuilder.append(" \n DATE:");

            stringBuilder.append(cursor.getString(3));

            stringBuilder.append("\n\n");

            result = stringBuilder.toString();

        }

        return result;

    }



    public void insert(String bmi, String information, String date) {

        SQLiteDatabase db = getWritableDatabase();

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("INSERT INTO LOG VALUES(null,'");

        stringBuilder.append(bmi);

        stringBuilder.append("','");

        stringBuilder.append(information);

        stringBuilder.append("', '");

        stringBuilder.append(date);

        stringBuilder.append("' )");

        db.execSQL(stringBuilder.toString());

        db.close();

    }



    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE LOG(_id INTEGER PRIMARY KEY AUTOINCREMENT, date TEXT, information TEXT, bmi TEXT);");

    }



    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }


    public void update(String bmi, String information) {

        SQLiteDatabase db = getWritableDatabase();

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("UPDATE LOG SET bmi=");

        stringBuilder.append(bmi);

        stringBuilder.append(" WHERE information='");

        stringBuilder.append(information);

        stringBuilder.append("';");

        db.execSQL(stringBuilder.toString());

        db.close();

    }

}