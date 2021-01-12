package com.example.attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class facultypage extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    databasehelper mydb;
    public static TextView choose_date;
    public static TextView show_date;
    public static Button b1, b2;
    public static Spinner s1, s2,s3;
    public static DatePicker picker;
    public static ImageButton imgbtn;
    public String year,branch,subject,date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facultypage);
        mydb = new databasehelper(this);
        choose_date = (TextView) findViewById(R.id.choose_date);
        show_date = (TextView) findViewById(R.id.show_date);
        s1 = (Spinner) findViewById(R.id.spinner1);
        s2 = (Spinner) findViewById(R.id.spinner2);
        s3 = (Spinner) findViewById(R.id.spinner3);
        imgbtn=(ImageButton)findViewById(R.id.imageButton);

        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        imgbtn.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               // Get Current Date
                                               final Calendar c = Calendar.getInstance();
                                               int mYear = c.get(Calendar.YEAR);
                                               int mMonth = c.get(Calendar.MONTH);
                                               int mDay = c.get(Calendar.DAY_OF_MONTH);


                                               DatePickerDialog datePickerDialog = new DatePickerDialog(facultypage.this,
                                                       new DatePickerDialog.OnDateSetListener() {

                                                           @Override
                                                           public void onDateSet(DatePicker view, int year,
                                                                                 int monthOfYear, int dayOfMonth) {

                                                               show_date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                                                               date=show_date.getText().toString();
                                                           }
                                                       }, mYear, mMonth, mDay);
                                               datePickerDialog.show();

                                           }});
            ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("      ----SELECT----   ");
        arrayList.add("I");
        arrayList.add("II");
        arrayList.add("III");
        arrayList.add("IV");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(arrayAdapter);
        ArrayList<String> arrayList2 = new ArrayList<String>();
        arrayList2.add("       ----SELECT----   ");
        arrayList2.add("CSE");
        arrayList2.add("IT");
        arrayList2.add("EC");
        arrayList2.add("MECH");
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList2);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(arrayAdapter2);
        s1.setOnItemSelectedListener(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                year = s1.getSelectedItem().toString();
                branch = s2.getSelectedItem().toString();
                subject=s3.getSelectedItem().toString();
                Intent intent = new Intent(".addattendance");
                intent.putExtra("year", year);
                intent.putExtra("branch", branch);
                intent.putExtra("date",date);
                intent.putExtra("subject",subject);
                startActivity(intent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                year = s1.getSelectedItem().toString();
                branch = s2.getSelectedItem().toString();
                subject=s3.getSelectedItem().toString();
                Intent intent = new Intent(".viewAttendance");
                intent.putExtra("year", year);
                intent.putExtra("branch", branch);
                intent.putExtra("date",date);
                intent.putExtra("subject",subject);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(s1.getSelectedItem().toString().equals("I"))
        {
            ArrayList<String> arrayList = new ArrayList<String>();
            arrayList.add("      ----SELECT----   ");
            arrayList.add("Physics");
            arrayList.add("chemistry");
            arrayList.add("M1");
            arrayList.add("Ed");

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList);
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            s3.setAdapter(arrayAdapter);

        }
        else if(s1.getSelectedItem().toString().equals("II"))
        {
            ArrayList<String> arrayList = new ArrayList<String>();
            arrayList.add("      ----SELECT----   ");
            arrayList.add("DS");
            arrayList.add("M2");
            arrayList.add("CSO");
            arrayList.add("DBMS");

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList);
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            s3.setAdapter(arrayAdapter);
        }
        else if(s1.getSelectedItem().toString().equals("III"))
        {
            ArrayList<String> arrayList = new ArrayList<String>();
            arrayList.add("      ----SELECT----   ");
            arrayList.add("NETWORKING");
            arrayList.add("M3");
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList);
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            s3.setAdapter(arrayAdapter);
        }
        else
        {
            ArrayList<String> arrayList = new ArrayList<String>();
            arrayList.add("      ----SELECT----   ");
            arrayList.add("Machine learning ");
            arrayList.add("M4");
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList);
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            s3.setAdapter(arrayAdapter);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}
