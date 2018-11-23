package com.example.ckxgo.layoutstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class PicChange extends AppCompatActivity implements View.OnClickListener,ViewSwitcher.ViewFactory{
    ImageSwitcher imageSwitcher;
    Button picchange_gonext;
    Button picchange_gopre;
    int image_resource[] = {R.drawable.capturingcolors,R.drawable.thelostworld,R.drawable.starman,R.drawable.mipha};
    int imageIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_change);
        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);
        picchange_gonext = (Button) findViewById(R.id.picchange_gonext);
        picchange_gopre = (Button) findViewById(R.id.picchange_gopre);
        imageSwitcher.setFactory(this);
        imageSwitcher.setImageResource(image_resource[imageIndex]);
        picchange_gonext.setOnClickListener(this);
        picchange_gopre.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.picchange_gonext:
                if(imageIndex==image_resource.length-1){
                    imageIndex = 0;
                }else {
                    imageIndex++;
                }
                imageSwitcher.setInAnimation(this,android.R.anim.fade_in);
                imageSwitcher.setOutAnimation(this,android.R.anim.fade_out);
                imageSwitcher.setOutAnimation(this,android.R.anim.slide_out_right);
                imageSwitcher.setInAnimation(this,android.R.anim.slide_in_left);
                imageSwitcher.setImageResource(image_resource[imageIndex]);
                break;
            case R.id.picchange_gopre:
                if(imageIndex==0){
                    imageIndex = image_resource.length-1;
                }else {
                    imageIndex--;
                }
                imageSwitcher.setInAnimation(this,android.R.anim.fade_in);
                imageSwitcher.setOutAnimation(this,android.R.anim.fade_out);
                imageSwitcher.setOutAnimation(this,R.anim.slide_out_left);
                imageSwitcher.setInAnimation(this,R.anim.slide_in_right);
                imageSwitcher.setImageResource(image_resource[imageIndex]);
                break;
        }
    }

    @Override
    public View makeView() {
        ImageView imageView = new ImageView(this);
        return imageView;
    }
}
