/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.recipe.recipe_api.repository;

import com.recipe.recipe_api.model.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface RecipeRepository extends MongoRepository<Recipe, String> {
    List<Recipe> findByUsername(String username);
}
