package com.eecswork.matthew.nagg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.*;

/**
 * Created by Matthew on 12/3/2014.
 */
public class CalendarAdapter extends ArrayAdapter<Object> {

    public CalendarAdapter(Context c, int resource, ArrayList<Object> objects )
    {
        super(c, resource, objects);

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        //System.out.println(position);
        View itemView = convertView;

        LayoutInflater li = (LayoutInflater) getContext().getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        itemView = li.inflate(R.layout.calendar_row, parent, false);


        TextView time = (TextView) itemView.findViewById(R.id.calendar_time);
        TextView desc = (TextView) itemView.findViewById((R.id.calendar_desc));

        time.setText(position + ":00");
        desc.setText("this is where the description goes");

        return itemView;

    }
}