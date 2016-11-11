package com.example.sinyakkirill.lab_4_5.units;

import java.util.Comparator;

/**
 * Created by Sinyak Kirill on 27.09.2016.
 */

public class Student extends Person {

    public Student(String Surname, String Name, int[] bdayDDMMYY, float avgMark){
        super(Surname, Name, bdayDDMMYY);
        this.avgMark = avgMark;
    }

    public Student(String Surname, String Name, String Patronymic, int[] bdayDDMMYY, float avgMark){
        super(Surname, Name, Patronymic, bdayDDMMYY);
        this.avgMark = avgMark;
    }

    private float avgMark;

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    private String Login;
    private String Password;

    public float getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(int avgMark) {
        this.avgMark = avgMark;
    }

    public static Comparator<Student> snordereByAvg = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            if(o1.avgMark > o2.avgMark)
                return -1;
            if(o1.avgMark < o2.avgMark)
                return 1;
            return 0;
        }
    };
}
