package com.example.clair.ahbot;

import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class FirestoreHelperMedicine {
    List<Medicine> medicineList;

    FirebaseFirestore firebaseFirestore=FirebaseFirestore.getInstance();
    CollectionReference medicineCollection = firebaseFirestore.collection("MedicineList");

    FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
            .setTimestampsInSnapshotsEnabled(true)
            .build();

    public FirestoreHelperMedicine(ViewMedicine r) {


        final ViewMedicine reference = r;
        medicineCollection
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value,
                                        @Nullable FirebaseFirestoreException e) {
                        if (e != null) {
                            Log.w("FirestoreHelper", "Listen failed.", e);
                            return;
                        }
                        medicineList = new ArrayList<>();

                        //medicineList.clear();
                        for (DocumentSnapshot document : value) {

                            String medName = document.getString("MedicineName");
                            String amt = document.getString("Amount");
                            String freq = document.getString("Frequency");
                            String remarks = document.getString("Remarks");


                            Medicine medicine = new Medicine(medName, amt, freq, remarks);
                            medicineList.add(medicine);
                        }
                        reference.getMedicine(medicineList);
                    }
                });

    }
}
