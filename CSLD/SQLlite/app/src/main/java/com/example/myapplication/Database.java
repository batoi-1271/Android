package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "QLSinhVien.db";
    public static final String TABLE_NAME = "tbSinhvien";

    public static final String ID = "id";
    public static final String NAME = "hoten";
    public static final String CLASS = "lop";
    public static final String ADDRESS = "diachi";
    public static final String PHONE = "sdt";

    private static int VERSION = 1;
    private  Context context;
    //CONSTRUCTOR
    public Database(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
    }

    // CREATE TABLE
    @Override
    public void onCreate(SQLiteDatabase db) {
        String slqQuery = "CREATE TABLE "+TABLE_NAME+ "("
                +ID + " integer primary key autoincrement, "
                +NAME+ " Text, "
                +CLASS + " Text, "
                +ADDRESS + " Text, "
                +PHONE + " Text ) ";
        db.execSQL(slqQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void  addSV(SinhVien sv) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, sv.getHoten());
        values.put(CLASS, sv.getLop());
        values.put(ADDRESS, sv.getDiachi());
        values.put(PHONE, sv.getSdt());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public  int updateSV(SinhVien sv) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, sv.getHoten());
        values.put(CLASS, sv.getLop());
        values.put(ADDRESS, sv.getDiachi());
        values.put(PHONE, sv.getSdt());
        int a = db.update(TABLE_NAME, values, ID +"=? ", new String[] {
                String.valueOf(sv.getId())
        });
        return a;
    }

    public int deleteSV (int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        int b = db.delete(TABLE_NAME, ID +"=? ", new String[] {
                String.valueOf(id)
        });
        db.close();
        return b;
    }

    public List<SinhVien> ThongtinSV() {
        List<SinhVien> listSV = new ArrayList<SinhVien>();
        SQLiteDatabase db = this.getReadableDatabase();

        String sqlQuery = "SELECT * FROM " +TABLE_NAME;
        Cursor cursor = db.rawQuery(sqlQuery, null);
        if (cursor.moveToFirst()) {
            do {
                SinhVien sv = new SinhVien();
//                cursor.getInt(0);
                sv.setId(Integer.parseInt(cursor.getString(0)));
                sv.setHoten(cursor.getString(1));
                sv.setLop(cursor.getString(2));
                sv.setDiachi(cursor.getString(3));
                sv.setSdt(cursor.getString(4));

                listSV.add(sv);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listSV;
    }

    public SinhVien searchID(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[] {
                ID, NAME, CLASS, ADDRESS, PHONE
        }, ID + "= ?", new String[]{
                String.valueOf(id)
        }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
            SinhVien sv = new SinhVien(cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4));
            cursor.close();
            db.close();
        return sv;
    }
}
