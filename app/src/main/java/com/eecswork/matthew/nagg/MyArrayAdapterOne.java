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
public class MyArrayAdapterOne extends ArrayAdapter<Event> {

    public MyArrayAdapterOne(Context c, int resource, ArrayList<Event> objects )
    {
        super(c, resource, objects);

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        //System.out.println(position);
        View itemView = convertView;
        //make sure we have a view to work with

            LayoutInflater li = (LayoutInflater) getContext().getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            itemView = li.inflate(R.layout.one_row, parent, false);



        return itemView;
        // return super.getView(position, convertView, parent);
    }
}