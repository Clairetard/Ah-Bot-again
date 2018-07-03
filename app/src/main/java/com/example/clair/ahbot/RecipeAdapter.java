package com.example.clair.ahbot;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class RecipeAdapter
        extends RecyclerView.Adapter<RecipeAdapter.ViewHolder>{
    public List<Recipe> recipeList;
    Context context;

    public RecipeAdapter(Context context){
        this.context=context;
        this.recipeList=new ArrayList<>();
    }


    public class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        public ImageView ivRecipeImg;
        public TextView tvRecipeName,tvIngredients;
        public ViewHolder(View itemView) {
            super(itemView);
            ivRecipeImg=itemView.findViewById(R.id.ivRecipeImg);
            tvRecipeName=itemView.findViewById(R.id.tvRecipeName);
            tvIngredients=itemView.findViewById(R.id.tvIngredients);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            String url=recipeList.get(getLayoutPosition()).getUrl();
            Intent i=new Intent("android.intent.action.VIEW", Uri.parse(url));
            context.startActivity(i);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.recipe_item
                        ,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeAdapter.ViewHolder holder, int position) {
        final Recipe recipe=recipeList.get(position);
        Glide.with(holder.ivRecipeImg.getContext())
                .load(recipe.getImageURL())
                .into(holder.ivRecipeImg);
        holder.tvRecipeName.setText(recipe.getRecipeName());
        holder.tvIngredients.setText("Main Ingredients: "+recipe.getMainIngredients());
    }

    @Override
    public int getItemCount() {
        return recipeList==null?0:recipeList.size();
    }


    public void addItem(Recipe recipe){
        recipeList.add(recipe);
        notifyItemChanged(recipeList.size()-1);
    }
    public void addAlItems(List<Recipe> recipes){
        for(Recipe recipe: recipes){
            addItem(recipe);
        }
    }
    public void deleteEverything(){
        if(recipeList!=null) recipeList.clear();
    }

}
