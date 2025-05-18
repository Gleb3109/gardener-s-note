package com.example.gardeners_note;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class Ornamental_factory {
    Context mContext;

    public Ornamental_factory(Context aContext) {
        mContext = aContext;
    }
    public void add(OrnamentalGarden_record ornament) {
        Log.d("myTag", "OrnamentalGarden_record " + ornament.getOrnamental_type().getTitle());
        Database databaseHelper = new Database(mContext);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("ornamental_type", ornament.getOrnamental_type().ordinal());
        cv.put("ornamental_name", ornament.getOrnamental_name());
        cv.put("ornamental_note", ornament.getOrnamental_note());
        long newRowId = db.insert("ornamentalGarden_record", null, cv);
        Log.d("myTag", "newRowId " + newRowId);
        db.close();
    }
    public ArrayList<OrnamentalGarden_record> getAll() {
        ArrayList<OrnamentalGarden_record> mOrnamentals = new ArrayList<>();
        String[] projection = {"id", "ornamental_type", "ornamental_name","ornamental_note"};
        Database databaseHelper = new Database(mContext);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        Cursor cursor = db.query("ornamentalGarden_record", projection, null,null, null, null, null);
        Log.d("myTag", "OrnamentalGarden_cursor " + cursor.getCount());
        while (cursor.moveToNext()) {
            int idd = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            int iType = cursor.getInt(cursor.getColumnIndexOrThrow("ornamental_type"));
            String oornamental_name = cursor.getString(cursor.getColumnIndexOrThrow("ornamental_name"));
            String oornamental_note = cursor.getString(cursor.getColumnIndexOrThrow("ornamental_note"));
            OrnamentalGarden_record ogr = new OrnamentalGarden_record(idd, oornamental_name, oornamental_note,iType);
            mOrnamentals.add(ogr);
        }
        db.close();
        return mOrnamentals;
    }

    public void delete(int a_id) {
        Log.d("myTag", "a_id " + a_id);
        Database databaseHelper = new Database(mContext);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        long newRowId = db.delete("ornamentalGarden_record",  "id=?", new String[]{String.valueOf(a_id)});
        Log.d("myTag", "newRowId " + newRowId);
        db.close();
    }
}
