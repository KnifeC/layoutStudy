package com.example.ckxgo.layoutstudy.StuaddPackage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.ckxgo.layoutstudy.R;

import java.util.ArrayList;

public class StuVisitActivity extends AppCompatActivity {
    public final int MY_STUDENT_LIST = 1;
    ListView stlistview;
    ArrayList<Student> list = new ArrayList<Student>();
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
                intent.putExtra("StudentAdded",list);
                startActivityForResult(intent,MY_STUDENT_LIST);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case MY_STUDENT_LIST:
                if(resultCode == RESULT_OK){
                    list = (ArrayList<Student>)data.getSerializableExtra("StudentAdded");
                    //SimpleAdapter stuadapter = new SimpleAdapter()
                    StudentAdapter studentAdapter = new StudentAdapter(StuVisitActivity.this,R.layout.studentlistview,list);
                    stlistview.setAdapter(studentAdapter);
                }
                break;
        }
    }
}
