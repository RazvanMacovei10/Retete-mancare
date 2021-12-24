package com.spring.macoveirazvanionut.controllers;

import com.spring.macoveirazvanionut.CustomUserDetails;
import com.spring.macoveirazvanionut.CustomUserDetailsService;
import com.spring.macoveirazvanionut.entities.Category;
import com.spring.macoveirazvanionut.entities.Recipe;
import com.spring.macoveirazvanionut.entities.User;
import com.spring.macoveirazvanionut.services.CategoryServices;
import com.spring.macoveirazvanionut.services.RecipeServices;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.security.Principal;
import java.util.Collection;

@Controller
public class RecipeController {
    @Autowired
    private RecipeServices recipeService;
    @Autowired
    private CategoryServices categoryServices;

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
        Collection<Category> categoriesList= categoryServices.listAll();
        model.addAttribute("categoriesList",categoriesList);
        model.addAttribute("recipe" , new Recipe());
        return "addRecipe";
    }

    @GetMapping("/recipeDescription/{id}")
    public String seeFullRecipe(@PathVariable("id") Integer id,Model model){
        Recipe recipe = recipeService.get(id);
        model.addAttribute("recipe",recipe);

        return "recipeDescription";
    }



    @PostMapping("addRecipe/save")
    public String saveRecipe(Recipe recipe,
                             RedirectAttributes redirectAttributes,
                             @AuthenticationPrincipal CustomUserDetails customUserDetails,
                             @RequestParam("imageFile") MultipartFile imageFile,
                             Model model){
        recipe.setUser(customUserDetails.getUser());
        try {
            String folder="src/main/resources/static/images/"+customUserDetails.getUser().getEmail()+"/";
            recipeService.saveImage(imageFile,folder);
            recipe.setPhotoUrl("/images/"+customUserDetails.getUser().getEmail()+"/"+ imageFile.getOriginalFilename());
            model.addAttribute("recipe",recipe);
        } catch (IOException e) {
            e.printStackTrace();
        }
        recipeService.save(recipe);
        redirectAttributes.addFlashAttribute("message","Recipe added succesfully");
        return "redirect:/userRecipes";
    }

    @GetMapping("userRecipes")
    public String showUserRecipes(@AuthenticationPrincipal CustomUserDetails customUserDetails,Model model){
        Collection<Recipe> recipeList= recipeService.listAllUserRecipes(customUserDetails.getId());
        model.addAttribute("recipeList",recipeList);
        return "userRecipes";
    }

    @GetMapping("userRecipes/edit/{id}")
    public String showEditRecipe(@PathVariable("id") Integer id,Model model){
        Recipe recipe=recipeService.get(id);
        Collection<Category> categoriesList= categoryServices.listAll();
        model.addAttribute("categoriesList",categoriesList);
        model.addAttribute("recipe",recipe);

        return "editRecipe";
    }

    @GetMapping("userRecipes/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id,Model model){
        recipeService.deleteById(id);
        return "redirect:/userRecipes";
    }

}
