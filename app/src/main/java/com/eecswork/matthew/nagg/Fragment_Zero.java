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
public class Fragment_Zero extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    private static ListView listView;
    private static MyArrayAdapter adapter;
    private ArrayList<Event> contents = new ArrayList<Event>();

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static Fragment_Zero newInstance(int sectionNumber) {
        Fragment_Zero fragment = new Fragment_Zero();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public Fragment_Zero() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_zero, container, false);

        //View v = getView();
        Button b = (Button) rootView.findViewById(R.id.addButton);
        listView = (ListView) rootView.findViewById(R.id.important_list);


        adapter = new MyArrayAdapter(rootView.getContext(),R.layout.row, contents );
        listView.setAdapter(adapter);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //adapter.add(new Event(new Date(2014,6,2), "11:59", "PENIS PENIS", 10));

                Popup  p = new Popup(rootView);


                adapter.notifyDataSetChanged();



            }
        });

        return rootView;
    }

}