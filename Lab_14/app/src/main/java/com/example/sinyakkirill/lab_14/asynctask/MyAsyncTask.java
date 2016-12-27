package com.example.sinyakkirill.lab_14.asynctask;

import android.app.Activity;
import android.app.Fragment;
import android.os.AsyncTask;
import android.provider.DocumentsContract;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.sinyakkirill.lab_14.MainActivity;
import com.example.sinyakkirill.lab_14.fragments.ListExchangeRates;
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

public class MyAsyncTask extends AsyncTask{

    @Override
    protected Object doInBackground(Object[] params) {

        String type = (String) params[0];

        switch (type){
            case "habrahabr":
                Log.d("Lab_14", type);
                Elements content;
                Document newsDoc;
                try{
                    newsDoc = Jsoup.connect("https://news.yandex.by/?lang=ru").get();
                    content = newsDoc.select(".story__content");
                    MainActivity.yandexList.clear();
                    for (Element cont: content) {
                        MainActivity.yandexList.add(cont.text());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "exchangerates":
                Elements content1;
                Document newsDoc1;
                try{
                    newsDoc1 = Jsoup.connect("https://news.yandex.by/quotes/4011.html").get();
                    content1 = newsDoc1.select(".quote__info");
                    ListExchangeRates.url = newsDoc1.select("a[href]").first().attr("href");
                    MainActivity.bankList.clear();
                    for (Element cont: content1) {
                        MainActivity.bankList.add(cont.text());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);

        if(ListNewsHabrahabr.adapter != null) {
            ListNewsHabrahabr.adapter.notifyDataSetChanged();
            MainActivity.mProgressBar.setVisibility(View.INVISIBLE);
        }
        if(ListExchangeRates.adapter != null) {
            ListExchangeRates.adapter.notifyDataSetChanged();
            MainActivity.mProgressBar.setVisibility(View.INVISIBLE);
        }
        Log.d("Lab_14", "onPostExecute");
    }
}
