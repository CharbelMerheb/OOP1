/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */package com.recipe.recipe_api.controller;

import com.recipe.recipe_api.model.Recipe;
import com.recipe.recipe_api.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recipes")
@CrossOrigin(origins = "*")
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    // Get all recipes (admin sees all, users see only their own)
    @GetMapping
    public List<Recipe> getRecipes(@RequestParam String username) {
        if (username.equals("admin")) {
            return recipeRepository.findAll();
        } else {
            return recipeRepository.findByUsername(username);
        }
    }

    // Add a recipe
    @PostMapping
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    // Update a recipe (admin or the user who owns the recipe)
    @PutMapping("/{id}")
public Recipe updateRecipe(@PathVariable String id, @RequestBody Recipe updatedRecipe, @RequestParam String username) {
    Optional<Recipe> optional = recipeRepository.findById(id);
    if (optional.isPresent()) {
        Recipe existing = optional.get();

        if (!username.equals("admin") && !username.equals(existing.getUsername())) {
            return null; // Unauthorized
        }

        existing.setTitle(updatedRecipe.getTitle());
        existing.setIngredients(updatedRecipe.getIngredients());
        existing.setInstructions(updatedRecipe.getInstructions());
        existing.setCookingTime(updatedRecipe.getCookingTime());
        existing.setCategory(updatedRecipe.getCategory());

        return recipeRepository.save(existing);
    }
    return null; // Not found
}

    // Delete a recipe (admin or the user who owns the recipe)
    @DeleteMapping("/{id}")
    public String deleteRecipe(@PathVariable String id, @RequestParam String username) {
        Optional<Recipe> optional = recipeRepository.findById(id);
        if (optional.isPresent()) {
            Recipe existing = optional.get();

            if (!username.equals("admin") && !username.equals(existing.getUsername())) {
                return "Unauthorized";
            }

            recipeRepository.deleteById(id);
            return "Deleted";
        }
        return "Not Found";
    }
}
