package com.example.ckxgo.layoutstudy;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class SavePasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_password);
        EditText savedName = (EditText)findViewById(R.id.savepsd_name);
        EditText savedPsd = (EditText)findViewById(R.id.savepsd_psd);
        CheckBox isRemember = (CheckBox)findViewById(R.id.isRemember);
        Button login = (Button)findViewById(R.id.savedLogin);
        SharedPreferences passave = getPreferences(0);
        if(passave!=null){
            savedName.setText(passave.getString("username",null));
            savedPsd.setText(passave.getString("password",null));
        }
        login.setOnClickListener((v)->{
            String name = savedName.getText().toString();
            if(name == null){
                savedName.setError("不允许为空");
            }
            String password = savedPsd.getText().toString();
            if(password == null){
                savedPsd.setError("不允许为空");
            }
            if(isRemember.isChecked()){
                SharedPreferences.Editor editor = passave.edit();
                editor.putString("username",name);
                editor.putString("password",password);
                editor.commit();
                Toast.makeText(SavePasswordActivity.this,"密码已保存",Toast.LENGTH_SHORT).show();
                finish();
            }
            else{
                SharedPreferences.Editor editor = passave.edit();
                editor.putString("username",null);
                editor.putString("password",null);
                editor.commit();
                Toast.makeText(SavePasswordActivity.this,"密码未保存",Toast.LENGTH_SHORT).show();
                finish();
                finish();
            }
        });
    }

}
