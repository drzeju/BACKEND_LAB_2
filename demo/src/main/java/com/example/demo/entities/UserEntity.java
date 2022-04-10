package com.example.demo.entities;

public class UserEntity
{
    private Long id;
    private String first_name;
    private String last_name;

    public UserEntity(Long id, String first_name, String last_name)
    {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getFirst_name()
    {
        return this.first_name;
    }

    public void setFirst_name(String first_name)
    {
        this.first_name = first_name;
    }

    public String getLast_name()
    {
        return this.last_name;
    }

    public void setLast_name(String last_name)
    {
        this.last_name = last_name;
    }
}
