package com.example.ckxgo.layoutstudy;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.SeekBar;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

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
                int ivHeight = progress * 3 / 4;
                http_picture.setLayoutParams(new LinearLayout.LayoutParams(ivWidth, ivHeight));
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
                float d = progress;
                matrix.setRotate(d);
//                http_picture.setDrawingCacheEnabled(true);
//                Bitmap bitmap=http_picture.getDrawingCache();
//                http_picture.setDrawingCacheEnabled(false);
                Bitmap bitmap = ((BitmapDrawable)http_picture.getDrawable()).getBitmap();
                Bitmap bitmap1 = bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                http_picture.setImageBitmap(bitmap1);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        RadioButton pic1 = (RadioButton) findViewById(R.id.picchoose_1);
        RadioButton pic2 = (RadioButton) findViewById(R.id.picchoose_2);
        RadioButton pic3 = (RadioButton) findViewById(R.id.picchoose_3);
        RadioButton pic4 = (RadioButton) findViewById(R.id.picchoose_4);
        pic1.setOnClickListener((v)->{
            GetHTTPPic httpPic = new GetHTTPPic(0);
            Thread th = new Thread(httpPic);
            th.start();
            http_picture.setImageBitmap(BitmapFactory.decodeByteArray(httpPic.picbitmap,0,httpPic.picbitmap.length));
        });
        pic2.setOnClickListener((v)->{
            GetHTTPPic httpPic = new GetHTTPPic(1);
            Thread th = new Thread(httpPic);
            th.start();
            http_picture.setImageBitmap(BitmapFactory.decodeByteArray(httpPic.picbitmap,0,httpPic.picbitmap.length));
        });
        pic3.setOnClickListener((v)->{
            GetHTTPPic httpPic = new GetHTTPPic(2);
            Thread th = new Thread(httpPic);
            th.start();
            http_picture.setImageBitmap(BitmapFactory.decodeByteArray(httpPic.picbitmap,0,httpPic.picbitmap.length));
        });
        pic4.setOnClickListener((v)->{
            GetHTTPPic httpPic = new GetHTTPPic(3);
            Thread th = new Thread(httpPic);
            th.start();
            http_picture.setImageBitmap(BitmapFactory.decodeByteArray(httpPic.picbitmap,0,httpPic.picbitmap.length));
        });
    }
}
class GetHTTPPic implements Runnable {
    byte[] picbitmap;
    int urlnum;
    String[] picurl = {"https://raw.githubusercontent.com/KnifeC/image/master/head_pic.png",
            "https://i.loli.net/2018/11/13/5beabbcbe4f23.png",
            "https://i.loli.net/2018/11/13/5beabc36b76a9.png",
            "https://i.loli.net/2018/11/13/5beabc7cdc8a1.png"};

    public GetHTTPPic(int i) {
        this.urlnum = i;
        picbitmap = new byte[4096];
    }

    private byte[] downImage() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();//定义一个输出字节流
        try {
            URL url = new URL(picurl[urlnum]);
            //获得HTTP的连接对象，通过URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //设置连接超时
            connection.setConnectTimeout(5000);
            //设置能获取服务器的响应内容
            connection.setDoInput(true);
            //设置http的响应方式
            connection.setRequestMethod("GET");
            //发起请求//获取响应码状态
            int code = connection.getResponseCode();
            if (code == 200) {//表示获取成功
                //获得输入的流
                InputStream is = connection.getInputStream();
                byte[] d = new byte[4096];
                int len;// 确定读入数据的长度
                while ((len = is.read(d)) != -1) {
                    os.write(d, 0, len);//循环写入到输出流，直到长度为-1
                }
                return os.toByteArray();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void run() {
        picbitmap = downImage();
    }
}
