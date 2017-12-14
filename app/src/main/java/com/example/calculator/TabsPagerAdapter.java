package com.example.calculator;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

/**
 * Created by inkvi on 07.12.2017.
 */

public class TabsPagerAdapter extends FragmentPagerAdapter {
    private Context mContext;

    public TabsPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new SimpleFragment();
            case 1:
                return new EngineeringFragment();
            case 2:
                return new BinaryFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return mContext.getResources().getString(R.string.simple);
            case 1:
                return mContext.getResources().getString(R.string.engineering);
            case 2:
                return mContext.getResources().getString(R.string.programming);
        }
        return "";
    }
}
