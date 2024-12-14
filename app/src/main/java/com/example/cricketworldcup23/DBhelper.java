package com.example.cricketworldcup23;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBhelper extends SQLiteOpenHelper {
    public DBhelper(Context context) {
        super(context, "Userdata.db", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Userdetails(name Text,email Text ,password Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public Boolean insertuserdata(String name, String email, String password)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("password", password);
        long result=DB.insert("Userdetails", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }
    boolean checkMail(String mail){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor c = MyDB.rawQuery("Select * from Userdetails where email=?",new String[] {mail});
        if(c.getCount()>0)
            return true;
        else
            return false;
    }
    boolean checkMailPass(String mail,String pass){
        SQLiteDatabase myDb = this.getWritableDatabase();
        Cursor c = myDb.rawQuery("select * from Userdetails where email=? and password=?",new String[] {mail,pass});
        if(c.getCount()>0)
            return true;
        else
            return false;
    }
    String passName(String mail){
        SQLiteDatabase myDb = this.getWritableDatabase();
        Cursor s=myDb.rawQuery("select name from Userdetails where email=?",new String[] {mail});
        String nam = "sam";
        if(s.moveToFirst()){
            nam=s.getString(0);
        }
        return  nam;
    }
}
