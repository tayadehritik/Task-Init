package com.example.kali.just_testing;

import android.content.Intent;
import android.provider.UserDictionary;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;


public class textview_2 extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        /*String s = i.getStringExtra("task");fgh3y
        String t = i.getStringExtra("time");*/
        ArrayList<Word> l = (ArrayList<Word>) i.getSerializableExtra("words");
        setContentView(R.layout.activity_textview_2);

        WordAdapter adapter = new WordAdapter(this,  l);

        ListView listV = (ListView) findViewById(R.id.list);
        listV.setAdapter(adapter);


    }







}
