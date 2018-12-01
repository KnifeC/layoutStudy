package com.example.ckxgo.layoutstudy.StuaddPackage;

import java.io.Serializable;

/**
 * Created by ckxgo on 2018/11/17.
 */

public class Student implements Serializable {
    public Student(String stuname, int imageId, String stunumber, String stumajor, String sex) {
        this.stuname = stuname;
        this.imageId = imageId;
        this.stunumber = stunumber;
        this.stumajor = stumajor;
        this.sex = sex;
    }

    String stuname;
    int imageId;
    String stunumber;
    String stumajor;
    String sex;
    String class_;

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getStunumber() {
        return stunumber;
    }

    public void setStunumber(String stunumber) {
        this.stunumber = stunumber;
    }

    public String getStumajor() {
        return stumajor;
    }

    public void setStumajor(String stumajor) {
        this.stumajor = stumajor;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
