package com.spring.macoveirazvanionut.controllers;

import com.spring.macoveirazvanionut.entities.User;
import com.spring.macoveirazvanionut.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired private UserService service;

    @GetMapping("user/createAccount")
    public String showAccountCreateForm(Model model){
        model.addAttribute("user" , new User());
        return "createAccount";
    }

    @PostMapping("user/createAccount/save")
    public String saveUser(User user){
        service.save(user);
        return "redirect:/home";
    }

}
