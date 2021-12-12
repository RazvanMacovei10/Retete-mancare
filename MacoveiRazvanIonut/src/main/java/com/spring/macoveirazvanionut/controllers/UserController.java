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

import java.util.Collection;

@Controller
public class UserController {
    @Autowired private UserService userService;
    @Autowired private RecipeServices recipeService;

    @GetMapping("")
    public String showLoginPage(){
        return "login";
    }
    @GetMapping("/login")
    public String showLoginnPage(){
        return "login";
    }

    @GetMapping("user/createAccount")
    public String showAccountCreateForm(Model model){
        model.addAttribute("user" , new User());
        return "createAccount";
    }

    @PostMapping("user/createAccount/save")
    public String saveUser(User user){
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        String encodedPassword=encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userService.save(user);
        return "redirect:/succesfullCreatedAccount";
    }

    @GetMapping("/home")
    public String showRecipeList(Model model){
        Collection<Recipe> recipeList= recipeService.listAllIncludingCategory();
        model.addAttribute("recipeList",recipeList);
        return "home";
    }

}
