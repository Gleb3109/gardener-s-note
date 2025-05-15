package com.example.gardeners_note;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MyDatabase1.db";
    private static final int DATABASE_VERSION = 1;
    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Создание таблицы
        String createTableQuery = "CREATE TABLE IF NOT EXISTS calendar_record (day INTEGER,month INTEGER,year INTEGER, record TEXT, PRIMARY KEY(day,month,year));";
        db.execSQL(createTableQuery);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Обновление таблицы (если необходимо)
    }
}

