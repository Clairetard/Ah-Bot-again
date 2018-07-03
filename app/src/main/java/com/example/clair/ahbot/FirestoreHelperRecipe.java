package com.example.clair.ahbot;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import io.opencensus.tags.Tag;

import static android.support.constraint.Constraints.TAG;

public class FirestoreHelperRecipe {
    FirebaseFirestore firebaseFirestore=FirebaseFirestore.getInstance();
    CollectionReference recipeColletion=firebaseFirestore.collection("Recipe");

    List<Recipe> recipes=new ArrayList<>();

    public FirestoreHelperRecipe(ViewRecipe r){
        final ViewRecipe ref=r;
        recipeColletion.get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(DocumentSnapshot document: task.getResult()){
                                String recipeName=document.getString("recipeName");
                                String ingredients=document.getString("ingredients");
                                String imageURL=document.getString("imageUrl");
                                String url=document.getString("url");

                                Recipe recipe=new Recipe(recipeName,ingredients,imageURL,url);
                                recipes.add(recipe);
                            }
                        }
                        else {
                            Log.d(TAG,"Error getting documents :",task.getException());
                        }
                        ref.getRecipe(recipes);
                    }
                });
    }
}
