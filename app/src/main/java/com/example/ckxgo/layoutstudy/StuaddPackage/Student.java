package com.example.ckxgo.layoutstudy.StuaddPackage;

/**
 * Created by ckxgo on 2018/11/17.
 */

public class Student {
    String stuname;
    int imageId;
    String stunumber;
    String stumajor;
    public Student(String stuname, int imageId, String stunumber, String stumajor) {
        this.stuname = stuname;
        this.imageId = imageId;
        this.stunumber = stunumber;
        this.stumajor = stumajor;
    }

    public String getStumajor() {
        return stumajor;
    }

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

}
