package com.example.ckxgo.layoutstudy;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class SeekbarActivity extends AppCompatActivity {
    ImageView http_picture;
    SeekBar sb_bigsmall;
    SeekBar sb_rotation;
    Matrix matrix;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbar);
        ImageView http_picture = (ImageView) findViewById(R.id.http_picture);
        SeekBar sb_bigsmall = (SeekBar) findViewById(R.id.sb_bigsmall);
        SeekBar sb_rotation = (SeekBar) findViewById(R.id.sb_rotation);
        Matrix matrix = new Matrix();
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screen = dm.widthPixels;
        sb_bigsmall.setMax(screen);
        sb_rotation.setMax(365);
        sb_bigsmall.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ImageView http_picture = (ImageView) findViewById(R.id.http_picture);
                Matrix matrix = new Matrix();
                int ivWidth = progress;
                int ivHeight = progress*3/4;
                http_picture.setLayoutParams(new LinearLayout.LayoutParams(ivWidth,ivHeight));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        sb_rotation.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ImageView http_picture = (ImageView) findViewById(R.id.http_picture);
                Matrix matrix = new Matrix();
                float d =progress;
                matrix.setRotate(d);
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.boy_head);
                Bitmap bitmap1 = bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);
                http_picture.setImageBitmap(bitmap1);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
}
