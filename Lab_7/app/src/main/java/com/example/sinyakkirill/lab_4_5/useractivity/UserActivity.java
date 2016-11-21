package com.example.sinyakkirill.lab_4_5.useractivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sinyakkirill.lab_4_5.LoginActivity;
import com.example.sinyakkirill.lab_4_5.R;
import com.example.sinyakkirill.lab_4_5.appdatabase.AppDataBase;

public class UserActivity extends AppCompatActivity {

    EditText surnameEditText;
    EditText nameEditText;
    EditText patronymicEditText;
    EditText countryEditText;
    EditText cityEditText;

    AppDataBase mAppDataBase;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Box");
        mAppDataBase = new AppDataBase(this);
        db = mAppDataBase.getWritableDatabase();

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

        surnameEditText.setInputType(0x0);
        nameEditText.setInputType(0x0);
        patronymicEditText.setInputType(0x0);
        countryEditText.setInputType(0x0);
        cityEditText.setInputType(0x0);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.saveMenu:
                item.setChecked(true);
                if(surnameEditText.getInputType() == 0x0){
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Select change!", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    if(!surnameEditText.getText().toString().equals("") &&
                            !nameEditText.getText().toString().equals("") &&
                            !patronymicEditText.getText().toString().equals("") &&
                            !countryEditText.getText().toString().equals("") &&
                            !cityEditText.getText().toString().equals("")){

                        surnameEditText.setInputType(0x0);
                        nameEditText.setInputType(0x0);
                        patronymicEditText.setInputType(0x0);
                        countryEditText.setInputType(0x0);
                        cityEditText.setInputType(0x0);
                        ContentValues values = new ContentValues();
                        values.put("name", nameEditText.getText().toString());
                        values.put("surname", surnameEditText.getText().toString());
                        values.put("patronymic", patronymicEditText.getText().toString());
                        values.put("country", countryEditText.getText().toString());
                        values.put("city", cityEditText.getText().toString());
                        int count = db.update("Students", values, "login = ?", new String[]{LoginActivity.sStudent.getLogin()});
                        Log.d("Lab_7", "update data in Students table, count = " + count);
                        Snackbar.make(findViewById(R.id.content_user), "Personal information updated.", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                    else{
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Input data!", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
                return true;
            case R.id.changeMenu:
                item.setChecked(true);
                surnameEditText.setInputType(0x1);
                nameEditText.setInputType(0x1);
                patronymicEditText.setInputType(0x1);
                countryEditText.setInputType(0x1);
                cityEditText.setInputType(0x1);
                Snackbar.make(findViewById(R.id.content_user), "Personal information edit mode.", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
                return true;
            case R.id.exitMenu:
                item.setChecked(true);
                LoginActivity.sStudent = null;
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
