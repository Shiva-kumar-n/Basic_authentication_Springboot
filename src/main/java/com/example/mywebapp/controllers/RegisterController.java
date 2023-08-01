package com.example.mywebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mywebapp.managers.Usermanager;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {
    @GetMapping("/register")
    public String getRegister()
    {
        return "Register";
    }

    @PostMapping("/register")
    public ModelAndView postRegister(@RequestParam String username,@RequestParam String password)
    {
        ModelAndView modelAndView = new ModelAndView();


        if(Usermanager.addUser(username,password).equals("success")){
            System.out.println("New User Created as "+username+" "+password);
            modelAndView.setViewName("redirect:/login");
            return modelAndView;
        }
        else {
            modelAndView.addObject("errorMessage", "User Already Existed");
            modelAndView.setViewName("Register");
            return modelAndView;
        }

    }
}
