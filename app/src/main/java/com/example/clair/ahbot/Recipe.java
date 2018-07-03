package com.example.clair.ahbot;

public class Recipe {
    String  recipeName, mainIngredients, imageURL, url;

    public Recipe(String recipeName, String mainIngredients, String imageURL, String url) {
        this.recipeName = recipeName;
        this.mainIngredients = mainIngredients;
        this.imageURL = imageURL;
        this.url = url;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getMainIngredients() {
        return mainIngredients;
    }

    public void setMainIngredients(String mainIngredients) {
        this.mainIngredients = mainIngredients;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
