package com.example.sinyakkirill.lab_4_5.useractivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sinyakkirill.lab_4_5.LoginActivity;
import com.example.sinyakkirill.lab_4_5.R;

public class UserActivity extends AppCompatActivity {

    EditText surnameEditText;
    EditText nameEditText;
    EditText patronymicEditText;
    EditText countryEditText;
    EditText cityEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Box");

        surnameEditText = (EditText) findViewById(R.id.surnameEditText);
        nameEditText = (EditText) findViewById(R.id.nameEditText);
        patronymicEditText = (EditText) findViewById(R.id.patronymicEditText);
        countryEditText = (EditText) findViewById(R.id.countryEditText);
        cityEditText = (EditText) findViewById(R.id.cityEditText);

        surnameEditText.setText(LoginActivity.sStudent.getSurname());
        nameEditText.setText(LoginActivity.sStudent.getName());
        patronymicEditText.setText(LoginActivity.sStudent.getPatronymic());
        countryEditText.setText(LoginActivity.sStudent.getCountry());
        cityEditText.setText(LoginActivity.sStudent.getCity());

        surnameEditText.setInputType(0x00000000);
        nameEditText.setInputType(0x00000000);
        patronymicEditText.setInputType(0x00000000);
        countryEditText.setInputType(0x00000000);
        cityEditText.setInputType(0x00000000);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Toast toast = Toast.makeText(getApplicationContext(),
                        "Пора покормить кота!", Toast.LENGTH_SHORT);
                toast.show();*/
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
                PhoneNumberUtils phoneNumberUtils = new PhoneNumberUtils();

                Intent openlinkIntent = new Intent(Intent.ACTION_SEND);
                openlinkIntent.setType("plain/text");

                openlinkIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"sinjak.kirill@gmail.com"});
                openlinkIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
                        "laba 8 - 9");
                openlinkIntent.putExtra(Intent.EXTRA_TEXT, "I love you!");

                startActivity(openlinkIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_menu, menu);
        return true;
    }

}
