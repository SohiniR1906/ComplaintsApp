package com.example.complaintsapp.Complaints;

public class Complaint {
    String id;
    String type;
    String description;
    String email;
    String machine;
    String status;
    public Complaint(){}

    public Complaint(String id,String type,String machine,String description,String email,String status)
    {
        this.id =id;
        this.type =type;
        this.machine =machine;
        this.description=description;
        this.email =email;
        this.status=status;
    }
    public Complaint(String type,String machine,String description,String email,String status)
    {
        this.type =type;
        this.machine =machine;
        this.description=description;
        this.email =email;
        this.status=status;
    }
    public String getID(){return this.id;}
    public String getType()
    {
        return this.type;
    }
    public String getemail()
    {
        return this.email;
    }
    public String getMachine()
    {
        return this.machine;
    }
    public String getDescription()
    {
        return this.description;
    }
    public String getStatus()
    {
        return this.status;
    }
}
