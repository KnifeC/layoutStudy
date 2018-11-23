package com.example.ckxgo.layoutstudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button goLinear = (Button) findViewById(R.id.goLinear);
        goLinear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LinearActivity.class);
                startActivity(intent);
            }
        });
        Button goFrame = (Button) findViewById(R.id.goFrame);
        goFrame.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FrameActivity.class);
                startActivity(intent);
            }
        });
        Button goRelative = (Button)findViewById(R.id.goRelative);
        goRelative.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RelativeActivity.class);
                startActivity(intent);
            }
        });
        Button goTable = (Button) findViewById(R.id.goTable);
        goTable.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TableLaout.class);
                startActivity(intent);
            }
        });
        Button goComprehensive = (Button) findViewById(R.id.goComprehensive);
        goComprehensive.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ComprehensiveActivity.class);
                startActivity(intent);
            }
        });
        Button pic_text_btn = (Button) findViewById(R.id.pic_text_btn);
        pic_text_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,PicText.class);
                startActivity(intent);
            }
        });
        Button btn_layout_btn = (Button) findViewById(R.id.btn_layout_btn);
        btn_layout_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ButtonLayout.class);
                startActivity(intent);
            }
        });
        Button btn_choose = (Button) findViewById(R.id.btn_choose);
        btn_choose.setOnClickListener((v)->{
            Intent intent = new Intent(MainActivity.this,ChooseActivity.class);
            startActivity(intent);
        });
        Button seekbar = (Button) findViewById(R.id.seekbar);
        seekbar.setOnClickListener((v)->{
            Intent intent = new Intent(MainActivity.this,SeekbarActivity.class);
            startActivity(intent);
        });
        Button stuaddpro = (Button) findViewById(R.id.stuaddpro);
        stuaddpro.setOnClickListener((v)->{
            
        });

        Button savelaunch = (Button) findViewById(R.id.savelaunch);
        savelaunch.setOnClickListener((v)->{
            Intent intent = new Intent(MainActivity.this,SavePasswordActivity.class);
            startActivity(intent);
        });

        Button goPicChange = (Button) findViewById(R.id.goPicChange);
        goPicChange.setOnClickListener((v)->{
            Intent intent = new Intent(MainActivity.this,PicChange.class);
            startActivity(intent);
        });
    }
}
