package com.example.attendance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter2 extends BaseAdapter {
    public Context context;
    public ArrayList<String> nameList;
    public ArrayList<String> idList;
    public ArrayList<String> statusList;
    private TextView Id;
    private TextView name;
    private TextView status;

    public CustomAdapter2(Context cont, ArrayList<String> nameList,ArrayList<String> idList,ArrayList<String> statusList){
        this.context = cont;
        this.nameList = nameList;
        this.idList = idList;
        this.statusList=statusList;

    }

    @Override
    public int getCount() {
        return nameList.size();
    }

    @Override
    public Object getItem(int i) {
        return nameList.get(i-1);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = LayoutInflater.from(context).inflate(R.layout.activity_custum_layout2, viewGroup, false);
       // String[] options = {"--","P","Ab"};
      //  ArrayAdapter<String> adapter = new ArrayAdapter<String>(context,R.layout.support_simple_spinner_dropdown_item,options);
        Id = view.findViewById(R.id.idView);
        name = view.findViewById(R.id.nameView);
        status=view.findViewById(R.id.s1);
        //spinner = convertView.findViewById(R.id.s1);
       // adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       // spinner.setAdapter(adapter);
        name.setText(nameList.get(i));
        Id.setText(idList.get(i));
        status.setText(statusList.get(i));
        return view;
    }
}
