package com.example.gardeners_note;

public class Calendar_record {
    private int day;
    private int month;
    private int year;
    private String record;
    public boolean isEmpty=true;
    public Calendar_record() {

    }
    public Calendar_record(int day, int month, int year, String record) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.record = record;
        this.isEmpty=false;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
        this.isEmpty=false;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
        this.isEmpty=false;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
        this.isEmpty=false;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
        this.isEmpty=false;
    }
}
