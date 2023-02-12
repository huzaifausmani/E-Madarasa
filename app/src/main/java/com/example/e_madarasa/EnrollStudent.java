package com.example.e_madarasa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class EnrollStudent extends AppCompatActivity {
    private ListView listView;
    private EditText name;
    private Button button;
    private Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enroll_student);
        button = findViewById(R.id.enrollButton);
        name = findViewById(R.id.studentName);
        listView = findViewById(R.id.studentList);
        db = new Database(this);
        RefreshGrid();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.getText().length()>0){
                    db.InsertStudent(new Students(name.getText().toString()));
                    name.setText("");
                    RefreshGrid();
                }
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(EnrollStudent.this, MainActivity.class);
                Students message = (Students) adapterView.getItemAtPosition(i);
                intent.putExtra("Name", message.getStudentName());
                intent.putExtra("Id", Integer.toString(message.getStudentId()));
                startActivity(intent);
            }
        });
    }

    public void RefreshGrid(){
        List<Students> students = db.GetStudents();

        ArrayAdapter arrayAdapter = new ArrayAdapter<Students>(EnrollStudent.this, android.R.layout.simple_list_item_1,students);
        listView.setAdapter(arrayAdapter);



    }
}
