package com.example.complaintsapp.Data_employee;

public class Employee {
     int id;
     String name;
    String email;
    String machine_no;
     String password;
    public Employee(){}

    public Employee(int id,String name,String email,String machine_no,String password)
    {
        this.id =id;
        this.name =name;
        this.email =email;
        this.machine_no =machine_no;
        this.password =password;
    }
    public Employee(String name,String email,String machine_no,String password)
    {
        this.name =name;
        this.email =email;
        this.machine_no =machine_no;
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
    public String getMachine()
    {
        return this.machine_no;
    }
    public String getPassword()
    {
        return this.password;
    }

}
