package com.example.sinyakkirill.lab_1_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < 4; i++) {

        }
        TextFunction1 textFunction1;
        Log.d("Error", "Hello");
        TextView newText = (TextView) findViewById(R.id.NewText);
        newText.setText("goodbye!");
    }

    //TODO Hello!
}
