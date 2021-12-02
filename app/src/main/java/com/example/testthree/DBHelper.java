package com.example.testthree;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteAbortException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final String dbName="studentdb";
    private static final String tbName="student" ;
    private static final int dbVersion = 1 ;
    public DBHelper(@Nullable Context context,
                    @Nullable String name,
                    @Nullable SQLiteDatabase.CursorFactory factory,
                    int version) {
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+tbName+
                "(uname VARCHAR(10),passw VARCHAR(10))"+";");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+tbName);
        onCreate(db);
    }

    public long adduser(String name, String pass){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues cv = new ContentValues() ;
        cv.put("uname", name);
        cv.put("passw ",pass) ;
        long result = sqLiteDatabase.insert(
                tbName, null,cv);
        sqLiteDatabase.close();

        return result ;
    }

    public void delete(String name){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.execSQL("DELETE FROM "+tbName+" WHERE uname='"
                +name+"';" );
        sqLiteDatabase.close();
    }

    public void update(String name, String pass){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.execSQL("UPDATE "+tbName+ " " +
                "set uname='"+name+"',"+"passw='"+pass+"';");
        sqLiteDatabase.close();
    }

    public String display(Context ctx){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(
                "SELECT * FROM "+tbName, null
        );

        String finalres = " " ;
        while(cursor.moveToNext()){
            finalres += cursor.getString(0)+":"+cursor.getString(1);
        }

        return finalres;
    }


}
