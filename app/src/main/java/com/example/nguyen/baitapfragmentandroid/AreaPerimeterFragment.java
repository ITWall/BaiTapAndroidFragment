package com.example.nguyen.baitapfragmentandroid;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TabWidget;


/**
 * A simple {@link Fragment} subclass.
 */
public class AreaPerimeterFragment extends Fragment implements TabHost.OnTabChangeListener{

    private FragmentTabHost tabHost;

    public AreaPerimeterFragment() {
        // Required empty public constructor
    }

    public static AreaPerimeterFragment getInstance(){
        return new AreaPerimeterFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_area_perimeter, container, false);
        tabHost = v.findViewById(R.id.tabHost);
        tabHost.setup(getContext(), getChildFragmentManager(), R.id.flContentAPFragment);
        tabHost.setOnTabChangedListener(this);
        View areaTab = getLayoutInflater().inflate(R.layout.tab_area, null);
        View perimeterTab = getLayoutInflater().inflate(R.layout.tab_perimeter, null);
        tabHost.addTab(tabHost.newTabSpec("areaTab").setIndicator(areaTab), AreaFragment.class, null);
        tabHost.addTab(tabHost.newTabSpec("perimeterTab").setIndicator(perimeterTab), PerimeterFragment.class, null);
        return v;
    }


    @Override
    public void onTabChanged(String tabId) {
        switch (tabId){

        }
    }
}
