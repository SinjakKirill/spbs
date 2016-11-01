package com.example.sinyakkirill.lab_4_5.units;

import com.example.sinyakkirill.lab_4_5.organization.Organizations;

/**
 * Created by Sinyak Kirill on 27.09.2016.
 */

public class Listener extends Person {
    public Listener(String Surname, String Name, int bday, Organizations organizations){
        super(Surname, Name, bday);
        this.organization = organizations;
    }

    Organizations organization;

    public Organizations getOrganization() {
        return organization;
    }

    public void setOrganization(Organizations organization) {
        this.organization = organization;
    }
}
