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
    HashMap<String, List<Tasks>> listDataChild;
    FirestoreHelperSchedule firestoreHelperSchedule;
    Tasks t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        expListView=findViewById(R.id.expListView);
        listDataChild=new HashMap<String, List<Tasks>>();

        firestoreHelperSchedule=new FirestoreHelperSchedule(this);
        listDataHeader=new ArrayList<String>();
        listDataHeader.add("Daily");
        listDataHeader.add("All");
        listAdapter=new ExpandableListAdapter(this,listDataHeader,listDataChild);
        expListView.setAdapter(listAdapter);
    }
    public void prepareListData(List<Tasks> dailyTasks, List<Tasks> allTasks){
        listDataChild.put("Daily", dailyTasks);
        listDataChild.put("All", allTasks);
    }
}
