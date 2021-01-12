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
import android.widget.Toast;

import java.util.ArrayList;

public class viewstudent extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    public static Spinner s1,s2;
    public static Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewstudent);
        s1 = (Spinner)findViewById(R.id.spin1);
        s2 = (Spinner)findViewById(R.id.spin2);
        submit = (Button) findViewById(R.id.button);
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
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String year = s1.getSelectedItem().toString();
                String branch = s2.getSelectedItem().toString();
                Intent intent=new Intent(".viewstudent2");
                intent.putExtra("year", year);
                intent.putExtra("branch", branch);
                startActivity(intent);
            }
        });
    }
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            // On selecting a spinner item


            // Showing selected spinner item


        }

        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub

        }

}
