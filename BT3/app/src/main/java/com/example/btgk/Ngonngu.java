package com.example.btgk;

public class Ngonngu {
    int id;
    String tenngonngu;
    int icon;

    public Ngonngu(int id, String tenngonngu, int icon) {
        this.id = id;
        this.tenngonngu = tenngonngu;
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenngonngu() {
        return tenngonngu;
    }

    public void setTenngonngu(String tenngonngu) {
        this.tenngonngu = tenngonngu;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}