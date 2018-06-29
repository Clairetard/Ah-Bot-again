package com.example.clair.ahbot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Schedule extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<Task>> listDataChild;
    List<Task> TaskList;
    Task t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        expListView=findViewById(R.id.expListView);
        prepareListData();
        listAdapter=new ExpandableListAdapter(this,listDataHeader,listDataChild);
        expListView.setAdapter(listAdapter);
    }
    public void prepareListData(){
//add sample data
        listDataHeader=new ArrayList<String>();
        listDataChild=new HashMap<String, List<Task>>();
        TaskList=new ArrayList<Task>();

        listDataHeader.add("Daily");
        listDataHeader.add("All");

        t=new Task("Eat Paracetamol",null,"8:00am");
        TaskList.add(t);
        listDataChild.put("Daily", TaskList);
    }
}
