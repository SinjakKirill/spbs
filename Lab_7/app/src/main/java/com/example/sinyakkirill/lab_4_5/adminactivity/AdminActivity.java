package com.example.sinyakkirill.lab_4_5.adminactivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sinyakkirill.lab_4_5.R;
import com.example.sinyakkirill.lab_4_5.fragments.ListStudent;

public class AdminActivity extends AppCompatActivity {

    //ListStudent mListStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        /*ListStudent myFragment = new ListStudent();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().add(R.id.activity_admin, myFragment).addToBackStack("myFragment").commit();*/

        /*Fragment fragment = fragmentManager.findFragmentByTag("myFragment");
        ListStudent l = (ListStudent) fragment;
        l.getListView();*/
        /*if(listView != null){
            Toast.makeText(getApplicationContext(), "ListView NULL!", Toast.LENGTH_LONG);
        }
        else {
            Toast.makeText(getApplicationContext(), "ListView count = ", Toast.LENGTH_LONG);
        }*/

        //mListStudent = new ListStudent();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.admin_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.deleteMenu:
                //mListStudent.getListView();
                //Fragment fragment = (Fragment) findViewById(R.id.adminListStudentFragment);
                return true;
            case R.id.sortByFullnameMenu:
                return true;
            case R.id.sortByBDayMenu:
                return true;
            case R.id.exitMenu:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
