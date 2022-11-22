package com.example.btgk;

public class Ca {
    int id;
    String tenkhoahoc;
    String tenthuonggoi;
    String dactinh;
    String mausac;
    String imageId;
    public Ca() {
    }

    public Ca(int id, String tenkhoahoc, String tenthuonggoi, String dactinh, String mausac, String imageId) {
        this.id = id;
        this.tenkhoahoc = tenkhoahoc;
        this.tenthuonggoi = tenthuonggoi;
        this.dactinh = dactinh;
        this.mausac= mausac;
        this.imageId = imageId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenkhoahoc() {
        return tenkhoahoc;
    }

    public void setTenkhoahoc(String tenkhoahoc) {
        this.tenkhoahoc = tenkhoahoc;
    }

    public String getTenthuonggoi() {
        return tenthuonggoi;
    }

    public void setTenthuonggoi(String tenthuonggoi) {
        this.tenthuonggoi = tenthuonggoi;
    }

    public String getDactinh() {
        return dactinh;
    }

    public void setDactinh(String dactinh) {
        this.dactinh = dactinh;
    }

    public String getMausac() {
        return mausac;
    }

    public void setMausac(String maula) {
        this.mausac = mausac;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

}
