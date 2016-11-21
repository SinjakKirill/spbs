package com.example.sinyakkirill.lab_4_5.units;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateFormat;
import android.util.Log;

import java.sql.Date;
import java.util.Comparator;

/**
 * Created by Sinyak Kirill on 27.09.2016.
 */

public class Student extends Person {

    public Student(String Surname, String Name, String Patronymic, String bday, String City, String Country, String Login){
        super(Surname, Name, Patronymic);
        this.City = City;
        this.Country = Country;
        this.Login = Login;
        this.bday = bday;
    }

    /*public Student(String Surname, String Name, String Patronymic, String Login){
        super(Surname, Name, Patronymic);
        this.avgMark = 0.0f;
        this.Password = new String();
        this.Login = Login;
    };*/

    public Student(String Surname, String Name, String bdayDDMMYY, float avgMark) {
        super(Surname, Name, bdayDDMMYY);
        this.avgMark = avgMark;
    }

    public Student(String Surname, String Name, String Patronymic, String bdayDDMMYY, float avgMark) {
        super(Surname, Name, Patronymic, bdayDDMMYY);
        this.avgMark = avgMark;
    }

    /*public Student(Parcel in) {
        super(in.readString(), in.readString(), in.readString());
        int[] bday = new int[3];
        in.readIntArray(bday);
        this.bday = bday;
        this.avgMark = in.readFloat();
        this.Login = in.readString();
    }*/

    private float avgMark;
    private String Login;
    private String Password;
    private String Country;
    private String City;

    public Student(String Surname, String Name, String Patronymic, String bday, String City, String Country, String Login, String Password) {
        super(Surname, Name, Patronymic, bday);
        this.City = City;
        this.Country = Country;
        this.Login = Login;
        this.Password = Password;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public void setAvgMark(float avgMark) {
        this.avgMark = avgMark;
    }

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

    public float getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(int avgMark) {
        this.avgMark = avgMark;
    }

    public static Comparator<Student> snordereByAvg = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            if (o1.avgMark > o2.avgMark)
                return -1;
            if (o1.avgMark < o2.avgMark)
                return 1;
            return 0;
        }
    };

    /*@Override
    public int describeContents() {
        return 0;
    }

    // упаковываем объект в Parcel
    public void writeToParcel(Parcel parcel, int flags) {
        Log.d("Lab_5", "writeToParcel");
        parcel.writeString(this.getSurname());
        parcel.writeString(this.getName());
        parcel.writeString(this.getPatronymic());
        parcel.writeIntArray(this.getBday());
        parcel.writeString(this.Login);
        parcel.writeString(this.Password);
        parcel.writeFloat(this.avgMark);
    }

    public static final Parcelable.Creator<Student> CREATOR = new Parcelable.Creator<Student>() {
        // распаковываем объект из Parcel
        public Student createFromParcel(Parcel in) {
            Log.d("Lab_5", "createFromParcel");
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };*/

    @Override
    public String toString() {
        return this.Surname + " " + this.Name;
    }
}
