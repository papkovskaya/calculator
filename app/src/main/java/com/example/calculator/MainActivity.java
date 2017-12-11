package com.example.calculator;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.List;


public class MainActivity extends BaseActivity implements View.OnClickListener, SimpleFragment.OnFragmentInteractionListener, EngineeringFragment.OnFragmentInteractionListener, BinaryFragment.OnFragmentInteractionListener {

    ViewPager mPager;
    TabsPagerAdapter mAdapter;
    @Override
    public void finish() {
        super.finish();
        overridePendingTransitionExit();
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransitionEnter();
    }

    protected void overridePendingTransitionEnter() {
        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
    }


    protected void overridePendingTransitionExit() {
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabLayout tabLayout = findViewById(R.id.tabs);
        mPager = (ViewPager) findViewById(R.id.pager);
        mAdapter = new TabsPagerAdapter(getSupportFragmentManager(), this);
        mPager.setAdapter(mAdapter);
        tabLayout.setupWithViewPager(mPager);

    }

    @Override
    public void onFragmentInteraction() {
        //ViewPager pager = (ViewPager) findViewById(R.id.pager);

        //str = (EditText)  findViewById(R.id.viewNumbers);
//        if(savedInstanceState != null){
//            str.setText(savedInstanceState.getString("expression", ""));
//        }
//        if(getIntent() != null && getIntent().getExtras() != null){
//            str.setText(getIntent().getStringExtra("expression"));
//        }
    }

    @Override
    public void onClick(View view) {
        ((BaseFragment)mAdapter.getRegisteredFragment(mPager.getCurrentItem())).onClick(view);
    }
}