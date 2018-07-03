package com.example.clair.ahbot;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class ViewRecipe extends AppCompatActivity {

    List<Recipe> recipes;
    RecipeAdapter recipeAdapter;
    RecyclerView rvRecipes;
    RecyclerView.LayoutManager layoutManager;
    FirestoreHelperRecipe firestoreHelperRecipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_recipe);

        rvRecipes=findViewById(R.id.rvRecipes);
        recipes=new ArrayList<>();

        layoutManager=new LinearLayoutManager(this);
        recipeAdapter=new RecipeAdapter(this);

        rvRecipes.setLayoutManager(layoutManager);
        rvRecipes.setAdapter(recipeAdapter);

        rvRecipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.rvRecipes:
                        int itemPosition=rvRecipes.getChildLayoutPosition(v);
                        String url=recipes.get(itemPosition).getUrl();
                        Intent i=new Intent("android.intent.action.VIEW", Uri.parse(url));
                        startActivity(i);
                        break;
                }
            }
        });
    }
    @Override
    protected void onStart(){
        super.onStart();
        ViewRecipe ref=this;
        firestoreHelperRecipe=new FirestoreHelperRecipe(ref);
    }
    public void getRecipe(List<Recipe> recipeList) {
        recipes=recipeList;
        UpdateList(recipes);
    }

    public void UpdateList(List<Recipe> recipes){
        recipeAdapter.deleteEverything();
        recipeAdapter.addAlItems(recipes);
    }
}
