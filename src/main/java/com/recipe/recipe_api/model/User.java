package com.recipe.recipe_api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "users")
public class User {
    @Id
    private String id;

    private String username;
    private String password;
    private String role;
    private List<String> recipeIds;
    private List<String> favoriteRecipes;

    // Getters & Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public List<String> getRecipeIds() { return recipeIds; }
    public void setRecipeIds(List<String> recipeIds) { this.recipeIds = recipeIds; }

    public List<String> getFavoriteRecipes() { return favoriteRecipes; }
    public void setFavoriteRecipes(List<String> favoriteRecipes) { this.favoriteRecipes = favoriteRecipes; }
}
