package com.example.sinyakkirill.lab_14.fragments;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.sinyakkirill.lab_14.MainActivity;
import com.example.sinyakkirill.lab_14.R;
import com.example.sinyakkirill.lab_14.WebActivity;

/**
 * Created by Sinyak Kirill on 19.12.2016.
 */

public class ListExchangeRates extends ListFragment {

    public static ArrayAdapter<String> adapter;
    public static String url = new String();

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, MainActivity.bankList);
        getListView().setAdapter(adapter);

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), WebActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, null);
    }
}
