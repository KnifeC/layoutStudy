package com.example.ckxgo.layoutstudy.StuaddPackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.ckxgo.layoutstudy.R;

import java.util.ArrayList;
import java.util.List;

import com.example.ckxgo.layoutstudy.StuaddPackage.Student;
/**
 * Created by ckxgo on 2018/11/17.
 */

public class StudentAdapter extends BaseAdapter {
    static boolean isdelete = false;
    private int resourceId;
    Context context;
    ArrayList<Student> stulist;

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return stulist.size();
    }

    @Override
    public Object getItem(int position) {
        return stulist.get(position);
    }

    public StudentAdapter(@NonNull Context context, int resource, @NonNull List<Student> objects) {
        resourceId = resource;
        this.context = context;
        stulist = (ArrayList<Student>)objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        isdelete = false;

        Student student = (Student) getItem(position);
        View view = LayoutInflater.from(context).inflate(resourceId,parent,false);
        ImageView stuhead = (ImageView) view.findViewById(R.id.studenticon);
        TextView stuname = (TextView) view.findViewById(R.id.studentname);
        TextView stunumber =(TextView) view.findViewById(R.id.studentnumber);
        TextView stumajor = (TextView) view.findViewById(R.id.studentmajor);
        TextView stusex = (TextView) view.findViewById(R.id.studentsex);
        ImageView gostuchange = (ImageView) view.findViewById(R.id.changestudent);
        ImageView gostudelete = (ImageView) view.findViewById(R.id.deletestudent);
        stuhead.setImageResource(student.getImageId());
        stuname.setText(student.getStuname());
        stunumber.setText(student.getStunumber());
        stumajor.setText(student.getStumajor());
        stusex.setText(student.getSex());
        gostuchange.setOnClickListener((v)->{
            Intent intent = new Intent(context,StuChangeActivity.class);
            intent.putExtra("StudentAdded",stulist);
            intent.putExtra("position",position);
            ((Activity)context).startActivityForResult(intent,1);
        });
        gostudelete.setOnClickListener((v)->{
            Intent intent = new Intent(context,StudentDeleteActivity.class);
            intent.putExtra("StudentAdded",stulist);
            intent.putExtra("position",position);
            ((Activity)context).startActivityForResult(intent,1);
        });
        return view;
    }
}
