package com.example.sinyakkirill.lab_14.fragments;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.sinyakkirill.lab_14.MainActivity;
import com.example.sinyakkirill.lab_14.R;

import java.util.ArrayList;

/**
 * Created by Sinyak Kirill on 19.12.2016.
 */

public class ListNewsHabrahabr extends ListFragment {

    public static ArrayAdapter<String> adapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, MainActivity.yandexList);
        getListView().setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, null);
    }
}
