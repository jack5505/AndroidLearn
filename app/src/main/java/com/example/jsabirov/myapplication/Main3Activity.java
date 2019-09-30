package com.example.jsabirov.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {

    EditText editText,editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        editText = findViewById(R.id.login);
        editText1 = findViewById(R.id.password);
        Button btn = findViewById(R.id.ok);
        Button bt = findViewById(R.id.cancel);
        bt.setOnClickListener(this);
        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cancel:
            editText.setText("");
            editText1.setText("");
            break;
            case R.id.ok:
                Intent intent = new Intent();
                intent.putExtra("full",editText.getText().toString()+" "+editText1.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
        }
    }
}
