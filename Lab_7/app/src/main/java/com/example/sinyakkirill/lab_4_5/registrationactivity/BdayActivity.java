package com.example.sinyakkirill.lab_4_5.registrationactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sinyakkirill.lab_4_5.R;
import com.example.sinyakkirill.lab_4_5.units.Student;

import static com.example.sinyakkirill.lab_4_5.registrationactivity.RegistrationFullNameActivity.diologCancellationOfRegistration;

public class BdayActivity extends AppCompatActivity {

    String Name;
    String Surname;
    String Patronymic;
    String[] BDay;
    String City;
    String Country;
    String Login;
    String Password;

    Student student;


    EditText dayEditText;
    EditText monthEditText;
    EditText yearEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bday);

        //get date from INTENT
        Name = getIntent().getStringExtra("name");
        Surname = getIntent().getStringExtra("surname");
        Patronymic = getIntent().getStringExtra("patronymic");
        BDay = getIntent().getStringArrayExtra("bday");
        City = getIntent().getStringExtra("city");
        Country = getIntent().getStringExtra("country");
        Login = getIntent().getStringExtra("login");
        Password = getIntent().getStringExtra("password");

        student = (Student) getIntent().getParcelableExtra(Student.class.getCanonicalName());

        dayEditText = (EditText) findViewById(R.id.dayEditText);
        monthEditText = (EditText) findViewById(R.id.monthEditText);
        yearEditText = (EditText) findViewById(R.id.yearEditText);

        if(student != null){
            dayEditText.setText(String.valueOf(student.getBday().getDay()));
            monthEditText.setText(String.valueOf(student.getBday().getMonth()));
            yearEditText.setText(String.valueOf(student.getBday().getYear()));
        }

        if(BDay != null){
            dayEditText.setText(BDay[0]);
            monthEditText.setText(BDay[1]);
            yearEditText.setText(BDay[2]);
        }

        /*Toast toast = Toast.makeText(getApplicationContext(),
                Surname + " " + Name + " " + Patronymic + " ", Toast.LENGTH_SHORT);
        toast.show();*/
    }

    public void prevPage(View view){
        BDay = new String[3];
        BDay[0] = dayEditText.getText().toString();
        BDay[1] = monthEditText.getText().toString();
        BDay[2] = yearEditText.getText().toString();

        Intent intent = new Intent(this, RegistrationFullNameActivity.class);
        intent.putExtra("name", Name);
        intent.putExtra("surname", Surname);
        intent.putExtra("patronymic", Patronymic);
        intent.putExtra("bday", BDay);
        intent.putExtra("city", City);
        intent.putExtra("country", Country);
        intent.putExtra("login", Login);
        intent.putExtra("password", Password);
        startActivity(intent);
        this.finish();
    }

    public void cancelRegistration(View view){
        diologCancellationOfRegistration(this);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, RegistrationFullNameActivity.class);
        intent.putExtra("name", Name);
        intent.putExtra("surname", Surname);
        intent.putExtra("patronymic", Patronymic);
        intent.putExtra("bday", BDay);
        intent.putExtra("city", City);
        intent.putExtra("country", Country);
        intent.putExtra("login", Login);
        intent.putExtra("password", Password);
        startActivity(intent);
        this.finish();
    }

    public void nextPage(View view) {
        BDay = new String[3];

        if(!dayEditText.getText().toString().equals("") && !monthEditText.getText().toString().equals("") && !yearEditText.getText().toString().equals("")) {
            BDay[0] = dayEditText.getText().toString();
            BDay[1] = monthEditText.getText().toString();
            BDay[2] = yearEditText.getText().toString();
            Intent intent = new Intent(this, LocationActivity.class);
            intent.putExtra("name", Name);
            intent.putExtra("surname", Surname);
            intent.putExtra("patronymic", Patronymic);
            intent.putExtra("bday", BDay);
            intent.putExtra("city", City);
            intent.putExtra("country", Country);
            intent.putExtra("login", Login);
            intent.putExtra("password", Password);
            startActivity(intent);
            this.finish();
        }
        else{
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Enter your birthday!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

}
