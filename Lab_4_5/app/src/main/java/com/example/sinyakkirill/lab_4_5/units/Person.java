package com.example.sinyakkirill.lab_4_5.units;

/**
 * Created by Sinyak Kirill on 27.09.2016.
 */

public abstract class Person {

    protected String Name;
    protected String Surname;
    protected int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

}
