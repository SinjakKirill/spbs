package com.example.sinyakkirill.lab_4_5.main;

import android.provider.MediaStore;

import com.example.sinyakkirill.lab_4_5.educationmanager.Manager;
import com.example.sinyakkirill.lab_4_5.exception.EduException;
import com.example.sinyakkirill.lab_4_5.organization.Organizations;
import com.example.sinyakkirill.lab_4_5.staff.Staff;
import com.example.sinyakkirill.lab_4_5.units.Listener;
import com.example.sinyakkirill.lab_4_5.units.Person;
import com.example.sinyakkirill.lab_4_5.units.Student;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import org.json.JSONArray;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Created by Sinyak Kirill on 27.09.2016.
 */

public class Main {

    private static final
    Logger LOG = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        LOG.info("Starting program____________________________________");
        String fileNameListener = new String("Listeners.json");
        String fileNameStudent = new String("Students.json");
        Staff staffJson = new Staff();
        Manager manager= new Manager();
        try {
            LOG.info("create Course from Json_____________________________");
            manager.createCourseJson(staffJson, 10, 10, fileNameListener, fileNameStudent);
        } catch (EduException e) {
            e.printStackTrace();
        }
        Staff staffRandom = new Staff();
        try {
            LOG.info("create random Course________________________________");
            manager.createCourseRandom(staffRandom, 12, 10);
        } catch (EduException e) {
            e.printStackTrace();
        }

        System.out.println("Сумма за обучение(json): " + manager.sumRange(staffJson));
        System.out.println("Сумма за обучение(random): " + manager.sumRange(staffRandom));
        LOG.info("Sort Staff(Random) by bday________________________________");
        System.out.println("\n\nSort Staff(Random) by bday:");
        manager.sortStaffByBDay(staffRandom);
        manager.showCourseInConsole(staffRandom);
        LOG.info("sort staff(json) by bday________________________________");
        System.out.println("\n\nsort staff(json) by bday:");
        manager.sortStaffByBDay(staffJson);
        manager.showCourseInConsole(staffJson);
        LOG.info("sort staff(random) by surname________________________________");
        System.out.println("\n\nsort staff(random) by surname:");
        manager.sortStaffBySurname(staffRandom);
        manager.showCourseInConsole(staffRandom);
        LOG.info("sort staff(json) by surname________________________________");
        System.out.println("\n\nsort staff(json) by surname:");
        manager.sortStaffBySurname(staffJson);
        manager.showCourseInConsole(staffJson);
        System.out.println("\n\n3 best students:");
        manager.getThreeBestStudentd(staffRandom);
    }
}
