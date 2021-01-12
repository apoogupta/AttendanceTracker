package com.example.attendance;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.content.Context;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;

import java.util.ArrayList;


public class CustumAdapter extends BaseAdapter {
    public Context context;
    public ArrayList<String> nameList;
    public ArrayList<String> idList;
    private TextView Id;
    private TextView name;
    private Spinner spinner;

    public CustumAdapter(Context cont, ArrayList<String> nameList,ArrayList<String> idList){
        this.context = cont;
        this.nameList = nameList;
        this.idList = idList;

    }


    @Override
    public int getCount() {
        return nameList.size();

    }

    @Override
    public Object getItem(int position) {
        return nameList.get(position-1);
    }

    @Override
    public long getItemId(int position) {
        return  0;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.activity_custum_layout, parent, false);
        String[] options = {"--","P","Ab"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context,R.layout.support_simple_spinner_dropdown_item,options);
        Id = convertView.findViewById(R.id.idView);
        name = convertView.findViewById(R.id.nameView);
        spinner = convertView.findViewById(R.id.s1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        name.setText(nameList.get(position));
        Id.setText(idList.get(position));
        return convertView;

    }
}
