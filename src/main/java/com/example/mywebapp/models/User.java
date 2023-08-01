package com.example.mywebapp.models;

public class User {
    private String name;
    private String password;
    public User(String username,String password){
        this.name = username;
        this.password = password;
    }

    public String getName()
    {
        return this.name;
    }

    public String getPassword()
    {
        return this.password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

}
