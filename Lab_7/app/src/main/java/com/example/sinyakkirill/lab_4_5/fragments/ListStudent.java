package com.example.sinyakkirill.lab_4_5.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.ListFragment;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sinyakkirill.lab_4_5.LoginActivity;
import com.example.sinyakkirill.lab_4_5.R;
import com.example.sinyakkirill.lab_4_5.adminactivity.AdminDetailActivity;
import com.example.sinyakkirill.lab_4_5.units.Student;

import java.util.ArrayList;

/**
 * Created by Sinyak Kirill on 17.11.2016.
 */

public class ListStudent extends ListFragment {
    String data[] = new String[] { "one", "two", "three", "four" };

    TextView fullNameTextView;
    TextView locationTextView;
    TextView emailTextView;
    TextView bdayTextView;

    View item;

    ArrayList<Student> studentArrayList;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        /*item =  getActivity().findViewById(R.id.deleteMenu);

        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(), "XXX", Toast.LENGTH_LONG).show();
            }
        });*/

        fullNameTextView = (TextView) getActivity().findViewById(R.id.fullNameTextView);
        locationTextView = (TextView) getActivity().findViewById(R.id.locationTextView);
        emailTextView = (TextView) getActivity().findViewById(R.id.emaiTextView);
        bdayTextView = (TextView) getActivity().findViewById(R.id.bdayTextView);

        studentArrayList = new ArrayList<>();
        Cursor cursor = LoginActivity.sDb.rawQuery("Select surname, name, patronymic, bday, city, country, login from Students", null);
        if(cursor.moveToFirst()){
            Log.d("Lab_7", "number Students = " + cursor.getCount());
            do{
                studentArrayList.add(new Student(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6)));
            } while(cursor.moveToNext());
        }


        ArrayAdapter<Student> adapter = new ArrayAdapter<Student>(getActivity(),
                android.R.layout.simple_list_item_multiple_choice, studentArrayList);
        setListAdapter(adapter);

        ListView groupListView = getListView();
        getActivity().registerForContextMenu(groupListView);

        getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        getListView().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                StudentDetail fragment = (StudentDetail) getFragmentManager().findFragmentById(R.id.fragment_detail);
                if (fragment != null && fragment.isInLayout()) {
                    fullNameTextView.setText(studentArrayList.get(position).getSurname() + " " +
                            studentArrayList.get(position).getName() + " " +
                            studentArrayList.get(position).getPatronymic());
                    locationTextView.setText(studentArrayList.get(position).getCountry() + ", " + studentArrayList.get(position).getCity());
                    bdayTextView.setText(studentArrayList.get(position).getBday());
                    emailTextView.setText(studentArrayList.get(position).getLogin());
                }
                getListView().setItemChecked(position, true);
                return true;
            }
        });
    }

    //android:choiceMode="multipleChoice"

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment, null);
    }


    /*@Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.delete:
                Toast.makeText(getActivity().getApplicationContext(), "Delete", Toast.LENGTH_LONG);
                return true;
            case R.id.update:
                Toast.makeText(getActivity().getApplicationContext(), "update", Toast.LENGTH_LONG);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }*/

    //выполняется при нажатии на фрагмент(имя и фамилия студента)
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        //выполняется получение fragment detail, чтобы определить ориентацию экрана
        StudentDetail fragment = (StudentDetail) getFragmentManager().findFragmentById(R.id.fragment_detail);
        if (fragment != null && fragment.isInLayout()) {
            Log.d("Lab_7", "horizontal");
            getListView().setItemChecked(position, false);
            fullNameTextView.setText(studentArrayList.get(position).getSurname() + " " +
                    studentArrayList.get(position).getName() + " " +
                    studentArrayList.get(position).getPatronymic());
            locationTextView.setText(studentArrayList.get(position).getCountry() + ", " + studentArrayList.get(position).getCity());
            bdayTextView.setText(studentArrayList.get(position).getBday());
            emailTextView.setText(studentArrayList.get(position).getLogin());

        } else {
            getListView().setItemChecked(position, false);
            Log.d("Lab_7", "vertical");
            //Intent intent = new Intent(getActivity().getApplicationContext(), AdminDetailActivity.class);
            //intent.putExtra("selectedValue", item);
            //startActivity(intent);
        }
    }

}
