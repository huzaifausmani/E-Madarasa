package com.example.e_madarasa;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Lessons {

    //data members
    private int sabak;
    private int sabki;
    private int manzil;
    private int student_id;
    private String date;

    //parameterized constructor
    public Lessons(int sabak, int sabki, int manzil, int student_id, String date){
        this.sabak = sabak;
        this.sabki = sabki;
        this.manzil = manzil;
        this.student_id = student_id;

        if(date.contentEquals("")) {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            String dateToSet = dateFormat.format(new Date());
            this.date = dateToSet;
        }
        else { this.date = date; }
    }

    //getter
    public int getSabak(){ return this.sabak; }
    public int getSabki(){ return this.sabki; }
    public int getManzil(){ return this.manzil; }
    public int getStudentId(){ return this.student_id; }
    public String getDate(){ return this.date; }

    //setters
    public void setSabak(int sabak) { this.sabak = sabak; }
    public void setSabki(int sabki) { this.sabki = sabki; }
    public void setManzil(int manzil) { this.manzil = manzil; }
    public void setStudentId(int student_id) { this.student_id = student_id; }
    public void setDate(String date) { this.date = date; }


    @Override
    public String toString() {
        return "Lesson";
    }
}
