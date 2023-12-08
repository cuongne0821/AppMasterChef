package com.example.appmasterchef;


public class Mydata {

        private String  Name;
        private String Image, HD,Nguyenlieu, Danhmuc;



        Mydata(){}

    public Mydata(String name, String image, String HD, String nguyenlieu, String danhmuc) {
        Name = name;
        Image = image;
        this.HD = HD;
        Nguyenlieu = nguyenlieu;
        Danhmuc = danhmuc;
    }

    public String getDanhmuc() {
        return Danhmuc;
    }

    public void setDanhmuc(String danhmuc) {
        Danhmuc = danhmuc;
    }

    public String getHD() {
        return HD;
    }

    public void setHD(String HD) {
        this.HD = HD;
    }

    public String getNguyenlieu() {
        return Nguyenlieu;
    }

    public void setNguyenlieu(String nguyenlieu) {
        Nguyenlieu = nguyenlieu;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}

