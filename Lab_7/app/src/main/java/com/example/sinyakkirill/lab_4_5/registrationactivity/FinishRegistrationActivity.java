package com.example.sinyakkirill.lab_4_5.registrationactivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sinyakkirill.lab_4_5.R;
import com.example.sinyakkirill.lab_4_5.appdatabase.AppDataBase;
import com.example.sinyakkirill.lab_4_5.hash.MD5Hash;

public class FinishRegistrationActivity extends AppCompatActivity {

    String Name;
    String Surname;
    String Patronymic;
    String[] BDay;
    String City;
    String Country;
    String Login;
    String Password;

    TextView nameSurStudentTextView;
    TextView bdayTextView;
    TextView locationTextView;

    AppDataBase mAppDataBase;
    SQLiteDatabase db;


    Button prevPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_registration);

        mAppDataBase = new AppDataBase(this);
        db = mAppDataBase.getWritableDatabase();

        //get date from INTENT
        Name = getIntent().getStringExtra("name");
        Surname = getIntent().getStringExtra("surname");
        Patronymic = getIntent().getStringExtra("patronymic");
        BDay = getIntent().getStringArrayExtra("bday");
        City = getIntent().getStringExtra("city");
        Country = getIntent().getStringExtra("country");
        Login = getIntent().getStringExtra("login");
        Password = getIntent().getStringExtra("password");

        nameSurStudentTextView = (TextView) findViewById(R.id.nameSurStudentTextView);
        bdayTextView = (TextView) findViewById(R.id.bdayTextView);
        locationTextView = (TextView)findViewById(R.id.locationTextView);

        nameSurStudentTextView.setText(Surname + " " + Name + " " + Patronymic);
        bdayTextView.setText(BDay[0] + "." + BDay[1] + "." + BDay[2]);
        locationTextView.setText(Country + ", " + City);

        /*prevPage = (Button)findViewById(R.id.prevPage);
        prevPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {            }
        });*/
    }

    public void prevPage(View view){
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

    @Override
    public void onBackPressed() {
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
        //overridePendingTransition();
    }

    public void singUp(View view){
        Log.d("Lab_5", "button singUp");
        Log.d("Lab_5", MD5Hash.md5Custom(Password));
        ContentValues values = new ContentValues();
        //values.put("ID", 1);
        values.put("name", Name);
        values.put("surname", Surname);
        values.put("patronymic", Patronymic);
        values.put("bday", BDay[0] + "-" + BDay[1] + "-" + BDay[2]);
        values.put("city", City);
        values.put("country", Country);
        values.put("login", Login);
        values.put("password", MD5Hash.md5Custom(Password));
        //values.putNull("avgmark");
        long rowid = db.insert("Students", null, values);
        Log.d("Lab_5", "inserted new Student in table, rowid = " + rowid);
        //deleteDatabase("AppDataBase");
        Log.d("Lab_5", "______________________________________");
        Cursor cursor = db.rawQuery("Select surname, name, patronymic, bday, city, country, login, password, awgmark " +
                        "from Students", null);
        if(cursor.moveToFirst()){
            do{
                Log.d("Lab_5", cursor.getString(1) + "  " +
                        cursor.getString(2) + "  " +
                        cursor.getString(4) + "  " +
                        cursor.getString(5) + "  " +
                        cursor.getString(6) + "  " +
                        cursor.getString(7));
            }while (cursor.moveToNext());
        }
        Log.d("Lab_5", "______________________________________");
        finish();
    }

}
