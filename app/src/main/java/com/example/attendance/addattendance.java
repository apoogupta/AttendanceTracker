package com.example.attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class addattendance extends AppCompatActivity {

    databasehelper myDb;
    ArrayList<String> nameList;
    ArrayList<String> idList;
    ListView userlist;
    String year;
    String branch;
    String date;
    String subject;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addattendance);
        myDb=new databasehelper(this);
        nameList=new ArrayList<>();
        idList=new ArrayList<>();
        viewdata();
        submit=(Button)findViewById(R.id.submit);
        Intent intent=getIntent();
        year=intent.getStringExtra("year");
        branch=intent.getStringExtra("branch");
        date=intent.getStringExtra("date");
        subject=intent.getStringExtra("subject");
        userlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(addattendance.this,""+view,Toast.LENGTH_SHORT).show();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < userlist.getCount();i++)
                {
                   View parent= userlist.getChildAt(i);
                   Spinner spinner=(Spinner)parent.findViewById(R.id.s1);
                   TextView id=(TextView)parent.findViewById(R.id.idView);
                   boolean inserted=myDb.insertAttendance(id.getText().toString(),date,branch,year,subject,spinner.getSelectedItem().toString());
                   if(inserted==false)
                       Toast.makeText(addattendance.this,"not inserted",Toast.LENGTH_LONG).show();
                }
                Intent intent=new Intent(addattendance.this,facultypage.class);
                startActivity(intent);

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
                nameList.add(cursor.getString(cursor.getColumnIndex("FIRST_NAME"))+"    "+cursor.getString(cursor.getColumnIndex("LAST_NAME")));
                idList.add(cursor.getString(cursor.getColumnIndex("STUDENT_ID")));


            }

            CustumAdapter adapter = new CustumAdapter(this,nameList,idList);
            userlist.setAdapter(adapter);
        }
    }
}






