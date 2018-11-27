package com.example.ckxgo.layoutstudy.StuaddPackage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.ckxgo.layoutstudy.R;

import java.util.ArrayList;

public class StuVisitActivity extends AppCompatActivity {
    private final int MY_STUDENT_LIST = 1;
    ListView stlistview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_visit);
        stlistview = (ListView)findViewById(R.id.stulistview);
        Button gotoStuadd = (Button) findViewById(R.id.gotoStuadd);
        gotoStuadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StuVisitActivity.this,StuAddActivity.class);
                startActivityForResult(intent,MY_STUDENT_LIST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case MY_STUDENT_LIST:
                if(requestCode == RESULT_OK){
                    ArrayList<Student> list = (ArrayList<Student>)data.getSerializableExtra("stukey");
                    StudentAdapter studentAdapter = new StudentAdapter(StuVisitActivity.this,R.layout.studentlistview,list);
                    stlistview.setAdapter(studentAdapter);
                }
                break;
        }
    }
}
