package com.example.jsabirov.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.*;
import android.widget.*;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnCreateContextMenuListener {
    final int MENU_COLOR_RED = 1;
    final int MENU_COLOR_GREEN = 2;
    final int MENU_COLOR_BLUE = 3;

    final int MENU_SIZE_22 = 4;
    final int MENU_SIZE_26 = 5;
    final int MENU_SIZE_30 = 6;
    TextView color,size;
    RadioGroup orient;
    LinearLayout mainLayout;
    TextView textView;
    int wrapContent = WRAP_CONTENT;
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        switch (v.getId()){
            case R.id.contextMenu:
                menu.add(0,MENU_COLOR_BLUE,0,"BLUE");
                menu.add(0,MENU_COLOR_GREEN,0,"GREEN");
                menu.add(0,MENU_COLOR_RED,0,"RED");
                break;
            case R.id.contextmenu1:
                menu.add(0,MENU_SIZE_22,0,"22");
                menu.add(0,MENU_SIZE_26,0,"26");
                menu.add(0,MENU_SIZE_30,0,"30");
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test4);
        Button create = findViewById(R.id.create);
        Button delet = findViewById(R.id.clean);
        this.orient = findViewById(R.id.orientation);
        this.textView = findViewById(R.id.name);
        this.mainLayout = findViewById(R.id.mainLayout);
        create.setOnClickListener(this);
        delet.setOnClickListener(this);
        //setContentView(R.layout.test3);
//         this.color = findViewById(R.id.contextMenu);
//         this.size = findViewById(R.id.contextmenu1);
//         registerForContextMenu(color);
//         registerForContextMenu(size);
//        this.onClick(btn);
//        this.onClick(bt);
        /*
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case MENU_COLOR_BLUE:
                color.setTextColor(Color.BLUE);
                color.setText("Text color = red");
                break;
            case MENU_COLOR_GREEN:
                color.setTextColor(Color.GREEN);
                color.setText("Text color = blue");
                break;
            case MENU_COLOR_RED:
                color.setTextColor(Color.RED);
                color.setText("TEXT color = red");
                break;
            case MENU_SIZE_22:
                size.setTextSize(22);
                size.setText("Text size = 22");
                break;
            case MENU_SIZE_26:
                size.setTextSize(26);
                size.setText("Text size = 26");
                break;
            case MENU_SIZE_30:
                size.setTextSize(30);
                size.setText("Text size = 30");
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
            if(view.getId() == R.id.create){

                LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(
                        wrapContent, wrapContent);
                int gravity = Gravity.LEFT;
                switch (orient.getCheckedRadioButtonId()){

                    case R.id.rbcenter:
                        System.out.println("center");
                        gravity = Gravity.CENTER_HORIZONTAL;
                        break;
                    case R.id.rbleft:
                        System.out.println("LEFT");
                        gravity = Gravity.LEFT;
                        break;
                    case R.id.rbright:
                        System.out.println("RIGHT");
                        gravity = Gravity.RIGHT;
                        break;
                }
                lParams.gravity = gravity;
                Button button = new Button(this);
                button.setText(textView.getText());
                mainLayout.addView(button,lParams);
            }else if(view.getId() == R.id.clean){
                mainLayout.removeAllViews();
                Toast.makeText(this,"O`chirildi",Toast.LENGTH_LONG).show();
            }
    }
}
