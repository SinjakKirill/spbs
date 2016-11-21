package com.example.sinyakkirill.lab_4_5.units;

import java.text.SimpleDateFormat;
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

    public Person(String Surname, String Name, String Patronymic, String bdayDDMMYY){
        this.Surname = Surname;
        this.Name = Name;
        this.Patronymic = Patronymic;
        this.bday = bdayDDMMYY;
    }

    protected String Name;
    protected String Surname;
    protected String Patronymic;

    public String getBday() {
        return bday;
    }

    public void setBday(String bday) {
        this.bday = bday;
    }

    protected String bday;

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
            SimpleDateFormat formatO1 = new SimpleDateFormat();
            SimpleDateFormat formatO2 = new SimpleDateFormat();
            formatO1.applyPattern(o1.getBday());
            formatO2.applyPattern(o2.getBday());
            formatO1.getDateFormatSymbols();

            /*if(o1.getBday() > o2.getBday())
                return 1;
            if(o1.getBday() < o2.getBday())
                return -1;*/
            return 0;
        }
    };



}
