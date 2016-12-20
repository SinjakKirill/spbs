package com.example.sinyakkirill.lab_4_5.adminactivity;

import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.sinyakkirill.lab_4_5.R;
import com.example.sinyakkirill.lab_4_5.fragments.StudentDetail;

public class AdminDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_detail);

        Intent intent = getIntent();

        if(intent != null){
            //Toast.makeText(getApplicationContext(), "Intent not NULL", Toast.LENGTH_SHORT).show();
            StudentDetail firstFragment = new StudentDetail();
            Bundle bundle = new Bundle();
            bundle.putString("fullname", intent.getStringExtra("fullname"));
            bundle.putString("bday", intent.getStringExtra("bday"));
            bundle.putString("location", intent.getStringExtra("location"));
            bundle.putString("login", intent.getStringExtra("login"));
            firstFragment.setArguments(bundle);
            int i = getFragmentManager().beginTransaction().replace(R.id.fragment_container, firstFragment).addToBackStack("myFragment").commit();
        }
    }


}
