package com.example.attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;
import android.widget.ArrayAdapter;



public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    databasehelper myDb;
    public static EditText e1,e2;
    public static Button b1;
     public static Spinner spin;
     public static String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDb = new databasehelper(this);
        setContentView(R.layout.activity_main);
         e1 = (EditText) findViewById(R.id.username);
        e2 = (EditText) findViewById(R.id.password);
         spin = (Spinner) findViewById(R.id.spinner);
         b1 = (Button) findViewById(R.id.button);
        spin.setOnItemSelectedListener(this);

        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Select-User");
        arrayList.add("Admin");
        arrayList.add("Faculty");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(arrayAdapter);
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                if (spin.getSelectedItem()=="Admin") {

                    String user_name = e1.getText().toString();
                    String pass_word = e2.getText().toString();
                        if (user_name.equals("apoorva") && pass_word.equals("123")) {
                            Toast.makeText(MainActivity.this,"login successefull",Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(".alldata");
                            startActivity(intent);
                            } else {
                            Toast.makeText(MainActivity.this,"login not successfull",Toast.LENGTH_LONG).show();
                            Intent intent = new Intent("android.intent.action.MAIN");
                            startActivity(intent);
                        }
                } else if (spin.getSelectedItem()=="Faculty"){
                    String user_name = e1.getText().toString();
                    String pass_word = e2.getText().toString();
                    boolean Checklogin = myDb.checklogin(user_name,pass_word);
                    if (Checklogin == true) {
                        Toast.makeText(MainActivity.this,"login successfull of faculty",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(".facultypage");
                        startActivity(intent);

                    } else {
                        Toast.makeText(MainActivity.this,"login not successful",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent("android.intent.action.MAIN");
                        startActivity(intent);
                    }
                }
            }
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
         str = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item


    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

}

