package com.example.complaintsapp.Data_admin;

public class Admin {
    int id;
    String name;
    String email;
    String password;
    public Admin(){}

    public Admin(int id,String name,String email,String password)
    {
        this.id =id;
        this.name =name;
        this.email =email;
        this.password =password;
    }
    public Admin(String name,String email,String password)
    {
        this.name =name;
        this.email =email;
        this.password =password;
    }
    public String getName()
    {
        return this.name;
    }
    public String getEmail()
    {
        return this.email;
    }
    public String getPassword()
    {
        return this.password;
    }

}
