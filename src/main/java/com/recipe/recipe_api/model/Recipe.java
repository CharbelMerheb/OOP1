package com.recipe.recipe_api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "recipes")
public class Recipe {

    @Id
    private String id;

    private String title;
    private String ingredients;
    private String instructions;
    private int cookingTime;
    private String category;
    private String username; // Creator
    private boolean modifiedByAdmin; // NEW FIELD

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isModifiedByAdmin() {
        return modifiedByAdmin;
    }

    public void setModifiedByAdmin(boolean modifiedByAdmin) {
        this.modifiedByAdmin = modifiedByAdmin;
    }
}
