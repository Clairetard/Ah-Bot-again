package com.example.clair.ahbot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MedProfile extends AppCompatActivity {
    RecyclerView rvMedProfile;
    MedProfileAdapter medProfileAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<MedicalProfile> Dataset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med_profile);

        Dataset=new ArrayList<>();
        rvMedProfile=findViewById(R.id.rvMedProfuel);
        AddData();
        layoutManager=new LinearLayoutManager(this);
        medProfileAdapter=new MedProfileAdapter(this,Dataset);

        rvMedProfile.setLayoutManager(layoutManager);
        rvMedProfile.setAdapter(medProfileAdapter);
    }
    public void AddData(){
        MedicalProfile medicalProfile=new MedicalProfile("Dora","59","Diabetes","Peanuts");
        Dataset.add(medicalProfile);

    }
}
