package com.example.attendance;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class viewAttendance extends AppCompatActivity {
    String year;
    String branch;
    String date;
    String subject;
    ArrayList<String> idList,nameList,statusList;
    ListView listView;
    databasehelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_attendance2);
        Intent intent=getIntent();
        idList=new ArrayList<>();
        nameList=new ArrayList<>();
        statusList=new ArrayList<>();
        year=intent.getStringExtra("year");
        branch=intent.getStringExtra("branch");
        date=intent.getStringExtra("date");
        subject=intent.getStringExtra("subject");
        mydb=new databasehelper(this);
        listView=findViewById(R.id.listview);
      //  Toast.makeText(getApplicationContext(),date,Toast.LENGTH_SHORT).show();
       Cursor cursor=mydb.showAttendance(year,branch,date,subject);
        if(cursor.getCount()==0) {
            Toast.makeText(viewAttendance.this, "no data to show", Toast.LENGTH_LONG).show();
        }
        else
        {
            if(cursor.moveToFirst()){
                do{
                    // nameList.add("akshat" ) ;

                   nameList.add(cursor.getString(cursor.getColumnIndex("FIRST_NAME")) + "    " + cursor.getString(cursor.getColumnIndex("LAST_NAME")));
                   idList.add(cursor.getString(cursor.getColumnIndex("STUDENT_ID")));
                   statusList.add(cursor.getString(cursor.getColumnIndex("STATUS")));
                } while(cursor.moveToNext());

            }
           CustomAdapter2 adapter = new CustomAdapter2(this,nameList,idList,statusList);
            listView.setAdapter(adapter);
        }




    }
}