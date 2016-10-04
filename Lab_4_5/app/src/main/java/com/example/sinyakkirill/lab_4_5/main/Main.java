package com.example.sinyakkirill.lab_4_5.main;

import com.example.sinyakkirill.lab_4_5.units.Person;
import com.example.sinyakkirill.lab_4_5.units.Student;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Created by Sinyak Kirill on 27.09.2016.
 */

public class Main {
    /*static {
        try {
            LogManager.getLogManager().readConfiguration(
                    new FileInputStream("logger.properties"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public static void main(String[] args) {
        Person person = new Student("Kirill", "Sinyak");
    }
}
