package com.example.gardeners_note;

public class Wish_record {
    private int id;
    private String wish_name;
    private String wish_note;

    public Wish_record(String wish_name, String wish_note) {
        this.wish_name = wish_name;
        this.wish_note = wish_note;
    }
    public Wish_record(int id, String wish_name, String wish_note) {
        this.id=id;
        this.wish_name = wish_name;
        this.wish_note = wish_note;
    }
    public Wish_record() {
    }
    public String getWish_name() {
        return wish_name;
    }
    public String getWish_note() {
        return wish_note;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setWish_note(String wish_note) {
        this.wish_note = wish_note;
    }
    public void setWish_name(String wish_name) {
        this.wish_name = wish_name;
    }
}

