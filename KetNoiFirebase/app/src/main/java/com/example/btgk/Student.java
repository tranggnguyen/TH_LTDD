package com.example.btgk;

public class Student {
    int id;
    String msv;
    String name;
    String classStudent;
    String imageId;

    public Student(int id, String msv, String name, String classStudent, String imageId) {
        this.id = id;
        this.msv = msv;
        this.name = name;
        this.classStudent = classStudent;
        this.imageId = imageId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsv() {
        return msv;
    }

    public void setMsv(String msv) {
        this.msv = msv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassStudent() {
        return classStudent;
    }

    public void setClassStudent(String classStudent) {
        this.classStudent = classStudent;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }
}
