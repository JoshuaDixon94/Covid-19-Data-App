package com.cst2335.covid_19dataapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private ArrayList<String> elements = new ArrayList<>(  );
    ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listViewOptions = findViewById(R.id.listViewOptions);
        listViewOptions.setAdapter(adapter = new ListViewAdapter());

        listViewOptions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                elements.remove(i);
                adapter.notifyDataSetChanged();
            }
        });


    }



     private class ListViewAdapter extends BaseAdapter{


         public int getCount() { return elements.size();}

         public Object getItem(int position) { return "" + position; }

         public long getItemId(int position) { return (long) position; }

         public View getView(int position, View old, ViewGroup parent)
         {
             LayoutInflater inflater = getLayoutInflater();


             View newView = inflater.inflate(R.layout.list_view_row_layout, parent, false);


             Button bView = newView.findViewById(R.id.textInput);
             bView.setText( getItem(position).toString() );


             return newView;
         }
     }

}