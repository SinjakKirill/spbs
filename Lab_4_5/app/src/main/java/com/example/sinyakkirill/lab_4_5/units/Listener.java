package com.example.sinyakkirill.lab_4_5.units;

/**
 * Created by Sinyak Kirill on 27.09.2016.
 */

public class Listener extends Person {
    public Listener(String name, String surname) {
        this.Name = name;
        this.Surname = surname;
        this.id = this.Name.hashCode() + this.Surname.hashCode();
    }
}
