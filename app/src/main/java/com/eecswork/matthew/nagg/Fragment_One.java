package com.eecswork.matthew.nagg;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.text.format.Time;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.*;


/**
 * Created by Matthew on 12/3/2014.
 */
public class Fragment_One extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    private static ListView listView;
    public static MyArrayAdapterOne adapter;
    private ArrayList<BusyDays> contents = new ArrayList<BusyDays>();

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static Fragment_One newInstance(int sectionNumber) {
        Fragment_One fragment = new Fragment_One();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public Fragment_One() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_one, container, false);

        //View v = getView();
        Button b = (Button) rootView.findViewById(R.id.one_addButton);
        listView = (ListView) rootView.findViewById(R.id.one_important_list);


        adapter = new MyArrayAdapterOne(rootView.getContext(),R.layout.one_row, contents );
        listView.setAdapter(adapter);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Popup_One  p = new Popup_One(rootView);


                //adapter.notifyDataSetChanged();



            }
        });

        return rootView;
    }

}