package com.example.clair.ahbot;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class FirestoreHelperMedProfile {
    FirebaseFirestore firebaseFirestore=FirebaseFirestore.getInstance();
    CollectionReference medProfileCollection=firebaseFirestore.collection("profiles");

    List<MedicalProfile> medicalProfiles=new ArrayList<>();

    public FirestoreHelperMedProfile(MedProfile medProfile){
        final MedProfile ref=medProfile;
        medProfileCollection.get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    for(DocumentSnapshot document:task.getResult()){
                        String name=document.getString("name");
                        String age=document.get("age").toString();
                        String allergies= TextUtils.join(", ",(List<String>)document.get("allergies"));
                        String diseases=TextUtils.join(", ",(List<String>)document.get("diseases"));

                        MedicalProfile medicalProfile=new MedicalProfile(name,age,diseases,allergies);
                        medicalProfiles.add(medicalProfile);
                    }
                }
                else{
                    Log.d(TAG,"Error getting documents: ",task.getException());
                }
                ref.getMedProfile(medicalProfiles);
            }
        });
    }


}
