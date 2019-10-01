package com.example.jsabirov.myapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Db extends AppCompatActivity implements View.OnClickListener {

    Button save,load;
    EditText text;
    final String savedText = "saved_text";
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
        save = findViewById(R.id.save);
        load = findViewById(R.id.load);
        text = findViewById(R.id.editText);
        save.setOnClickListener(this);
        load.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.save:
                saveText();
                break;
            case R.id.load:
                loadText();
                break;
                default:
                    break;
        }
    }

    private void loadText() {
        sharedPreferences = getPreferences(MODE_PRIVATE);
        String saved = sharedPreferences.getString(savedText,"");
        text.setText(saved);
        Toast.makeText(this,"Loadded",Toast.LENGTH_SHORT).show();
    }

    private void saveText() {
        sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(savedText,text.getText().toString());
        editor.commit();
        Toast.makeText(this,"SAVED",Toast.LENGTH_SHORT).show();
    }

}
