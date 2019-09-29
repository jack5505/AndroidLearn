package com.example.jsabirov.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator extends AppCompatActivity implements View.OnClickListener {

    TextView show;
    Button btnAdd,btnSubtract,btnMultiply,btnDivide,change;
    EditText input1,input2;
    float first,second,result;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
        show = findViewById(R.id.show);
        change = findViewById(R.id.activity);
        btnAdd = findViewById(R.id.add);
        btnSubtract = findViewById(R.id.subtract);
        btnMultiply = findViewById(R.id.multiply);
        btnDivide = findViewById(R.id.divide);
        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        change.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnSubtract.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.myrotate);
        if(change.getId() == R.id.activity){
            Intent intent = new Intent(this,Main2Activity.class);
            startActivity(intent);
        }
        if(!input1.getText().toString().isEmpty() && !input2.getText().toString().isEmpty()){
            first = second = result = 0;
            first = Float.parseFloat(input1.getText().toString());
            second = Float.parseFloat(input2.getText().toString());
            switch (view.getId()){
                case R.id.add:
                result = first + second;
                show.setText(first+" + " + second+"="+result);
                break;
                case R.id.subtract:
                    result = first - second;
                    show.setText(first+" - " + second+"="+result);
                    break;
                case R.id.multiply:
                    result = first * second;
                    show.setText(first+" * " + second+"="+result);
                    break;
                case R.id.divide:
                    result = first / second;
                    show.setText(first+" / " + second+"="+result);
                    break;
            }
            show.setAnimation(animation);

        }

    }
}
