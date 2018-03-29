package com.example.nguyen.baitapfragmentandroid;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {

    private ListView lvMenu;
    public MenuFragment() {
        // Required empty public constructor
    }

    public static MenuFragment getInstance(){
        return new MenuFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_menu, container, false);
        lvMenu = v.findViewById(R.id.lvMenu);
        ArrayList<String> menu = new ArrayList<>();
        menu.add("Tinh toan so hoc");
        menu.add("Tinh chu vi - dien tich");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, menu);
        lvMenu.setAdapter(arrayAdapter);
        lvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    ((MainActivity) getActivity()).callFragment(R.id.flDetail, CalculatorFragment.getInstance());
                }else if(position == 1){
                    ((MainActivity) getActivity()).callFragment(R.id.flDetail, ShapeFragment.getInstance());
                }
            }
        });
        return v;
    }
}
