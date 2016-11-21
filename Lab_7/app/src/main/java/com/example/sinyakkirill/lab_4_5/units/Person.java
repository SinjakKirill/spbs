package com.example.sinyakkirill.lab_4_5.units;

import java.util.Comparator;
import java.util.Date;


/**
 * Created by Sinyak Kirill on 27.09.2016.
 */

public abstract class Person {

    public Person(String Surname, String Name, String Patronymic){
        this.Surname = Surname;
        this.Name = Name;
        this.Patronymic = Patronymic;
    }

    public Person(String Surname, String Name, Date bdayDDMMYY){
        this.Surname = Surname;
        this.Name = Name;
        this.bday = bdayDDMMYY;
    }

    public Person(String Surname, String Name, String Patronymic, Date bdayDDMMYY){
        this.Surname = Surname;
        this.Name = Name;
        this.Patronymic = Patronymic;
        this.bday = bdayDDMMYY;
    }

    protected String Name;
    protected String Surname;
    protected String Patronymic;

    public Date getBday() {
        return bday;
    }

    public void setBday(Date bday) {
        this.bday = bday;
    }

    protected Date bday;

    public String getPatronymic() {
        return Patronymic;
    }

    public void setPatronymic(String patronymic) {
        Patronymic = patronymic;
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

    public static Comparator<Person> snordererSurname = new Comparator<Person>() {
        public int compare(Person o1, Person o2) {
                return o1.getSurname().compareTo(o2.getSurname());
           }
    };

    public static Comparator<Person> snordererBDay = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            if(o1.getBday().getYear() > o2.getBday().getYear())
                return 1;
            if(o1.getBday().getYear() < o2.getBday().getYear())
                return -1;
            return 0;
        }
    };



}
