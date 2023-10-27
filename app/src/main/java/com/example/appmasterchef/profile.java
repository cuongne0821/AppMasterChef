package com.example.appmasterchef;

public class profile {
    private String Ten;
    private String Msv;
    private int Hinh;

    public profile(String ten, int hinh, String msv) {
        Ten = ten;
        Hinh = hinh;
        Msv=msv;
    }

    public String getMsv() {
        return Msv;
    }

    public void setMsv(String msv) {
        Msv = msv;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }
}