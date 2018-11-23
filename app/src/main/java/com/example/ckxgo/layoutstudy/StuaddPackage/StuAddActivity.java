package com.example.ckxgo.layoutstudy.StuaddPackage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.ckxgo.layoutstudy.R;

public class StuAddActivity extends AppCompatActivity {
    String[] stuaddMajor = {"计算机科学与技术","物联网工程","通信工程","电子信息工程"};
    EditText stuaddName = (EditText) findViewById(R.id.stuaddName);
    EditText stuaddNumber = (EditText) findViewById(R.id.stuaddNumber);
    RadioGroup stuaddSexGroup = (RadioGroup) findViewById(R.id.stuaddSexGroup);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_add);

    }
}
