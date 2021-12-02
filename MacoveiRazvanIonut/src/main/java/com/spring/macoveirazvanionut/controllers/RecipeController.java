package com.spring.macoveirazvanionut.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class RecipeController {
    @GetMapping("/home")
    public String showHomePage(){
        return "home";
    }
}
