package com.example.mywebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mywebapp.managers.Usermanager;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {

    @GetMapping(value = {"/","/login"})
    public String getLogin()
    {
        System.out.println("Got Request......");
        return "Login";
    }

    @PostMapping("/login")
    public ModelAndView postLogin(@RequestParam String username,@RequestParam String password)
    {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("Got Login req for "+ username +" and password "+ password);
        String usermessage = Usermanager.findUser(username,password);
        if(usermessage.equals("success")){
            modelAndView.setViewName("redirect:/home");
            return modelAndView;
        } else if (usermessage.equals("fail")) {
            modelAndView.addObject("errorMessage","User Not Found");
            modelAndView.setViewName("Login");
            return modelAndView;
        }
        modelAndView.addObject("errorMessage","Wrong Password");
        modelAndView.setViewName("Login");
        return modelAndView;
    }
}
