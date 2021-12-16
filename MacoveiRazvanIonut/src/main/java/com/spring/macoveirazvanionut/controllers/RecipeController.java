package com.spring.macoveirazvanionut.controllers;

import com.spring.macoveirazvanionut.entities.Recipe;
import com.spring.macoveirazvanionut.entities.User;
import com.spring.macoveirazvanionut.services.RecipeServices;
import com.spring.macoveirazvanionut.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collection;
import java.util.List;

@Controller
public class RecipeController {
    @Autowired private RecipeServices recipeService;


    @GetMapping("/home")
    public String showRecipeList(Model model){
        Collection<Recipe> recipeList= recipeService.listAll();
        model.addAttribute("recipeList",recipeList);
        return "home";
    }
    @GetMapping("/categories")
    public String showCategories(){
        return "categories";
    }


    @GetMapping("/addRecipe")
    public String addNewRecipe(Model model){
        model.addAttribute("recipe" , new Recipe());
        return "addRecipe";
    }
    @PostMapping("addRecipe/save")
    public String saveRecipe(Recipe recipe, RedirectAttributes redirectAttributes){
        recipeService.save(recipe);
        redirectAttributes.addFlashAttribute("message","Recipe added succesfully");
        return "redirect:/userRecipes";
    }
}
