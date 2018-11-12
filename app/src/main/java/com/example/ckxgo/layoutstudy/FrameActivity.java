package com.example.ckxgo.layoutstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class FrameActivity extends AppCompatActivity implements View.OnClickListener{
    Button playBtn;
    Button pauseBtn;
    ImageView im_play;
    ImageView im_pause;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
        playBtn = (Button) findViewById(R.id.btn_play);
        pauseBtn = (Button) findViewById(R.id.btn_pause);
        im_play = (ImageView) findViewById(R.id.im_play);
        im_pause = (ImageView) findViewById(R.id.im_pause);
        playBtn.setOnClickListener(this);
        pauseBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_play:
                //Toast.makeText(FrameActivity.this,"PLAY",Toast.LENGTH_SHORT);
                im_play.setVisibility(View.VISIBLE);
                im_pause.setVisibility(View.GONE);
                break;
            case R.id.btn_pause:
                //Toast.makeText(FrameActivity.this,"PAUSE",Toast.LENGTH_SHORT);
                im_play.setVisibility(View.GONE);
                im_pause.setVisibility(View.VISIBLE);
                break;
        }
    }
}
