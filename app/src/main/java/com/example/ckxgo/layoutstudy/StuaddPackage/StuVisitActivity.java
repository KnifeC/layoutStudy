package com.example.ckxgo.layoutstudy.StuaddPackage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.ckxgo.layoutstudy.R;

import java.util.ArrayList;

public class StuVisitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_visit);
        ListView stlistview = (ListView)findViewById(R.id.stulistview);
        Intent intent = getIntent();
        ArrayList<Student> list = (ArrayList<Student>)intent.getSerializableExtra("stukey");
        StudentAdapter studentAdapter = new StudentAdapter(StuVisitActivity.this,R.layout.studentlistview,list);
        stlistview.setAdapter(studentAdapter);
    }
}
