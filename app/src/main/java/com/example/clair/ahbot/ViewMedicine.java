package com.example.clair.ahbot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.firebase.firestore.DocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class ViewMedicine extends AppCompatActivity {

    List<Medicine> medicines;
    MedicineAdapter medicineAdapter;
    RecyclerView rvMedicines;
    RecyclerView.LayoutManager layoutManager;
    FirestoreHelperMedicine firestoreHelperMedicine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_medicine);

        rvMedicines=findViewById(R.id.rvMedsList);

        medicines=new ArrayList<>();

        layoutManager=new LinearLayoutManager(this);
        medicineAdapter=new MedicineAdapter(this);
        rvMedicines.setLayoutManager(layoutManager);
        rvMedicines.setAdapter(medicineAdapter);
    }
    @Override
    protected void onStart(){
        super.onStart();
        ViewMedicine ref=this;
        firestoreHelperMedicine=new FirestoreHelperMedicine(ref);
    }
    public void getMedicine(List<Medicine> medlist) {

        medicines = medlist;
        UpdateList(medicines);
    }

    public void UpdateList(List<Medicine> m){
        medicineAdapter.deleteEverything();
        medicineAdapter.addAlItems(m);
    }
}
