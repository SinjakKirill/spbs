package com.example.sinyakkirill.lab_14;

import android.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.sinyakkirill.lab_14.asynctask.MyAsyncTask;
import com.example.sinyakkirill.lab_14.fragments.ListExchangeRates;
import com.example.sinyakkirill.lab_14.fragments.ListNewsHabrahabr;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String[] itemNavigationDrawer;
    DrawerLayout mDrawerLayout;
    ListView mDrawerList;
    public static ProgressBar mProgressBar;

    ArrayAdapter<String> adapterMenu;

    public static ArrayList<String> yandexList = new ArrayList<>();
    public static ArrayList<String> bankList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemNavigationDrawer = getResources().getStringArray(R.array.itemNavigationDrawer);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);

        adapterMenu = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemNavigationDrawer);
        mDrawerList.setAdapter(adapterMenu);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        mProgressBar.setVisibility(View.VISIBLE);
                        MyAsyncTask myAsyncTask = new MyAsyncTask();
                        ListNewsHabrahabr listNewsHabrahabr = new ListNewsHabrahabr();
                        myAsyncTask.execute(new Object[]{"habrahabr"});
                        getFragmentManager().beginTransaction().replace(R.id.content_frame, listNewsHabrahabr).commit();
                        break;
                    case 1:
                        mProgressBar.setVisibility(View.VISIBLE);
                        MyAsyncTask myAsyncTask1 = new MyAsyncTask();
                        ListExchangeRates listExchangeRates = new ListExchangeRates();
                        myAsyncTask1.execute(new Object[]{"exchangerates"});
                        getFragmentManager().beginTransaction().replace(R.id.content_frame, listExchangeRates).commit();

                        break;
                    default:
                        break;
                }
            }
        });
    }


}
