package com.example.attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class addstudent extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {
    databasehelper mydb;
    private static EditText e1,e2,e3,e4;
    private static Spinner s1,s2;
    private static Button submit,cancel;
    public static String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addstudent);
        mydb=new databasehelper(this);
      e1=(EditText)findViewById(R.id.FirstName);
        e2=(EditText)findViewById(R.id.LastName);
        e3=(EditText)findViewById(R.id.address);
        e4=(EditText)findViewById(R.id.phone);
        s1=(Spinner)findViewById(R.id.spinner1);
        s2=(Spinner)findViewById(R.id.spinner2);
        submit=(Button)findViewById(R.id.submit);
        cancel=(Button)findViewById(R.id.cancel);
        s1.setOnItemSelectedListener(this);
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("       ----SELECT----   ");
        arrayList.add("CSE");
        arrayList.add("IT");
        arrayList.add("EC");
        arrayList.add("MECH");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(arrayAdapter);
        ArrayList<String> arrayList2 = new ArrayList<String>();
        arrayList2.add("      ----SELECT----   ");
        arrayList2.add("I");
        arrayList2.add("II");
        arrayList2.add("III");
        arrayList2.add("IV");
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList2);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(arrayAdapter2);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname=e1.getText().toString();
                String lastname=e2.getText().toString();
                String address=e3.getText().toString();
                String phone=e4.getText().toString();
                String spin1=s1.getSelectedItem().toString();
                String spin2=s2.getSelectedItem().toString();

                boolean isinserted= mydb.insertstudentdata(firstname,lastname,address,phone,spin1,spin2);
                if(isinserted==true)
                    Toast.makeText(addstudent.this,"data inserted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(addstudent.this,"data not inserted",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(".addstudent");
                startActivity(intent);
            }
        });

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item

        // Showing selected spinner item


    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }


}
