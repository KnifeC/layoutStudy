package com.example.ckxgo.layoutstudy.StuaddPackage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.ckxgo.layoutstudy.R;

public class StuAddActivity extends AppCompatActivity {
    EditText stuaddName;
    EditText stuaddNumber;
    RadioGroup stuaddSexGroup;
    AutoCompleteTextView stuaddMajor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_add);
        String[]stuMajor = {"计算机科学与技术","物联网工程","通信工程","电子信息工程"};
        stuaddName = (EditText) findViewById(R.id.stuaddName);
        stuaddNumber = (EditText) findViewById(R.id.stuaddNumber);
        stuaddSexGroup = (RadioGroup) findViewById(R.id.stuaddSexGroup);
        stuaddMajor = (AutoCompleteTextView) findViewById(R.id.stuaddMajor);
        Adapter majorAdapter = new ArrayAdapter(StuAddActivity.this,android.R.layout.simple_dropdown_item_1line,stuMajor);

    }
}
