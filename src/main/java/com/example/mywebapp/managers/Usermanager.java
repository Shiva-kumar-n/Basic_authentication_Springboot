package com.example.mywebapp.managers;

import com.example.mywebapp.models.User;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

public class Usermanager {

    private static List<User> usersData= new ArrayList<>();
    public static String findUser(String username,String password)
    {
        for (User user:usersData) {
            if(user.getName().equals(username)){
                if(user.getPassword().equals(password)){
                    System.out.println("User Login Succesfull");
                    return "success";
                }
                else {
                    System.out.println("Wrong Password");
                    return "wrong_password";
                }
            }

        }
        System.out.println("User Not Found.........");
        return "fail";
    }

    public static String addUser(String username, String password) {

        for (User user : usersData) {
            if (user.getName().equals(username)) {
                return "User Already Existed";
            }
        }
        usersData.add(new User(username, password));
        return "success";
    }

    public static String changePassword(String username,String password, String cpassword){
        if(password.equals(cpassword))
        {
            for(User user:usersData){
                if(user.getName().equals(username)){
                    user.setPassword(password);
                    return "success";
                }
            }
            return "Not Found";
        }
        return "Mismatch";
    }

    public static void deleteUser(String username)
    {
//        System.out.println("Delete Method Called for username "+username);
//        System.out.println("Before Deleting:");
//        for (User user:usersData) {
//            System.out.println(user);
//        }
        User delUser=new User("","");
        boolean flag = false;
        for(User user:usersData){
            if(user.getName().equals(username)){
                flag = true;
                delUser = user;
//                System.out.println("Deleting Usr"+delUser);
            }
        }
        if(flag){
            usersData.remove(delUser);
            System.out.println("User Deleted Successfully");
        }
        else{
            System.out.println("User Not Found for Deletion");
        }
//        System.out.println("After Deleting:");
//        for (User user:usersData) {
//            System.out.println(user);
//        }
    }

}
