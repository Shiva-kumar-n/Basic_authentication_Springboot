package com.example.mywebapp.controllers;

import com.example.mywebapp.managers.Usermanager;
import com.example.mywebapp.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UpdateController {
    @GetMapping("/forget")
    public String changePassword()
    {
        return "ForgetPassword";
    }

    @PostMapping("/forget")
    public ModelAndView updatePassword(@RequestParam String username,@RequestParam String password,@RequestParam String cpassword)
    {
        ModelAndView modelAndView = new ModelAndView();
        String updateMessage = Usermanager.changePassword(username,password,cpassword);
        if(updateMessage.equals("success")){
            modelAndView.setViewName("Login");
            return modelAndView;
        } else if (updateMessage.equals("Mismatch")) {
            modelAndView.addObject("errorMessage","Password and Confirm Password should match");
        }
        else {
            modelAndView.addObject("errorMessage","Username Not Found");
        }
        modelAndView.setViewName("ForgetPassword");
        return modelAndView;
    }

    @GetMapping("/deleteUser")
    public ModelAndView deleteUser(@RequestParam("userID") String userid){
        Usermanager.deleteUser(userid);
        return new ModelAndView("Login","errorMessage","User Deleted");
    }
}
