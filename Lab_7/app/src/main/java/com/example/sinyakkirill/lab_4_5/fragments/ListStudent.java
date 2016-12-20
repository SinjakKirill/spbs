package com.example.sinyakkirill.lab_4_5.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sinyakkirill.lab_4_5.LoginActivity;
import com.example.sinyakkirill.lab_4_5.R;
import com.example.sinyakkirill.lab_4_5.adminactivity.AdminActivity;
import com.example.sinyakkirill.lab_4_5.adminactivity.AdminDetailActivity;
import com.example.sinyakkirill.lab_4_5.units.Student;

import java.util.ArrayList;

/**
 * Created by Sinyak Kirill on 17.11.2016.
 */

public class ListStudent extends ListFragment {

    TextView fullNameTextView;
    TextView locationTextView;
    TextView emailTextView;
    TextView bdayTextView;
    public static ArrayAdapter<Student> adapter;

    public static ArrayList<Student> studentArrayList;
    onStudentSelectedItem mCallback;

    public interface onStudentSelectedItem{
        public void setInndex(Student student);
        public void unCheckIndex(Student student);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setRetainInstance(true);

        fullNameTextView = (TextView) getActivity().findViewById(R.id.fullNameTextView);
        locationTextView = (TextView) getActivity().findViewById(R.id.locationTextView);
        emailTextView = (TextView) getActivity().findViewById(R.id.emailTextView);
        bdayTextView = (TextView) getActivity().findViewById(R.id.bdayTextView);

        studentArrayList = new ArrayList<>();
        Cursor cursor = LoginActivity.sDb.rawQuery("Select surname, name, patronymic, bday, city, country, login from Students", null);
        if(cursor.moveToFirst()){
            Log.d("Lab_7", "number Students = " + cursor.getCount());
            do{
                studentArrayList.add(new Student(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6)));
            } while(cursor.moveToNext());
        }



        adapter = new ArrayAdapter<Student>(getActivity(),
                android.R.layout.simple_list_item_multiple_choice, studentArrayList);
        setListAdapter(adapter);

        ListView groupListView = getListView();
        getActivity().registerForContextMenu(groupListView);

        getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        getListView().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                SparseBooleanArray sparseBooleanArray = getListView().getCheckedItemPositions();
                if(!sparseBooleanArray.get(position)){
                    mCallback = (onStudentSelectedItem) getActivity();
                    mCallback.setInndex(studentArrayList.get(position));
                }
                getListView().setItemChecked(position, true);
                return true;
            }
        });

        if(studentArrayList.size() != 0 && getActivity().findViewById(R.id.fragment_container) != null){
            StudentDetail firstFragment = new StudentDetail();
            Bundle bundle = new Bundle();
            bundle.putString("fullname", studentArrayList.get(0).getSurname() + " " +
                    studentArrayList.get(0).getName() + " " +
                    studentArrayList.get(0).getPatronymic());
            bundle.putString("bday", studentArrayList.get(0).getBday());
            bundle.putString("location", studentArrayList.get(0).getCity() + ", " + studentArrayList.get(0).getCountry());
            bundle.putString("login", studentArrayList.get(0).getLogin());
            //
            firstFragment.setArguments(bundle);
            int i = getFragmentManager().beginTransaction().replace(R.id.fragment_container, firstFragment).addToBackStack("myFragment").commit();

        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment, null);
    }

    //выполняется при нажатии на фрагмент(имя и фамилия студента)
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        //отмена выбора студента для удаления
        mCallback = (onStudentSelectedItem) getActivity();
        mCallback.unCheckIndex(studentArrayList.get(position));

        //выполняется получение fragment detail, чтобы определить ориентацию экрана
        if(getActivity().findViewById(R.id.fragment_container) != null){
            getListView().setItemChecked(position, false);

            //
            StudentDetail firstFragment = new StudentDetail();
            Bundle bundle = new Bundle();
            bundle.putString("fullname", studentArrayList.get(position).getSurname() + " " +
                    studentArrayList.get(position).getName() + " " +
                    studentArrayList.get(position).getPatronymic());
            bundle.putString("bday", studentArrayList.get(position).getBday());
            bundle.putString("location", studentArrayList.get(position).getCity() + ", " + studentArrayList.get(position).getCountry());
            bundle.putString("login", studentArrayList.get(position).getCity() + ", " + studentArrayList.get(position).getCountry());
            //
            firstFragment.setArguments(bundle);
            int i = getFragmentManager().beginTransaction().replace(R.id.fragment_container, firstFragment).addToBackStack("myFragment").commit();
            Log.d("Lab_7", "commit = " + i);

        } else {
            getListView().setItemChecked(position, false);
            Intent intent = new Intent(getActivity(), AdminDetailActivity.class);
            intent.putExtra("fullname", studentArrayList.get(position).getSurname() + " " +
                    studentArrayList.get(position).getName() + " " +
                    studentArrayList.get(position).getPatronymic());
            intent.putExtra("bday", studentArrayList.get(position).getBday());
            intent.putExtra("location", studentArrayList.get(position).getCity() + ", " + studentArrayList.get(position).getCountry());
            intent.putExtra("login", studentArrayList.get(position).getCity() + ", " + studentArrayList.get(position).getCountry());
            startActivity(intent);
            Log.d("Lab_7", "vertical");
        }
    }

    public static void refreshListView(){
        studentArrayList.clear();
        Cursor cursor = LoginActivity.sDb.rawQuery("Select surname, name, patronymic, bday, city, country, login from Students", null);
        if(cursor.moveToFirst()){
            Log.d("Lab_7", "number Students = " + cursor.getCount());
            do{
                studentArrayList.add(new Student(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6)));
            } while(cursor.moveToNext());
        }
        adapter.notifyDataSetChanged();
    }

}
