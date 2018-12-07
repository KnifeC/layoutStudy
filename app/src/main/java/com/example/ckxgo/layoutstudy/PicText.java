package com.example.ckxgo.layoutstudy;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StrikethroughSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PicText extends AppCompatActivity {
    private static final String TAG = "PicText";
    TextView text_color;
    SpannableString span_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_text);
        Button btn_color_change_1 = (Button) findViewById(R.id.btn_color_change_1);
        Button btn_color_change_2 = (Button) findViewById(R.id.btn_color_change_2);
        Button btn_color_change_3 = (Button) findViewById(R.id.btn_color_change_3);
        Button btn_text_default = (Button) findViewById(R.id.btn_text_default);
        text_color = (TextView) findViewById(R.id.text_color);
        Button pic_text = (Button) findViewById(R.id.pic_text);
        span_text = new SpannableString("嗨!我的朋友们");
        btn_text_default.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
//                TextView text_color = (TextView) findViewById(R.id.text_color);
                String text = "嗨!我的朋友们";
                text_color.setTextSize(45);
                text_color.setTextColor(Color.rgb(255,0,0));
                text_color.setText(text);
            }
        });

        btn_color_change_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
//                TextView text_color = (TextView) findViewById(R.id.text_color);
//                String text = "嗨!我的朋友们";
//                SpannableString span_text = new SpannableString(text);
                ForegroundColorSpan fcs = new ForegroundColorSpan(Color.parseColor("#0099EE"));
                span_text.setSpan(fcs,0,2, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                text_color.setTextSize(45);
                text_color.setText(span_text);
            }
        });
        btn_color_change_2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String text = "嗨!我的朋友们";
//                SpannableString span_text = new SpannableString(text);
//                Log.d(TAG, "onClick: BTN2click_1");
                BackgroundColorSpan bcs = new BackgroundColorSpan(Color.parseColor("#9999ff"));
//                Log.d(TAG, "onClick: BTN2click_2");
                span_text.setSpan(bcs,2,text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//                Log.d(TAG, "onClick: BTN2click_3");
                text_color.setText(span_text);
           }
        });
        btn_color_change_3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
//                TextView text_color = (TextView) findViewById(R.id.text_color);
//                String text = "嗨!我的朋友们";
//                SpannableString span_text = new SpannableString(text);
                StrikethroughSpan strikethroughspan = new StrikethroughSpan();
                span_text.setSpan(strikethroughspan,2,4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                text_color.setText(span_text);
            }
        });
        pic_text.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                SpannableString rightstring = new SpannableString("right");
                Drawable d = getResources().getDrawable(R.drawable.boy_head);
                d.setBounds(0,0,d.getIntrinsicWidth(),d.getIntrinsicHeight());
                ImageSpan imageSpan1 = new ImageSpan(d);
                rightstring.setSpan(imageSpan1,0,5,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                text_color.append(rightstring);
            }
        });
    }
}
