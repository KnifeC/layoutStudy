package com.example.ckxgo.layoutstudy.StuaddPackage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.example.ckxgo.layoutstudy.R;

import java.util.ArrayList;

public class StuChangeActivity extends AppCompatActivity {
    EditText stuaddName;
    EditText stuaddNumber;
    AutoCompleteTextView stuaddMajor;
    Button stuchange_complete;
    RadioButton stuaddmale;
    RadioButton stuaddfamale;
    RadioButton stuadd_head_choose_1;
    RadioButton stuadd_head_choose_2;
    RadioButton stuadd_head_choose_3;
    RadioButton stuadd_head_choose_4;
    ImageView stuaddheadimage;
    ArrayList<Student> list =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_change);
        init();
        Intent intent = getIntent();
        list = (ArrayList<Student>)intent.getSerializableExtra("StudentAdded");
        int position = intent.getIntExtra("position",-1);
        Student student = list.get(position);
        stuaddName.setText(student.getStuname());
        stuaddNumber.setText(student.getStunumber());
        stuaddMajor.setText(student.getStumajor());

        stuchange_complete.setOnClickListener((v)->{
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
            String major = stuaddMajor.getText().toString();
            list.add(student);
        });
        stuchange_complete.setOnClickListener((v)->{
            intent.putExtra("StudentAdded",list);
            setResult(RESULT_OK,intent);
            finish();
        });
    }

    private void init(){
        String[]stuMajor = {"cqjtu计算机科学与技术","cqjtu物联网工程","cqjtu通信工程","cqjtu电子信息工程"};
        stuaddName = (EditText) findViewById(R.id.stuchangeName);
        stuaddNumber = (EditText) findViewById(R.id.stuchangeNumber);
        stuaddMajor = (AutoCompleteTextView) findViewById(R.id.stuchangeMajor);
        stuchange_complete = (Button) findViewById(R.id.stuchange_complete);
        stuadd_head_choose_1 = (RadioButton) findViewById(R.id.stuchange_head_choose_1);
        stuadd_head_choose_2 = (RadioButton) findViewById(R.id.stuchange_head_choose_2);
        stuadd_head_choose_3 = (RadioButton) findViewById(R.id.stuchange_head_choose_3);
        stuadd_head_choose_4 = (RadioButton) findViewById(R.id.stuchange_head_choose_4);
        stuaddmale = (RadioButton) findViewById(R.id.stuchangemale);
        stuaddfamale = (RadioButton) findViewById(R.id.stuchangefamale);
        stuaddheadimage = (ImageView) findViewById(R.id.stuchangeheadimage);
        ArrayAdapter majorAdapter = new ArrayAdapter(StuChangeActivity.this,android.R.layout.simple_list_item_1,stuMajor);
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
        if(TextUtils.isEmpty(stuaddMajor.getText())){
            stuaddMajor.setError("专业不能为空");
            return false;
        }
        return true;
    }
}
