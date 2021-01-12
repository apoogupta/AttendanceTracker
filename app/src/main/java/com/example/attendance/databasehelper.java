package com.example.attendance;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class databasehelper extends SQLiteOpenHelper {
    public static final String database_name = "attendance.db";


    public static final String table_name = "addfaculty";
    public static final String col_1 = "FIRST_NAME";
    public static final String col_2 = "LAST_NAME";
    public static final String col_3 = "ADDRESS";
    public static final String col_4 = "MOBILE_NO";
    public static final String col_5 = "USERNAME";
    public static final String col_6 = "PASSWORD";
    public static final String col_7 = "SUBJECT";


    public static final String table_name2 = "addstudent";
    public static final String col2_0 = "STUDENT_ID";
    public static final String col2_1 = "FIRST_NAME";
    public static final String col2_2 = "LAST_NAME";
    public static final String col2_3 = "ADDRESS";
    public static final String col2_4 = "MOBILE_NO";
    public static final String col2_5 = "BRANCH";
    public static final String col2_6 = "YEAR";

    public static final String table_name3 = "addAttendance";
    public static final String col3_0 = "STUDENT_ID";
    public static final String col3_1 = "DATE";
    public static final String col3_2 = "BRANCH";
    public static final String col3_3 = "YEAR";
    public static final String col3_4 = "SUBJECT";
    public static final String col3_5= "STATUS";


    public databasehelper(@Nullable Context context) {
        super(context, database_name, null, 5);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( "create table " + table_name + " (FIRST_NAME TEXT,LAST_NAME TEXT,ADDRESS TEXT,MOBILE_NO INTEGER,USERNAME TEXT,PASSWORD TEXT,SUBJECT TEXT )");
        db.execSQL("create table " + table_name2 + " (STUDENT_ID INTEGER PRIMARY KEY AUTOINCREMENT,FIRST_NAME TEXT,LAST_NAME TEXT,ADDRESS TEXT,MOBILE_NO INTEGER,BRANCH TEXT,YEAR TEXT )");
        db.execSQL( "create table " + table_name3 + " (STUDENT_ID TEXT,DATE TEXT, BRANCH TEXT,YEAR TEXT,SUBJECT TEXT,STATUS TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + table_name);
        db.execSQL("DROP TABLE IF EXISTS " + table_name2);
        db.execSQL("DROP TABLE IF EXISTS " + table_name3);
        onCreate(db);
    }


    public boolean insertfacultydata(String first_name, String last_name, String address, String mob_no, String username, String password ,String subject) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_1, first_name);
        contentValues.put(col_2, last_name);
        contentValues.put(col_3, address);
        contentValues.put(col_4, mob_no);
        contentValues.put(col_5, username);
        contentValues.put(col_6, password);
        contentValues.put(col_7, subject);

        long result = db.insert(table_name, null, contentValues);
        if (result == -1 )
            return false;
        else
            return true;


    }
    public boolean insertstudentdata(String first_name, String last_name, String address, String mob_no, String branch, String year) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col2_1, first_name);
        contentValues.put(col2_2, last_name);
        contentValues.put(col2_3, address);
        contentValues.put(col2_4, mob_no);
        contentValues.put(col2_5, branch);
        contentValues.put(col2_6, year);
        long result2 = db.insert(table_name2, null, contentValues);
        if (result2 == -1)
            return false;
        else
            return true;
    }

    public Cursor getalldata() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + table_name, null);
        return res;
    }
    public Cursor showstudent(String year,String branch)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + table_name2 +" WHERE YEAR=? AND BRANCH=? ",new String[]{year,branch} );
        return res;

    }


    public boolean checklogin(String username, String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("Select * from " + table_name + " WHERE USERNAME=? AND PASSWORD=?", new String[]{username,password});
        if (res != null) {
            if(res.getCount() > 0)
            {
                return true;
            }
        }
        return false;
    }

    public boolean insertAttendance(String id,String datee,String branch,String year, String subject,String status) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col3_0, id);
        contentValues.put(col3_1, datee);
        contentValues.put(col3_2, branch);
        contentValues.put(col3_3, year);
        contentValues.put(col3_4, subject);
        contentValues.put(col3_5, status);
        long result2 = db.insert(table_name3, null, contentValues);
        if (result2 == -1)
            return false;
        else
            return true;
    }

    public Cursor showAttendance(String year, String branch, String date, String subject) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from addAttendance b INNER JOIN addstudent  a ON a.STUDENT_ID=b.STUDENT_ID WHERE (a.YEAR=? AND a.BRANCH=?) AND (b.SUBJECT=? AND b.DATE=?)"  ,new String[]{year,branch,subject,date} );
        return res;
    }
}

