package com.example.myapplication;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class MyFragmentPagerAdapter extends FragmentStatePagerAdapter {

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                second_fragment sf =  new second_fragment();
            case 1:
                second_fragment_2 sf2 =  new second_fragment_2();
            case 2:
                second_fragment_3 sf3 = new second_fragment_3();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
