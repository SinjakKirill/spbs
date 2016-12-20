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

    ArrayList<String> arr = new ArrayList<>();
    ArrayAdapter<String> adapter;// = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, arr);

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //arr = getResources().getStringArray(R.array.itemNavigationDrawer);
        //getListView().setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, arr));
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, arr);
        getListView().setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, null);
    }

    public void refreshAdapter(ArrayList<String> stringArrayList){
        arr = stringArrayList;
        //adapter.notifyDataSetChanged();
    }
}
