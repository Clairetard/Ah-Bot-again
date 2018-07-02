package com.example.clair.ahbot;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Nullable;

import static android.content.ContentValues.TAG;

public class FirestoreHelperSchedule {
    FirebaseFirestore firebaseFirestore=FirebaseFirestore.getInstance();
    CollectionReference scheduleCollection= firebaseFirestore.collection("Schedule");

    FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
            .setTimestampsInSnapshotsEnabled(true)
            .build();


    List<Tasks> dailyTasks =new ArrayList<>();
    List<Tasks> allTasks =new ArrayList<>();

    public FirestoreHelperSchedule(){}
    public FirestoreHelperSchedule(Schedule s){
        final Schedule ref=s;
        scheduleCollection.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if(e!=null){
                    Log.w("FirestoreHelper", "Listen failed.", e);
//                    return;
                }
                for (DocumentSnapshot document : queryDocumentSnapshots){
                        Integer i = Integer.parseInt(document.get("every").toString());
                        if (i == 1) {
                            String taskName = document.getString("reminderName");
                            String time = document.getString("reminderTime");
                            Tasks t = new Tasks(taskName, null, time);
                            dailyTasks.add(t);
                        } else {
                            String taskName = document.getString("reminderName");
                            String dueDate = document.getString("reminderDate");
                            String time = document.getString("reminderTime");
                            Tasks t = new Tasks(taskName, dueDate, time);
                            allTasks.add(t);
                        }
                    }

                ref.prepareListData(dailyTasks, allTasks);
            }
        });
    }

}
