package com.example.ckxgo.layoutstudy.StuaddPackage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;

import com.example.ckxgo.layoutstudy.R;

import java.util.Calendar;
import java.util.Date;

public class StuDateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_date);
        Intent intent = getIntent();
        DatePicker datePicker = (DatePicker)findViewById(R.id.datePicker);
        Button stu_date_button = (Button) findViewById(R.id.stu_date_button);
        stu_date_button.setOnClickListener((v)->{
            int day = datePicker.getDayOfMonth();
            int month = datePicker.getMonth();
            int year =  datePicker.getYear();
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month, day);
            Date date = calendar.getTime();
            String dateString = date.toString();
            intent.putExtra("StudentDate",dateString);
            setResult(RESULT_OK,intent);
            finish();
        });

    }
}
