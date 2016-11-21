package com.example.sinyakkirill.lab_4_5.fragments;

import android.app.Fragment;
import android.app.ListFragment;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sinyakkirill.lab_4_5.LoginActivity;
import com.example.sinyakkirill.lab_4_5.R;
import com.example.sinyakkirill.lab_4_5.units.Student;

import java.util.ArrayList;

/**
 * Created by Sinyak Kirill on 17.11.2016.
 */

public class StudentDetail extends Fragment {
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, null);
    }
}
