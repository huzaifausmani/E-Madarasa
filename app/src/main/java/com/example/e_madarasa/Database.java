package com.example.e_madarasa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "eMadarasa.db";
    private static final String STUDENT_TABLE = "students";
    private static final String LESSON_TABLE = "lessons";

    public Database(Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String createStudent = "create table if not exists " + STUDENT_TABLE +
                "(student_id integer primary key autoincrement," +
                "name text)";
        String createLesson = "create table if not exists " + LESSON_TABLE +
                "(lesson_id integer primary key autoincrement," +
                "sabak integer, "+
                "sabki integer, "+
                "manzil integer, "+
                "student_id integer, "+
                "date text, "+
                "foreign key (student_id) references " + STUDENT_TABLE +" (student_id))";
        db.execSQL(createStudent);
        db.execSQL(createLesson);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        String dropStudent = "drop table if exists " + STUDENT_TABLE;
        String dropLesson = "drop table if exists " + LESSON_TABLE;
        db.execSQL(dropStudent);
        db.execSQL(dropLesson);
        onCreate(db);
    }

    public List<Students> GetStudents(){
        List<Students> students = new ArrayList<>();

        String select = "select * from " + STUDENT_TABLE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(select, null);

        if (cursor.moveToFirst()) {
            do {
                students.add(new Students(cursor.getInt(0),cursor.getString(1)));
            } while (cursor.moveToNext());
        }
        cursor.close();

        return students;
    }

    public List<Lessons> GetLessons(int student_id){
        List<Lessons> lessons = new ArrayList<>();

        String select = "select * from " + LESSON_TABLE +" where student_id = "+ student_id +";";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(select, null);

        if (cursor.moveToFirst()) {
            do {
                lessons.add(new Lessons(cursor.getInt(1),cursor.getInt(2),cursor.getInt(3),cursor.getInt(4),cursor.getString(5)));
            } while (cursor.moveToNext());
        }
        cursor.close();

        return lessons;
    }

    public boolean LessonExists(int student_id,String date){
        boolean lessonExists = false;

        String select = "select * from " + LESSON_TABLE +" where student_id = " + student_id +
                " AND date = " + "'" + date + "';";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(select, null);

        if (cursor.moveToFirst()) {
            do {
                lessonExists = true;
            } while (cursor.moveToNext());
        }
        cursor.close();

        return lessonExists;
    }

    public void InsertLesson(Lessons lesson) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("sabak", lesson.getSabak());
        values.put("sabki", lesson.getSabki());
        values.put("manzil", lesson.getManzil());
        values.put("student_id", lesson.getStudentId());
        values.put("date", lesson.getDate());

        if(LessonExists(lesson.getStudentId(), lesson.getDate())){
            db.update(LESSON_TABLE, values, "student_id  = "+ lesson.getStudentId() +" AND date = '" +lesson.getDate()+"'"  , null);
        }
        else { db.insert(LESSON_TABLE, null, values); }
    }

    public void InsertStudent(Students student) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", student.getStudentName());

        db.insert(STUDENT_TABLE, null, values);
    }
}
