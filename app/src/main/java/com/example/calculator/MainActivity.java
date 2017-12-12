package com.example.calculator;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        str = (EditText) findViewById(R.id.viewNumbers);
        if(savedInstanceState != null){
            str.setText(savedInstanceState.getString("expression", ""));
        }
        if(getIntent() != null && getIntent().getExtras() != null){
            str.setText(getIntent().getStringExtra("expression"));
        }
    }

}