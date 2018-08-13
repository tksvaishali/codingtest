package com.example.codingtest.codingapplication.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.codingtest.codingapplication.fragment.Fragment1;

/**
 * PageAdapter is adapter to display fragments in ViewPager
 */
public class PageAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 4;

    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * This method return fragment of Fragment1 type.
     *
     * @param position Position number
     * @return Fragment of type Fragment1.
     */
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return Fragment1.newInstance(0, "Fragment 1");
            case 1:
                return Fragment1.newInstance(1, "Fragment 2");
            case 2:
                return Fragment1.newInstance(2, "Fragment 3");
            case 3:
                return Fragment1.newInstance(3, "Fragment 4");
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }
}
