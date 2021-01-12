package com.example.attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addfaculty extends AppCompatActivity {
    databasehelper myDb;
private static Button b1,b2;
private static EditText e1,e2,e3,e4,e5,e6,e7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDb=new databasehelper(this);
        setContentView(R.layout.activity_addfaculty);
        addfacultydata();
    }
    public void addfacultydata()
    {
        b1=(Button)findViewById(R.id.b2);
        b2=(Button)findViewById(R.id.b1);
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);
        e3=(EditText)findViewById(R.id.e3);
        e4=(EditText)findViewById(R.id.e4);
        e5=(EditText)findViewById(R.id.e5);
        e6=(EditText)findViewById(R.id.e6);
        e7=(EditText)findViewById(R.id.e7);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isinserted= myDb.insertfacultydata(e1.getText().toString(),e2.getText().toString(),e3.getText().toString(),e4.getText().toString(),e5.getText().toString(),e6.getText().toString(),e7.getText().toString());
                if(isinserted==true)
                    Toast.makeText(addfaculty.this,"data inserted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(addfaculty.this,"data not inserted",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(".alldata");
                startActivity(intent);

            }
        });




    }
}
