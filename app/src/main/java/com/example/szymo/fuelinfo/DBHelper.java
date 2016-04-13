package com.example.szymo.fuelinfo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context){
        super(context,"FuelApp3.db", null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table roads(" +
                "id integer primary key autoincrement," +
                "km text," +
                "ill text," +
                "avgUsage text," +
                "unitPrice text," +
                "totalPrice text," +
                "date text);" +
                "");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void addRoad(Road road){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("km", road.getKm());
        contentValues.put("ill", road.getIll());
        contentValues.put("avgUsage", road.getAvgUsage());
        contentValues.put("unitPrice", road.getUnitPrice());
        contentValues.put("totalPrice", road.getTotalPrice());
        contentValues.put("date", road.getDate());
        db.insertOrThrow("roads",null,contentValues);
    }

    public LinkedList<Road> getAll(){
        LinkedList<Road> roads = new LinkedList<Road>();
        String [] fields={"id","km","ill","avgUsage","unitPrice","totalPrice","date"};
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("roads",fields,null,null,null,null,null,null);
        while(cursor.moveToNext()){
            Road road = new Road();
            road.setId(cursor.getLong(0));
            road.setKm(cursor.getString(1));
            road.setIll(cursor.getString(2));
            road.setAvgUsage(cursor.getString(3));
            road.setUnitPrice(cursor.getString(4));
            road.setTotalPrice(cursor.getString(5));
            road.setDate(cursor.getString(6));
            roads.add(road);
        }

        return roads;
    }
}
