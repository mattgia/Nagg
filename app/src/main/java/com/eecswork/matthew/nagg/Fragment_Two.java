package com.eecswork.matthew.nagg;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Matthew on 12/3/2014.
 */
public class Fragment_Two extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    public static CalendarAdapter adapter;
    private static ListView listView;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static Fragment_Two newInstance(int sectionNumber) {
        Fragment_Two fragment = new Fragment_Two();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public Fragment_Two() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_two, container, false);
        listView = (ListView) rootView.findViewById(R.id.calendar_list);
        TextView t = (TextView) rootView.findViewById(R.id.calendar_weekday);


        Calendar c = Calendar.getInstance();
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        String weekDay = "unknown";
        if (2 == dayOfWeek) weekDay = "monday";
        else if (3 == dayOfWeek) weekDay = "tuesday";
        else if (4. == dayOfWeek) weekDay = "wednesday";
        else if (5. == dayOfWeek) weekDay = "thursday";
        else if (6 == dayOfWeek) weekDay = "friday";
        else if (7 == dayOfWeek) weekDay = "saturday";
        else if (1 == dayOfWeek) weekDay = "sunday";
        t.setText(weekDay.toUpperCase());

        adapter = new CalendarAdapter(rootView.getContext(),R.layout.calendar_row, new ArrayList<Object>());
        listView.setAdapter(adapter);
        adapter.add(new Object());
        adapter.add(new Object());
        adapter.add(new Object());
        adapter.add(new Object());
        adapter.add(new Object());
        adapter.add(new Object());
        adapter.add(new Object());
        adapter.add(new Object());
        adapter.add(new Object());
        adapter.add(new Object());
        adapter.add(new Object());
        adapter.add(new Object());
        adapter.add(new Object());
        adapter.add(new Object());
        adapter.add(new Object());
        adapter.add(new Object());
        adapter.add(new Object());
        adapter.add(new Object());
        adapter.add(new Object());
        adapter.add(new Object());
        adapter.add(new Object());
        adapter.add(new Object());
        adapter.add(new Object());
        adapter.add(new Object());


        return rootView;
    }
}