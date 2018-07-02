package com.example.clair.ahbot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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

        firestoreHelperMedicine=new FirestoreHelperMedicine(this);

        layoutManager=new LinearLayoutManager(this);
        medicineAdapter=new MedicineAdapter(this,medicines);

        rvMedicines.setLayoutManager(layoutManager);
        rvMedicines.setAdapter(medicineAdapter);
    }
    public void getMedicine(List<Medicine> medlist) {
        medicines = medlist;
    }
}
