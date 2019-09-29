package com.example.jsabirov.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ExamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adapter);
        String myStrinArray[] = new String[]{"salom","ular","Bular"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,myStrinArray);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
