package com.example.calculator;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.calculator.polish_processing.PolishProcessor;

public class EngineeringActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engineering);
        TabLayout tabLayout = findViewById(R.id.tabs);
        //tabLayout.addOnTabSelectedListener(this);
        str = (EditText) findViewById(R.id.viewNumbers);
        if(savedInstanceState != null){
            str.setText(savedInstanceState.getString("expression", ""));
        }
        if(getIntent() != null && getIntent().getExtras() != null){
            str.setText(getIntent().getStringExtra("expression"));
        }
    }
}
