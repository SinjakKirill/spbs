package com.example.sinyakkirill.lab_14.asynctask;

import android.app.Activity;
import android.app.Fragment;
import android.os.AsyncTask;
import android.provider.DocumentsContract;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sinyakkirill.lab_14.MainActivity;
import com.example.sinyakkirill.lab_14.fragments.ListNewsHabrahabr;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Sinyak Kirill on 20.12.2016.
 */

public class MyAsyncTask extends AsyncTask {

    Activity activity;

    @Override
    protected Object doInBackground(Object[] params) {

        String type = (String) params[0];


        /*ListNewsHabrahabr fragment = (ListNewsHabrahabr) params[1];
        ArrayList<String> q = new ArrayList<>();
        q.add("qwe");
        q.add("asd");
        q.add("zxc");
        fragment.refreshAdapter(q);*/

        switch (type){
            case "habrahabr":
                Log.d("Lab_14", type);
                ListNewsHabrahabr fragment = (ListNewsHabrahabr) params[1];
                String link = new String("https://habrahabr.ru/rss/interesting/");
                Document doc = null;
                ArrayList<String> arr = new ArrayList<>();
                try {
                    doc = Jsoup.connect(link).get();
                    Elements elements = doc.select(".item");
                    for (Element element :
                            elements) {
                        arr.add(element.html());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.d("Lab_14", e.getMessage());
                }
                ArrayList<String> q = new ArrayList<>();
                q.add("qwe");
                q.add("asd");
                q.add("zxc");
                fragment.refreshAdapter(q);
                break;
            case "exchangerates":
                break;
            default:
                break;
        }
        return null;
    }

    public ArrayList<String> getNewsFromHabrahabr(){
        String link = new String("https://habrahabr.ru/rss/interesting/");
        Document doc = null;
        ArrayList<String> arr = new ArrayList<>();
        ArrayAdapter<String> adapter;
        try {
            doc = Jsoup.connect(link).get();
            Elements elements = doc.select(".item");
            for (Element element :
                    elements) {
                arr.add(element.html());
            }
            adapter = new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, arr);
            //Toast.makeText(activity, arr.get(0), Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<String>();
    }
}
