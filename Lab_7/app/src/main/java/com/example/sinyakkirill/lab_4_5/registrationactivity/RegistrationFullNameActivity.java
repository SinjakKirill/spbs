package com.example.sinyakkirill.lab_4_5.registrationactivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sinyakkirill.lab_4_5.R;
import com.example.sinyakkirill.lab_4_5.registrationactivity.BdayActivity;
import com.example.sinyakkirill.lab_4_5.units.Student;

public class RegistrationFullNameActivity extends AppCompatActivity {

    String Name;
    String Surname;
    String Patronymic;
    String[] BDay;
    String City;
    String Country;
    String Login;
    String Password;

    //Student student;


    EditText surnameEditText;
    EditText nameEditText;
    EditText patronymicEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_full_name);

        surnameEditText = (EditText) findViewById(R.id.surnameEditText);
        nameEditText = (EditText) findViewById(R.id.nameEditText);
        patronymicEditText = (EditText) findViewById(R.id.patronymicEditText);
        //BDay = new String[3];

        //student = (Student) getIntent().getParcelableExtra(Student.class.getCanonicalName());

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

        surnameEditText.setFilters(new InputFilter[]{inputFilter});
        nameEditText.setFilters(new InputFilter[]{inputFilter});
        patronymicEditText.setFilters(new InputFilter[]{inputFilter});

        //get date from INTENT
        Name = getIntent().getStringExtra("name");
        Surname = getIntent().getStringExtra("surname");
        Patronymic = getIntent().getStringExtra("patronymic");
        BDay = getIntent().getStringArrayExtra("bday");
        City = getIntent().getStringExtra("city");
        Country = getIntent().getStringExtra("country");
        Login = getIntent().getStringExtra("login");
        Password = getIntent().getStringExtra("password");

        surnameEditText.setText(Surname);
        nameEditText.setText(Name);
        patronymicEditText.setText(Patronymic);
    }

    public void cancelRegistration(View view){
        diologCancellationOfRegistration(this);
    }

    public void nextPage(View view){
        if(!nameEditText.getText().toString().equals("") && !surnameEditText.getText().toString().equals("") && !patronymicEditText.getText().toString().equals("")) {
            Intent intent = new Intent(this, BdayActivity.class);
            intent.putExtra("surname", surnameEditText.getText().toString());
            intent.putExtra("name", nameEditText.getText().toString());
            intent.putExtra("patronymic", patronymicEditText.getText().toString());
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
                    "Enter surname, name and patronymic!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void prevPage(View view){
        diologCancellationOfRegistration(this);
    }

    @Override
    public void onBackPressed() {
        diologCancellationOfRegistration(this);
    }

    public static void diologCancellationOfRegistration(final AppCompatActivity compatActivity){
        AlertDialog.Builder builder = new AlertDialog.Builder(compatActivity);
        builder.setMessage("Cancellation of registration?")
                .setCancelable(false)
                .setPositiveButton("Yes!",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int id) {
                                compatActivity.finish();
                                dialog.cancel();
                            }
                        })
                .setNeutralButton("No!",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int id) {
                                dialog.cancel();
                            }
                        });
        builder.create().show();
    }

}
