package com.example.gauri.officialmentor;

/**
 * Created by Gauri on 4/15/2016.
 */
public class Dataprovider
{
    private String roll;
    private String name;


    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public Dataprovider(String roll, String name)
    {
       this.roll = roll;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
