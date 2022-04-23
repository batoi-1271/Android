package com.example.qlvattu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DTBvt extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "QLVatTu.db";
    public static final String TABLE_NAME = "tbVatTu";

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String UNIT = "unit";
    public static final String PRICE = "price";
    public static final String MANU = "manu";

    private static int VERSION = 1;
    private  Context context;

    public DTBvt(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String slqQuery = "CREATE TABLE "+TABLE_NAME+ "("
                +ID + " String primary key, "
                +NAME+ " Text, "
                +UNIT + " Text, "
                +PRICE + " Integer, "
                +MANU + " Text ) ";
        db.execSQL(slqQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void  addVT(vatTu vt) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID, vt.getId());
        values.put(NAME, vt.getName());
        values.put(UNIT, vt.getUnit());
        values.put(PRICE, vt.getPrice());
        values.put(MANU, vt.getManu());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public  int updateVT(vatTu vt) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, vt.getName());
        values.put(UNIT, vt.getUnit());
        values.put(PRICE, vt.getPrice());
        values.put(MANU, vt.getManu());
        int a = db.update(TABLE_NAME, values, ID +"=? ", new String[] {
                String.valueOf(vt.getId())
        });
        return a;
    }

    public int deleteVT(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        int b = db.delete(TABLE_NAME, ID +"=? ", new String[] {
                String.valueOf(id)
        });
        db.close();
        return b;
    }
    public List<vatTu> ThongtinSV() {
        List<vatTu> listVT = new ArrayList<vatTu>();
        SQLiteDatabase db = this.getReadableDatabase();

        String sqlQuery = "SELECT * FROM " +TABLE_NAME;
        Cursor cursor = db.rawQuery(sqlQuery, null);
        if (cursor.moveToFirst()) {
            do {
                vatTu sv = new vatTu();
//                cursor.getInt(0);
                sv.setId(cursor.getString(0));
                sv.setName(cursor.getString(1));
                sv.setUnit(cursor.getString(2));
                sv.setManu(cursor.getString(3));
                sv.setPrice(cursor.getInt(4));

                listVT.add(sv);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listVT;
    }

    public vatTu searchID(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[] {
                ID, NAME, UNIT, PRICE, MANU
        }, ID + "= ?", new String[]{
                String.valueOf(id)
        }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        vatTu sv = new vatTu(cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getInt(4));
        cursor.close();
        db.close();
        return sv;
    }
}
