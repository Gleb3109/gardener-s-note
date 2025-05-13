package com.example.gardeners_note;

public class Calendar_record {
    private int day;
    private int month;
    private int year;
    private String record;
    public Calendar_record() {

    }
    public Calendar_record(int day, int month, int year, String record) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.record = record;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getRecord() {
        return record;
    }
}
