package com.example.sinyakkirill.lab_14;

import android.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.sinyakkirill.lab_14.asynctask.MyAsyncTask;
import com.example.sinyakkirill.lab_14.fragments.ListNewsHabrahabr;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String[] itemNavigationDrawer;
    DrawerLayout mDrawerLayout;
    public static ListView mDrawerList;

    ArrayAdapter<String> adapterMenu;
    public static ArrayAdapter<String> adapterListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemNavigationDrawer = getResources().getStringArray(R.array.itemNavigationDrawer);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        adapterMenu = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemNavigationDrawer);
        mDrawerList.setAdapter(adapterMenu);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        MyAsyncTask myAsyncTask = new MyAsyncTask();

                        ListNewsHabrahabr listNewsHabrahabr = new ListNewsHabrahabr();
                        FragmentManager fragmentManager = getFragmentManager();
                        myAsyncTask.execute(new Object[]{"habrahabr", listNewsHabrahabr});
                        fragmentManager.beginTransaction().replace(R.id.content_frame, listNewsHabrahabr).addToBackStack("0").commit();
                        break;
                    default:
                        break;
                }
            }
        });
    }


}
