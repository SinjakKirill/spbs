package com.example.sinyakkirill.lab_4_5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.sinyakkirill.lab_4_5.registrationactivity.RegistrationFullNameActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void registracionStudent(View view){
        Intent intent = new Intent(this, RegistrationFullNameActivity.class);
        startActivity(intent);
    }

}
