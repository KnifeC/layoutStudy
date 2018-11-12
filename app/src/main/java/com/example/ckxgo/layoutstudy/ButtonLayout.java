package com.example.ckxgo.layoutstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ButtonLayout extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener, View.OnFocusChangeListener {

    Button btn_one;
    Button btn_two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_layout);
        btn_one = findViewById(R.id.btn_one);
        btn_two = findViewById(R.id.btn_two);
        //btn_one.setOnClickListener(this);
        btn_two.setOnClickListener((v) -> {
            int value = 1;
            Button btn = (Button) v;
            int screenWidth = getWindow().getWindowManager().getDefaultDisplay().getWidth();
            if (value == 1 && btn.getWidth() > screenWidth - 35) {
                value = -1;
            } else if (value == -1 && btn.getWidth() < 5) {
                value = 1;
            }
            btn.setWidth(btn.getWidth() + (int) (btn.getWidth() * 0.1 * value));
            btn.setHeight(btn.getHeight() + (int) (btn.getHeight() * 0.1 * value));
        });
        btn_one.setFocusable(true);
        btn_one.setFocusableInTouchMode(true);
        btn_one.requestFocus();
        btn_one.requestFocusFromTouch();
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        return false;
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {

    }
}
