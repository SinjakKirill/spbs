package com.example.sinyakkirill.lab_4_5;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.sinyakkirill.lab_4_5.RegistrationFullNameActivity.diologCancellationOfRegistration;

public class BdayActivity extends AppCompatActivity {

    String Name;
    String Surname;
    String Patronymic;
    String[] BDay;
    String City;
    String Country;


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

        dayEditText = (EditText) findViewById(R.id.dayEditText);
        monthEditText = (EditText) findViewById(R.id.monthEditText);
        yearEditText = (EditText) findViewById(R.id.yearEditText);

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
        startActivity(intent);
        this.finish();
    }

    public void nextPage(View view) {
        BDay = new String[3];
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
        startActivity(intent);
        this.finish();
    }

}
