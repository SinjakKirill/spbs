package com.example.sinyakkirill.lab_4_5.staff;

import com.example.sinyakkirill.lab_4_5.exception.EduException;
import com.example.sinyakkirill.lab_4_5.units.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static com.example.sinyakkirill.lab_4_5.units.Person.snordererSurname;

/**
 * Created by Sinyak Kirill on 27.09.2016.
 */

public class Staff {

    private ArrayList<Person> studlist;

    public ArrayList<Person> getStudlist() {
        return studlist;
    }

    public void setStudlist(ArrayList<Person> studlist) {
        this.studlist = studlist;
    }

    public Staff(){ studlist = new ArrayList<Person>(); }

    public Staff(ArrayList<Person> persons){ studlist = persons; }

    public boolean add (Person item) throws EduException{
        if(studlist.add(item))
            return  true;
        else return  false;
    }

    public boolean remove(Person item){
        if(studlist.remove(item))
            return true;
        else return  false;
    }

    public boolean compByYear(Person a, Person b){
        if(a.getBday() == b.getBday())
            return true;
        else return false;
    }

}
