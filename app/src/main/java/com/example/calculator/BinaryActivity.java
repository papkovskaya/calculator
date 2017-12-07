package com.example.calculator;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class BinaryActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binary);
        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.addOnTabSelectedListener(this);
        str = (EditText) findViewById(R.id.viewNumbers);
        if(savedInstanceState != null){
            str.setText(savedInstanceState.getString("expression", ""));
        }
        if(getIntent() != null && getIntent().getExtras() != null){
            str.setText(getIntent().getStringExtra("expression"));
        }
    }
}
