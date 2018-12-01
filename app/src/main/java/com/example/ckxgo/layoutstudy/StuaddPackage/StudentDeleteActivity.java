package com.example.ckxgo.layoutstudy.StuaddPackage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ckxgo.layoutstudy.R;

import java.util.ArrayList;

public class StudentDeleteActivity extends AppCompatActivity {
    ArrayList<Student> list = new ArrayList<Student>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_delete);
        Intent intent = getIntent();
        list = (ArrayList<Student>) intent.getSerializableExtra("StudentAdded");
        int position = (int) intent.getIntExtra("position", -1);
        Student student = list.get(position);
        ImageView stuhead = (ImageView) findViewById(R.id.DEL_studenticon);
        TextView stuname = (TextView) findViewById(R.id.DEL_studentname);
        TextView stunumber = (TextView) findViewById(R.id.DEL_studentnumber);
        TextView stumajor = (TextView) findViewById(R.id.DEL_studentmajor);
        TextView stusex = (TextView) findViewById(R.id.DEL_studentsex);
        Button button = (Button) findViewById(R.id.DEL_complete);
        stuhead.setImageResource(student.getImageId());
        stuname.setText(student.getStuname());
        stunumber.setText(student.getStunumber());
        stumajor.setText(student.getStumajor());
        stusex.setText(student.getSex());
        button.setOnClickListener((v)->{
            list.remove(position);
            intent.putExtra("StudentAdded",list);
            setResult(RESULT_OK,intent);
            finish();
        });


    }
}
