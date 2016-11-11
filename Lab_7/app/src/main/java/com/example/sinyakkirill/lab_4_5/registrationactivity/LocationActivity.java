package com.example.sinyakkirill.lab_4_5.registrationactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sinyakkirill.lab_4_5.R;

import static com.example.sinyakkirill.lab_4_5.registrationactivity.RegistrationFullNameActivity.diologCancellationOfRegistration;

public class LocationActivity extends AppCompatActivity {

    String Name;
    String Surname;
    String Patronymic;
    String[] BDay;
    String City;
    String Country;
    String Login;
    String Password;

    EditText countryEditText;
    EditText cityEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        //get date from INTENT
        Name = getIntent().getStringExtra("name");
        Surname = getIntent().getStringExtra("surname");
        Patronymic = getIntent().getStringExtra("patronymic");
        BDay = getIntent().getStringArrayExtra("bday");
        City = getIntent().getStringExtra("city");
        Country = getIntent().getStringExtra("country");
        Login = getIntent().getStringExtra("login");
        Password = getIntent().getStringExtra("password");

        countryEditText = (EditText) findViewById(R.id.countryEditText);
        cityEditText = (EditText) findViewById(R.id.cityEditText);

        InputFilter inputFilter = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                if(source.equals("")){
                    return source;
                }
                if(source.toString().matches("[a-zA-Z]+")){
                    return source;
                }
                return "";
            }
        };

        countryEditText.setFilters(new InputFilter[]{inputFilter});
        cityEditText.setFilters(new InputFilter[]{inputFilter});

        if(Country != null)
            countryEditText.setText(Country);
        if(City != null)
            cityEditText.setText(City);
    }

    public void prevPage(View view){

        City = cityEditText.getText().toString();
        Country = countryEditText.getText().toString();

        Intent intent = new Intent(this, BdayActivity.class);
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

    public void nextPage(View view){
        City = cityEditText.getText().toString();
        Country = countryEditText.getText().toString();

        Intent intent = new Intent(this, LoginAndPasswordActivity.class);
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

        City = cityEditText.getText().toString();
        Country = countryEditText.getText().toString();

        Intent intent = new Intent(this, BdayActivity.class);
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
}
