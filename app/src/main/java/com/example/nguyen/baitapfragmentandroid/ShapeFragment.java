package com.example.nguyen.baitapfragmentandroid;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShapeFragment extends Fragment{

    private ViewPager mPager;
    private TabLayout tabLayout;
    private PagerAdapter mPagerAdapter;
    private final int NUM_PAGES = 2;

    public ShapeFragment() {
        // Required empty public constructor
    }

    public static ShapeFragment getInstance(){
        return new ShapeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_shape, container, false);
        mPager = v.findViewById(R.id.pager);
        tabLayout = v.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(mPager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getChildFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        return v;
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter{
        Fragment[] fragments = {new RectangleFragment(), new SquareFragment()};
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments[position];
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return getResources().getString(R.string.rectangle);
                case 1:
                    return getResources().getString(R.string.square);
            }
            return super.getPageTitle(position);
        }
    }

}
