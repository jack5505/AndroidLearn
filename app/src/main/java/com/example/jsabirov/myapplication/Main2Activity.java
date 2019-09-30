package com.example.jsabirov.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        TextView textView = findViewById(R.id.textView);
        textView.setText(intent.getStringExtra("first")+" "+intent.getStringExtra("second"));


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("BEFORE START second ACTIVITY");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("PAUSE second ACTIVITY");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("STOP second ACTIVIY");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("Destroyed second Activity");
    }
}
