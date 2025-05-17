package com.example.gardeners_note;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public  class Record_factory {
     Context mContext;
    public Record_factory(Context aContext){
        mContext=aContext;
    }
    public  void add(Calendar_record a_record) {
        Database databaseHelper = new Database(mContext);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("day", a_record.getDay());
        cv.put("month", a_record.getMonth());
        cv.put("year", a_record.getYear());
        cv.put("record", a_record.getRecord());
        long newRowId = db.insert("calendar_record", null, cv);
        db.close();
    }
    public  void edit(Calendar_record a_record) {
        Database databaseHelper = new Database(mContext);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("day", a_record.getDay());
        cv.put("month", a_record.getMonth());
        cv.put("year", a_record.getYear());
        cv.put("record", a_record.getRecord());
        long newRowId = db.update("calendar_record", cv, "day=? and  month=? and year=?", new String[]{String.valueOf(a_record.getDay()),
                String.valueOf(a_record.getMonth()),
                String.valueOf(a_record.getYear())});
        db.close();
    }
    public  void delate(Calendar_record a_record) {
        Database databaseHelper = new Database(mContext);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        long newRowId = db.delete("calendar_record",  "day=? and month=? and year=?", new String[]{String.valueOf(a_record.getDay()),
                String.valueOf(a_record.getMonth()),
                String.valueOf(a_record.getYear())});
        db.close();
    }
    public ArrayList <Calendar_record> getAll(){
        ArrayList<Calendar_record> mDates = new ArrayList<Calendar_record>();
        String[] projection = {"day", "month","year","record"};
        Database databaseHelper = new Database(mContext);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        Cursor cursor = db.query("calendar_record", projection, null,null, null, null, null);
        Log.d("myTag","getAll " + cursor.getCount());
        while (cursor.moveToNext()) {
            int day = cursor.getInt(cursor.getColumnIndexOrThrow("day"));
            int mmonth = cursor.getInt(cursor.getColumnIndexOrThrow("month"));
            int yyear = cursor.getInt(cursor.getColumnIndexOrThrow("year"));
            String record = cursor.getString(cursor.getColumnIndexOrThrow("record"));
            Calendar_record cr=new Calendar_record(day, mmonth,yyear,record);
            mDates.add(cr);
        }
        db.close();
        return  mDates;
    }
    public  Calendar_record get(int day, int month, int year)  {
        Calendar_record cr=new Calendar_record();
        String[] projection = {"day", "month","year","record"};
        Database databaseHelper = new Database(mContext);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        Cursor cursor = db.query("calendar_record", projection, "day=? and month=? and year=?", new String[]{
                String.valueOf(day),
                String.valueOf(month),
                String.valueOf(year)}, null, null, null);
        while (cursor.moveToNext()) {
            int dday = cursor.getInt(cursor.getColumnIndexOrThrow("day"));
            int mmonth = cursor.getInt(cursor.getColumnIndexOrThrow("month"));
            int yyear = cursor.getInt(cursor.getColumnIndexOrThrow("year"));
            String record = cursor.getString(cursor.getColumnIndexOrThrow("record"));
            cr.setDay(dday);
            cr.setMonth(mmonth);
            cr.setYear(yyear);
            cr.setRecord(record);
        }
        db.close();
        return cr;
    }
    public static class db {

        public static void main(String[] args) throws ClassNotFoundException, SQLException {
            conn.Conn();
            //conn.CreateDB();
            //conn.WriteDB();
            //conn.ReadDB();
            conn.CloseDB();
        }
    }

    public static class conn {
        public static Connection conn;
        public static Statement statmt;
        public static ResultSet resSet;

        // --------ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ--------
        public static void Conn() throws ClassNotFoundException, SQLException {
            conn = null;
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:gardeners_note.db");

            System.out.println("База Подключена!");
        }

        // --------Закрытие--------
        public static void CloseDB() throws ClassNotFoundException, SQLException
        {
            conn.close();
            statmt.close();
            resSet.close();

            System.out.println("Соединения закрыты");
        }

    }

}
