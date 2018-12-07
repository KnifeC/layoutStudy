package com.example.ckxgo.layoutstudy.StuaddPackage;

import android.content.Intent;
import android.graphics.Color;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ckxgo.layoutstudy.R;

import java.util.ArrayList;

public class StuAddActivity extends AppCompatActivity {
    EditText stuaddName;
    EditText stuaddNumber;
    Spinner stuaddMajor;
    Button stuadd_add;
    Button stuadd_visit;
    RadioButton stuaddmale;
    RadioButton stuaddfamale;
    RadioButton stuadd_head_choose_1;
    RadioButton stuadd_head_choose_2;
    RadioButton stuadd_head_choose_3;
    RadioButton stuadd_head_choose_4;
    ImageView stuaddheadimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_add);
        String[]stuMajor = {"cqjtu计算机科学与技术","cqjtu物联网工程","cqjtu通信工程","cqjtu电子信息工程"};
        stuaddName = (EditText) findViewById(R.id.stuaddName);
        stuaddNumber = (EditText) findViewById(R.id.stuaddNumber);
        stuaddMajor = (Spinner) findViewById(R.id.stuaddMajor);
        stuadd_add = (Button) findViewById(R.id.stuadd_add);
        stuadd_visit = (Button) findViewById(R.id.stuadd_visit);
        stuadd_head_choose_1 = (RadioButton) findViewById(R.id.stuadd_head_choose_1);
        stuadd_head_choose_2 = (RadioButton) findViewById(R.id.stuadd_head_choose_2);
        stuadd_head_choose_3 = (RadioButton) findViewById(R.id.stuadd_head_choose_3);
        stuadd_head_choose_4 = (RadioButton) findViewById(R.id.stuadd_head_choose_4);
        stuaddmale = (RadioButton) findViewById(R.id.stuaddmale);
        stuaddfamale = (RadioButton) findViewById(R.id.stuaddfamale);
        stuaddheadimage = (ImageView) findViewById(R.id.stuaddheadimage);
        stuaddheadimage.setTag(R.drawable.boy_head);
        ArrayAdapter majorAdapter = new ArrayAdapter(StuAddActivity.this,android.R.layout.simple_spinner_item,stuMajor);
        stuaddMajor.setAdapter(majorAdapter);
        stuadd_head_choose_1.setOnClickListener((v)->{
            stuaddheadimage.setImageResource(R.drawable.boy_head);
            stuaddheadimage.setTag(R.drawable.boy_head);
        });
        stuadd_head_choose_2.setOnClickListener((v)->{
            stuaddheadimage.setImageResource(R.drawable.boy_head2);
            stuaddheadimage.setTag(R.drawable.boy_head2);
        });
        stuadd_head_choose_3.setOnClickListener((v)->{
            stuaddheadimage.setImageResource(R.drawable.girl_head);
            stuaddheadimage.setTag(R.drawable.girl_head);
        });
        stuadd_head_choose_4.setOnClickListener((v)->{
            stuaddheadimage.setImageResource(R.drawable.girl_head2);
            stuaddheadimage.setTag(R.drawable.girl_head2);
        });
        Intent intent = getIntent();
        if(intent.getSerializableExtra("changeStudent") != null){
            //changeStudent();
        }
        ArrayList<Student> list = (ArrayList<Student>) intent.getSerializableExtra("StudentAdded");
        stuadd_add.setOnClickListener((v)->{
            if(!check()){
                return;
            }
            String sex = "";
            if(stuaddmale.isChecked()){
                sex = "男";
            }
            if(stuaddfamale.isChecked()){
                sex = "女";
            }
            String major = stuaddMajor.getSelectedItem().toString();
            Student student = new Student(stuaddName.getText().toString(),Integer.parseInt(stuaddheadimage.getTag().toString()),stuaddNumber.getText().toString(),major,sex);
            list.add(student);

        });
        stuadd_visit.setOnClickListener((v)->{
            intent.putExtra("StudentAdded",list);
            setResult(RESULT_OK,intent);
            finish();
        });
    }


    private boolean check(){
        if(TextUtils.isEmpty(stuaddName.getText())){
            stuaddName.setError("姓名不能为空");
            return false;
        }
        if(TextUtils.isEmpty(stuaddNumber.getText())){
            stuaddNumber.setError("学号不能为空");
            return false;
        }
        return true;
    }
}
