package com.example.mylibrary;

public class User {
    public String id;
    public String pwd;
    public String name;
    public String classes;
    public int seat;

    public void setId(String id) {
        this.id = id;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setClass(String classes) {
        this.classes = classes;
    }
    public void setSeat(int seat) {
        this.seat = seat;
    }


    public String getID() {
        return id;
    }
    public String getPwd() {
        return pwd;
    }
    public String getName() {
        return name;
    }
    public String getClasses() {
        return classes;
    }
    public int getSeat() {
        return seat;
    }
}
