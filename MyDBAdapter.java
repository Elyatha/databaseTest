package com.example.databasetest;

/**
 * Created by العالمية on 08/08/16.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBAdabter extends SQLiteOpenHelper{
    public static final String database_name = "StudentDB.db";
    public static final String table_name = "Student_table";
    public static final String col1 = "ID";
    public static final String col2 = "name";
    public static final String col3 = "Last_name";
    public static final String col4 = "Marks";
    SQLiteDatabase DB = this.getWritableDatabase();
    public MyDBAdabter(Context context) {
        super(context, database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table"+table_name+"ID INTEGER PRIMARY KEY AUTOINQREMENT," +
                "name text, Last_name text, Marks integer");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists"+table_name);
        onCreate(db);
    }

    public boolean insertCol(String name, String ID, String mark){
        ContentValues values = new ContentValues();
        values.put(col1, ID);
        values.put(col2, name);
        values.put(col4, mark);

//        long result = db.insert(table_name, null, values);
//            if(result == -1)
//                return false;
//            else
                return true;

    }
}
