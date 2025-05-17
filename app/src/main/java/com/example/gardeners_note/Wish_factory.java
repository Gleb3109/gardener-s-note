package com.example.gardeners_note;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class Wish_factory {
    Context mContext;

    public Wish_factory(Context aContext) {
        mContext = aContext;
    }

    public void add(Wish_record a_record) {
        Database databaseHelper = new Database(mContext);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
      //  cv.put("id", a_record.getId());
        cv.put("wish_name", a_record.getWish_name());
        cv.put("wish_note", a_record.getWish_note());
        long newRowId = db.insert("wish_record", null, cv);
        db.close();
    }

    public ArrayList<Wish_record> getAll() {
        ArrayList<Wish_record> mWish = new ArrayList<>();
        String[] projection = {"id", "wish_name", "wish_note"};
        Database databaseHelper = new Database(mContext);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        Cursor cursor = db.query("wish_record", projection, null,null, null, null, null);
        Log.d("myTag", "Wishes_cursor " + cursor.getCount());
        while (cursor.moveToNext()) {
            int idd = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            String wwish_name = cursor.getString(cursor.getColumnIndexOrThrow("wish_name"));
            String wwish_note = cursor.getString(cursor.getColumnIndexOrThrow("wish_note"));
            Wish_record wish = new Wish_record(idd, wwish_name, wwish_note);
            mWish.add(wish);
        }
        db.close();
        return mWish;
    }
    public void delete(int a_id) {
        Database databaseHelper = new Database(mContext);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        long newRowId = db.delete("wish_record",  "id=?", new String[]{String.valueOf(a_id)});
        db.close();
    }

}
