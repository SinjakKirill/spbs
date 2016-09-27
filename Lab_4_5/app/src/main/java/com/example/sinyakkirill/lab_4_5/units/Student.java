package com.example.sinyakkirill.lab_4_5.units;

/**
 * Created by Sinyak Kirill on 27.09.2016.
 */

public class Student extends Person {
    public Student(String name, String surname) {
        this.Name = name;
        this.Surname = surname;
        this.id = this.Name.hashCode() + this.Surname.hashCode();
    }
}
