package com.example.e_madarasa;

public class Students {

    //data members
    private int student_id;
    private String student_name;

    //parameterized constructor
    public Students(int student_id, String name){
        this.student_id = student_id;
        this.student_name = name;
    }
    public Students(String name){
        this.student_id = student_id;
        this.student_name = name;
    }

    //getters
    public int getStudentId(){ return this.student_id; }
    public String getStudentName(){ return this.student_name; }

    //setters
    public void setStudentId(int student_id) { this.student_id = student_id; }
    public void setStudentName(String student_name) { this.student_name = student_name; }

    @Override
    public String toString() {
        return getStudentId()+". "+getStudentName().toUpperCase()+" ";
    }

}
