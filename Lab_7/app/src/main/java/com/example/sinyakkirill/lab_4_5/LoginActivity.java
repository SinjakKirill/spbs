package com.example.sinyakkirill.lab_4_5;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sinyakkirill.lab_4_5.adminactivity.AdminActivity;
import com.example.sinyakkirill.lab_4_5.appdatabase.AppDataBase;
import com.example.sinyakkirill.lab_4_5.hash.MD5Hash;
import com.example.sinyakkirill.lab_4_5.registrationactivity.RegistrationFullNameActivity;
import com.example.sinyakkirill.lab_4_5.units.Student;
import com.example.sinyakkirill.lab_4_5.useractivity.UserActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    //  save Logout Change

    final private String adminLogin = "admin";
    final private String adminPassword = "admin";

    public static Student sStudent;

    EditText loginEditText;
    EditText passwordEditText;

    AppDataBase mAppDataBase;
    public static SQLiteDatabase sDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAppDataBase = new AppDataBase(this);
        sDb = mAppDataBase.getWritableDatabase();

        loginEditText = (EditText) findViewById(R.id.loginEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);

        loginEditText.setText("admin");
        passwordEditText.setText("admin");

    }

    public void registracionStudent(View view){
        Intent intent = new Intent(this, RegistrationFullNameActivity.class);
        startActivity(intent);
    }

    public void singIn(View view){

        if(loginEditText.getText().toString().equals(adminLogin) && passwordEditText.getText().toString().equals(adminPassword)) {
            Intent intent = new Intent(this, AdminActivity.class);
            startActivity(intent);
        }else{
            Pattern p = Pattern.compile("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$");
            Matcher m = p.matcher(loginEditText.getText().toString());
            if (m.matches()) {
                Cursor cursor = sDb.rawQuery("Select surname, name, patronymic, bday, city, country, login, password, awgmark " +
                        "from Students where login = ?", new String[]{loginEditText.getText().toString()});
                if (cursor.moveToFirst()) {

                    LoginActivity.sStudent = new Student(cursor.getString(0),
                            cursor.getString(1),
                            cursor.getString(2),
                            cursor.getString(4),
                            cursor.getString(5),
                            cursor.getString(6),
                            cursor.getString(7));

                    Log.d("Lab_5", cursor.getString(0) + "  " +
                            cursor.getString(1) + "  " +
                            cursor.getString(2) + "  " +
                            cursor.getString(4) + "  " +
                            cursor.getString(5) + "  " +
                            cursor.getString(6) + "  " +
                            cursor.getString(7));

                    if (sStudent.getPassword().equals(MD5Hash.md5Custom(passwordEditText.getText().toString()))) {
                        Intent intent = new Intent(this, UserActivity.class);
                        startActivity(intent);
                    } else {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Incorrect password!", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "User does not exist!", Toast.LENGTH_SHORT);
                    toast.show();
                }
            } else {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Incorrect email!", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }

}
