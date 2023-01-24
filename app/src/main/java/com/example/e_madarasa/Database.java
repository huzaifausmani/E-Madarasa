package com.example.e_madarasa;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "eMadarasa.db";
    private static final String TABLE_NAME = "students";

    public Database(Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String creation = "";
//        String creation = "create table if not exists " + TABLE_NAME + "("
//                + COLUMN_ID + " integer primary key autoincrement, "
//                + COLUMN_NAME + " text, "
//                + COLUMN_INTROVERT + " integer, "
//                + COLUMN_EXTROVERT + "integer, "
//                + COLUMN_AMBIVERT + "integer, "
//                + COLUMN_PSYCHOPATH + "integer, "
//                + COLUMN_SOCIOPATH + "integer )";
        db.execSQL(creation);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        String drop = "drop table if exists " + TABLE_NAME;
        db.execSQL(drop);
        onCreate(db);
    }
}
