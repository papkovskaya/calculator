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

public class TabsPagerAdapter extends FragmentStatePagerAdapter {
    private Context mContext;
    SparseArray<Fragment> registeredFragments = new SparseArray<Fragment>();
    public TabsPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return SimpleFragment.newInstance();
            case 1:
                return EngineeringFragment.newInstance();
            case 2:
                return BinaryFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        registeredFragments.put(position, fragment);
        return fragment;
    }

    public Fragment getRegisteredFragment(int position) {
        return registeredFragments.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        registeredFragments.remove(position);
        super.destroyItem(container, position, object);
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
