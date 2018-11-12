package com.example.ckxgo.layoutstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ChooseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        Button select_radio = (Button) findViewById(R.id.select_radio);
        select_radio.setOnClickListener((v)->{
            RadioGroup eg_sex = (RadioGroup) findViewById(R.id.eg_sex);
            String info = getRadioInfo(eg_sex);
            Toast.makeText(ChooseActivity.this,"INFO:"+info,Toast.LENGTH_SHORT).show();
        });
        LinearLayout checkbox_layout = (LinearLayout) findViewById(R.id.checkbox_layout);
        Button select_check = (Button) findViewById(R.id.select_check);
        select_check.setOnClickListener((v)->{
            String info = getCheckedInfo(checkbox_layout);
            Toast.makeText(ChooseActivity.this,"INFO:"+info,Toast.LENGTH_SHORT).show();

        });
    }

    private String getCheckedInfo(LinearLayout linearLayout){
        String info = "";
        int num = linearLayout.getChildCount();
        for(int i = 0 ; i< num ; i++){
            CheckBox cb = (CheckBox) linearLayout.getChildAt(i);
            if(cb.isChecked()){
                info = info + cb.getText().toString() + "\n";
            }
        }
        return info;
    }

    private String getRadioInfo(RadioGroup radioGroup){
        String info ="";
        int num = radioGroup.getChildCount();
        for(int i = 0;i<num;i++){
            RadioButton rd = (RadioButton) radioGroup.getChildAt(i);
            if(rd.isChecked()){
                info = rd.getText().toString();
                break;
            }
        }
        return info;
    }
}
