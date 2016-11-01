package com.example.sinyakkirill.lab_4_5.educationmanager;

import android.net.sip.SipAudioCall;

import com.example.sinyakkirill.lab_4_5.exception.EduException;
import com.example.sinyakkirill.lab_4_5.organization.Organizations;
import com.example.sinyakkirill.lab_4_5.staff.Staff;
import com.example.sinyakkirill.lab_4_5.units.Listener;
import com.example.sinyakkirill.lab_4_5.units.Person;
import com.example.sinyakkirill.lab_4_5.units.Student;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static com.example.sinyakkirill.lab_4_5.units.Person.snordererBDay;
import static com.example.sinyakkirill.lab_4_5.units.Person.snordererSurname;
import static com.example.sinyakkirill.lab_4_5.units.Student.snordereByAvg;

/**
 * Created by Sinyak Kirill on 27.09.2016.
 */

public class Manager implements IAction {

    @Override
    public Staff createCourseJson(Staff someCourse, int maxStudent, int maxListener, String fileNameListener, String fileNameStudent) throws EduException {
        ArrayList<Listener> listenerArrayList = new ArrayList<>();
        ArrayList<Student> studentArrayList = new ArrayList<>();
        File jsonFileListener = new File(fileNameListener);
        File jsonFileStudent = new File(fileNameStudent);
        Gson gson = new Gson();
        Type typeListener = new TypeToken<ArrayList<Listener>>(){}.getType();
        Type typeStudent = new TypeToken<ArrayList<Student>>(){}.getType();
        if(maxStudent > 10 || maxListener > 10)
            throw new EduException("(maxStudent || maxListener) > limit");
        try {
            FileReader fileReaderListener = new FileReader(jsonFileListener);
            FileReader fileReaderStudent = new FileReader(jsonFileStudent);
            char[] charsListener = new char[(int)jsonFileListener.length()];
            char[] charsStudent = new char[(int)jsonFileStudent.length()];
            fileReaderListener.read(charsListener);
            fileReaderStudent.read(charsStudent);
            listenerArrayList = gson.fromJson(new String(charsListener), typeListener);
            studentArrayList = gson.fromJson(new String(charsStudent), typeStudent);
            fileReaderListener.close();
            fileReaderStudent.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < maxListener; i++) {
            try {
                someCourse.add(listenerArrayList.get(i));
            } catch (EduException e) {
                e.printStackTrace();
            }
        }
        for (int j = 0; j < maxStudent; j++){
            try {
                someCourse.add(studentArrayList.get(j));
            } catch (EduException e) {
                e.printStackTrace();
            }
        }
        return someCourse;
    }

    @Override
    public Staff createCourseRandom(Staff someCourse, int maxStudent, int maxListener) throws EduException{
        String[] nameArr = {"Kirill", "Sonya", "Vlad", "Alina", "Roma", "Petr", "Alex", "Dima"};
        String[] surnameArr = {"Cherepko", "Podolyanchik", "Nikolaychuk", "Petrov", "Ivanov", "Prokurat", "Buranko", "Ilein"};
        Random random = new Random();
        if(maxStudent + maxListener > 30)
            throw new EduException("(maxStudent + maxListener) > limitCourse(30)");
        for(int i = 0; i < maxStudent; i++){
            int index = random.nextInt(8);
            try {
                someCourse.add(new Student(surnameArr[index], nameArr[index], random.nextInt(20) + 1990, random.nextFloat() * 10));
            } catch (EduException e) {
                e.printStackTrace();
            }
        }
        for(int j = 0; j < maxListener; j++){
            int index = random.nextInt(8);
            if(index % 2 == 1) {
                try {
                    someCourse.add(new Listener(surnameArr[index], nameArr[index], random.nextInt(20) + 1990, Organizations.Epam));
                } catch (EduException e) {
                    e.printStackTrace();
                }
            }
            else{
                try {
                    someCourse.add(new Listener(surnameArr[index], nameArr[index], random.nextInt(20) + 1990, Organizations.Pek));
                } catch (EduException e) {
                    e.printStackTrace();
                }
            }
        }
        return someCourse;
    }

    @Override
    public int sumRange(Staff anyCourse) {
        int sum = 0;
        ArrayList<Listener> listenerArrayList = new ArrayList<>();
        for (Person person :
                anyCourse.getStudlist()) {
            if(person.getClass() == Listener.class)
                listenerArrayList.add((Listener) person);
        }
        for (Listener listener :
                listenerArrayList) {
            sum += listener.getOrganization().getProfit();
        }
        return sum;
    }

    @Override
    public int countListner(Staff anyCourse) {
        int count = 0;
        for (Person person :
                anyCourse.getStudlist()) {
            if (person.getClass() == Listener.class)
                count++;
        }
        return count;
    }

    public void showCourseInConsole(Staff anyCourse){
        for (Person person :
                anyCourse.getStudlist()) {
            System.out.println(person.getSurname() + " " + person.getName() + " " + person.getBday());
        }
    }

    public void sortStaffBySurname(Staff onyCourse){
        Collections.sort(onyCourse.getStudlist(), snordererSurname);
    }

    public void sortStaffByBDay(Staff onyCourse){
        Collections.sort(onyCourse.getStudlist(), snordererBDay);
    }

    public ArrayList<Student> getThreeBestStudentd(Staff onyCourse){
        ArrayList<Student> studentArrayList = new ArrayList<>();
        for (Person person :
                onyCourse.getStudlist()) {
            if (person.getClass() == Student.class)
                studentArrayList.add((Student)person);
        }
        Collections.sort(studentArrayList, snordereByAvg);
        ArrayList<Student> threeBestStudents = new ArrayList<>();
        for (int i = 0; i < 3; i++)
            threeBestStudents.add(studentArrayList.get(i));
        return threeBestStudents;
    }
}
