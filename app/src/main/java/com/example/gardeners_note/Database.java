package com.example.gardeners_note;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MyDatabase13.db";
    private static final int DATABASE_VERSION = 1;
    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Создание таблицы
        String createTableCalendar = "CREATE TABLE IF NOT EXISTS calendar_record (day INTEGER,month INTEGER,year INTEGER, record TEXT, PRIMARY KEY(day,month,year));";
        db.execSQL(createTableCalendar);
        String createTableWish = "CREATE TABLE IF NOT EXISTS wish_record (id INTEGER,wish_name TEXT, wish_note TEXT, PRIMARY KEY(id AUTOINCREMENT));";
        db.execSQL(createTableWish);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Обновление таблицы (если необходимо)
    }
}

