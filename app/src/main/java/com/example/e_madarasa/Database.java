package com.example.e_madarasa;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "eMadarasa.db";
    private static final String TABLE_NAME = "students";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_SABAK = "sabak";
    private static final String COLUMN_SABKI = "sabki";
    private static final String COLUMN_MANZIL = "manzil";
    private static final String COLUMN_DATE_ENROLLED = "date_enrolled";
    private static final String COLUMN_DATE_MODIFIED = "date_modified";

    public Database(Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String creation = "create table if not exists " + TABLE_NAME + "("
                + COLUMN_ID + " integer primary key autoincrement, "
                + COLUMN_NAME + " text)";
//                + COLUMN_SABAK + " integer, "
//                + COLUMN_SABKI + "integer, "
//                + COLUMN_MANZIL + "integer, "
//                + COLUMN_DATE_ENROLLED + "date, "
//                + COLUMN_DATE_MODIFIED + "date )";
        db.execSQL(creation);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        String drop = "drop table if exists " + TABLE_NAME;
        db.execSQL(drop);
        onCreate(db);
    }
}
