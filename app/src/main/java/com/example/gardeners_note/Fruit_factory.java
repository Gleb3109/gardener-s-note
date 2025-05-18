package com.example.gardeners_note;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class Fruit_factory {
    Context mContext;

    public Fruit_factory(Context aContext) {
        mContext = aContext;
    }
    public void add(FruitGarden_record fruit) {
        Log.d("myTag", "FruitGarden_record " + fruit.getFruit_type().getTitle());
        Database databaseHelper = new Database(mContext);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("fruit_type", fruit.getFruit_type().ordinal());
        cv.put("fruit_name", fruit.getFruit_name());
        cv.put("fruit_note", fruit.getFruit_note());
        cv.put("variety", fruit.getVariety());
        long newRowId = db.insert("fruitGarden_record", null, cv);
        Log.d("myTag", "newRowId " + newRowId);
        db.close();
    }
    public ArrayList<FruitGarden_record> getAll() {
        ArrayList<FruitGarden_record> mFruit = new ArrayList<>();
        String[] projection = {"id", "fruit_type", "fruit_name","fruit_note", "variety"};
        Database databaseHelper = new Database(mContext);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        Cursor cursor = db.query("fruitGarden_record", projection, null,null, null, null, null, null);
        Log.d("myTag", "FruitGarden_cursor " + cursor.getCount());
        while (cursor.moveToNext()) {
            int idd = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            int iType = cursor.getInt(cursor.getColumnIndexOrThrow("fruit_type"));
            String ffruit_name = cursor.getString(cursor.getColumnIndexOrThrow("fruit_name"));
            String ffruit_note = cursor.getString(cursor.getColumnIndexOrThrow("fruit_note"));
            String vvariety = cursor.getString(cursor.getColumnIndexOrThrow("variety"));
            FruitGarden_record ogr = new FruitGarden_record(idd, ffruit_name, ffruit_note,iType, vvariety);
            mFruit.add(ogr);
        }
        db.close();
        return mFruit;
    }

    public void delete(int a_id) {
        Log.d("myTag", "a_id " + a_id);
        Database databaseHelper = new Database(mContext);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        long newRowId = db.delete("fruitGarden_record",  "id=?", new String[]{String.valueOf(a_id)});
        Log.d("myTag", "newRowId " + newRowId);
        db.close();
    }
}
