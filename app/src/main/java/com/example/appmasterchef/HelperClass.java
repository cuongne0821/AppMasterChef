package com.example.appmasterchef;

public class HelperClass {
    String name,password,password1;

    public HelperClass(String name, String password, String password1) {
        this.name = name;
        this.password = password;
        this.password1 = password1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password= password;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }
}