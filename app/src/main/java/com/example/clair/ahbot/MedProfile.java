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
    FirestoreHelperMedProfile firestoreHelperMedProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med_profile);

        Dataset=new ArrayList<>();
        rvMedProfile=findViewById(R.id.rvMedProfuel);
        layoutManager=new LinearLayoutManager(this);
        medProfileAdapter=new MedProfileAdapter(this,Dataset);

        rvMedProfile.setLayoutManager(layoutManager);
        rvMedProfile.setAdapter(medProfileAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        MedProfile ref=this;
        firestoreHelperMedProfile=new FirestoreHelperMedProfile(ref);

    }
    public void getMedProfile(List<MedicalProfile> medicalProfiles){
        Dataset=medicalProfiles;
        UpdateList(Dataset);
    }
    public void UpdateList(List<MedicalProfile> medicalProfiles){
        medProfileAdapter.deleteEverything();
        medProfileAdapter.addAlItems(medicalProfiles);
    }
}
