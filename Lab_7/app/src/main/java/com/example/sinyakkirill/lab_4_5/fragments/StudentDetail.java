package com.example.sinyakkirill.lab_4_5.fragments;

import android.app.Fragment;
import android.app.ListFragment;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sinyakkirill.lab_4_5.LoginActivity;
import com.example.sinyakkirill.lab_4_5.R;
import com.example.sinyakkirill.lab_4_5.adminactivity.AdminActivity;
import com.example.sinyakkirill.lab_4_5.units.Student;

import java.util.ArrayList;

/**
 * Created by Sinyak Kirill on 17.11.2016.
 */

public class StudentDetail extends Fragment {

    String FullName;
    String Location;
    String Login;
    String BDay;

    TextView fullNameTextView;
    TextView locationTextView;
    TextView loginTextView;
    TextView bdayTextView;


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);

        fullNameTextView = (TextView) getActivity().findViewById(R.id.fullNameTextView);
        locationTextView = (TextView) getActivity().findViewById(R.id.locationTextView);
        loginTextView = (TextView) getActivity().findViewById(R.id.emailTextView);
        bdayTextView = (TextView) getActivity().findViewById(R.id.bdayTextView);

        Bundle bundle = getArguments();
        if(bundle != null){
            FullName = bundle.getString("fullname");
            Location = bundle.getString("location");
            Login = bundle.getString("login");
            BDay = bundle.getString("bday");
            fullNameTextView.setText(FullName);
            locationTextView.setText(Location);
            loginTextView.setText(Login);
            bdayTextView.setText(BDay);
            //Log.d("Lab_7", FullName + " " + Location + " " + Login + " " + BDay);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, null);
    }

    @Override
    public void onStart(){
        super.onStart();
        //Toast.makeText(getActivity(), "FragmentDetail onStart", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
