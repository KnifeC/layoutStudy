package com.example.ckxgo.layoutstudy.StuaddPackage;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ckxgo.layoutstudy.R;

import java.util.List;

/**
 * Created by ckxgo on 2018/11/17.
 */

public class StudentAdapter<String> extends ArrayAdapter<Student> {

    private int resourceId;
    public StudentAdapter(@NonNull Context context, int resource, @NonNull List<Student> objects) {
        super(context, resource, objects);
        resourceId = resource;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Student student = getItem(position);
        super.getView(position, convertView, parent);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        ImageView stuhead = (ImageView) view.findViewById(R.id.studenticon);
        TextView stuname = (TextView) view.findViewById(R.id.studentname);
        TextView stunumber =(TextView) view.findViewById(R.id.studentnumber);
        stuhead.setImageResource(student.getImageId());
        stuname.setText(student.getStuname());
        stunumber.setText(student.getStunumber());
        return view;
    }
}
