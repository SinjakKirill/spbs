package com.example.sinyakkirill.lab_4_5.adminactivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.SearchManager;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.CallSuper;
import android.support.design.widget.FloatingActionButton;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sinyakkirill.lab_4_5.LoginActivity;
import com.example.sinyakkirill.lab_4_5.R;
import com.example.sinyakkirill.lab_4_5.fragments.ListStudent;
import com.example.sinyakkirill.lab_4_5.fragments.StudentDetail;
import com.example.sinyakkirill.lab_4_5.units.Student;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class AdminActivity extends AppCompatActivity implements ListStudent.onStudentSelectedItem {

    //список студентов для обработки
    public static ArrayList<Student> ArrIndexStudentDelete;

    @Override
    public void onStart(){
        super.onStart();
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        ArrIndexStudentDelete = new ArrayList<>();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ArrIndexStudentDelete.size() != 0){
                    String message = new String();
                    for (Student student :
                            ArrIndexStudentDelete) {
                        message += student.getSurname() + " " + student.getName() + " " + student.getPatronymic() + "\n";
                    }
                    Intent openlinkIntent = new Intent(Intent.ACTION_SEND);
                    openlinkIntent.setType("plain/text");
                    //openlinkIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"sinjak.kirill@gmail.com"});
                    openlinkIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Information about students.");
                    openlinkIntent.putExtra(Intent.EXTRA_TEXT, message);
                    startActivity(openlinkIntent);
                }
                else{
                    Snackbar.make(view, "Select Students!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.admin_menu, menu);

        //MenuItem searchItem = menu.findItem(R.id.action_search);

        MenuItem search = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(search);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ListStudent.adapter.getFilter().filter(newText);
                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.deleteMenu:
                int countDeleted = 0;
                for (Student student :
                        ArrIndexStudentDelete) {
                    long rowid = LoginActivity.sDb.delete("Students", "login = ?", new String[]{student.getLogin()});
                    if(rowid == 1)
                        countDeleted++;
                }
                ListStudent.refreshListView();
                Log.d("Lab_7", "Count deleted Students = " + countDeleted);
                return true;
            case R.id.sortByFullnameMenu:
                Collections.sort(ListStudent.studentArrayList, new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return o1.getSurname().compareTo(o2.getSurname());
                    }
                });
                ListStudent.adapter.notifyDataSetChanged();
                return true;
            case R.id.sortByBDayMenu:
                return true;
            case R.id.exitMenu:
                this.finish();
                return true;
            case R.id.copyMenu:
                if(ArrIndexStudentDelete.size() != 0){
                    String copyInformation = new String();
                    for (Student student :
                            ArrIndexStudentDelete) {
                        copyInformation += student.getSurname() + " " + student.getName() + " " + student.getPatronymic() + "\n";
                    }
                    ((ClipboardManager) getApplicationContext().getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setText(copyInformation);
                    Toast.makeText(getApplicationContext(), "Copy!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Select Students!", Toast.LENGTH_SHORT).show();
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setInndex(Student student) {
        ArrIndexStudentDelete.add(student);
        Log.d("Lab_7", "setIndex = " + student.getSurname() + " , number Students in array = " + ArrIndexStudentDelete.size());
    }

    @Override
    public void unCheckIndex(Student student) {
        ArrIndexStudentDelete.remove(student);
        Log.d("Lab_7", "unCheck index = " + student.getSurname() + " , number Students in array = " + ArrIndexStudentDelete.size());
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
