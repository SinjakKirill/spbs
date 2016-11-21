package com.example.sinyakkirill.lab_4_5.appdatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Sinyak Kirill on 04.11.2016.
 */

public class AppDataBase extends SQLiteOpenHelper {

    public AppDataBase(Context context){super(context, "AppDataBase", null, 1);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            //create table Students
            db.execSQL("create table Students ( ID integer primary key autoincrement," +
                    " name text," +
                    " surname text," +
                    " patronymic text," +
                    " bday text," +
                    "city text," +
                    "country text," +
                    "login text," +
                    "password text," +
                    "awgmark real);");
            Log.d("Lab_7", "create table Students");
        }
        catch (Exception e){
            Log.d("Lab_7", "error create table Students");
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
