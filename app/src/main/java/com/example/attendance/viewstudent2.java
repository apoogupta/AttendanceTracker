package com.example.attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class viewstudent2 extends AppCompatActivity {
    databasehelper myDb;
    ArrayList<String> listitem1;
    ArrayAdapter adapter;
    ListView userlist;
    String year;
    String branch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewstudent2);
        myDb=new databasehelper(this);
        listitem1=new ArrayList<>();
        viewdata();
        userlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(viewstudent2.this,""+view,Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void viewdata()
    {
        userlist=(ListView)findViewById(R.id.list2);
        Intent intent=getIntent();
        year=intent.getStringExtra("year");
        branch=intent.getStringExtra("branch");
        Cursor cursor=myDb.showstudent(year,branch);
        if(cursor.getCount()==0)
            Toast.makeText(this,"no data to show",Toast.LENGTH_SHORT).show();
        else
        {
            while(cursor.moveToNext()){
                listitem1.add(cursor.getString(cursor.getColumnIndex("STUDENT_ID"))+"   "+cursor.getString(cursor.getColumnIndex("FIRST_NAME"))+"    "+cursor.getString(cursor.getColumnIndex("LAST_NAME")));



            }

            adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listitem1);
            userlist.setAdapter(adapter);
        }
    }
}




