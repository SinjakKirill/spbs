package com.example.sinyakkirill.lab_4_5.registrationactivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sinyakkirill.lab_4_5.R;
import com.example.sinyakkirill.lab_4_5.appdatabase.AppDataBase;

public class LoginAndPasswordActivity extends AppCompatActivity {

    String Name;
    String Surname;
    String Patronymic;
    String[] BDay;
    String City;
    String Country;
    String Login;
    String Password;

    EditText LoginEditText;
    EditText PasswordEditText;

    AppDataBase mAppDataBase;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_and_password);

        mAppDataBase = new AppDataBase(this);
        db = mAppDataBase.getWritableDatabase();

        LoginEditText = (EditText) findViewById(R.id.loginEditText);
        PasswordEditText = (EditText) findViewById(R.id.passwordEditText);

        Name = getIntent().getStringExtra("name");
        Surname = getIntent().getStringExtra("surname");
        Patronymic = getIntent().getStringExtra("patronymic");
        BDay = getIntent().getStringArrayExtra("bday");
        City = getIntent().getStringExtra("city");
        Country = getIntent().getStringExtra("country");
        Login = getIntent().getStringExtra("login");
        Password = getIntent().getStringExtra("password");

        LoginEditText.setText(Login);
        PasswordEditText.setText(Password);

    }

    public void prevPage(View view){

        Login = LoginEditText.getText().toString();
        Password = PasswordEditText.getText().toString();

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

    public void nextPage(View view){
        Login = LoginEditText.getText().toString();
        Password = PasswordEditText.getText().toString();

        Cursor cursor = db.rawQuery("Select login from Students where login = ?", new String[]{LoginEditText.getText().toString()});
        //Cursor cursor = db.rawQuery("Select id, login from Students",null);

        if(cursor.moveToFirst()){
            Log.d("Lab_5", cursor.getString(0));
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Student already have", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            if(!LoginEditText.getText().toString().equals("") && !PasswordEditText.getText().toString().equals("")) {
                Intent intent = new Intent(this, FinishRegistrationActivity.class);
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
                        "Enter Login and Password!s", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
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
}
