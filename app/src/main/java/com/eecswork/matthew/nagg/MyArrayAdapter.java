package com.eecswork.matthew.nagg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.*;

/**
 * Created by Matthew on 12/3/2014.
 */
public class MyArrayAdapter extends ArrayAdapter<Event> {

    private Context context;
    public MyArrayAdapter(Context c, int resource, List<Event> objects )
    {
        super(c, resource, objects);
        context = c;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View itemView = convertView;
        //make sure we have a view to work with
        if(itemView == null)
        {
            LayoutInflater li = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            itemView = li.inflate(R.layout.row, parent, false);

        }




        return itemView;
       // return super.getView(position, convertView, parent);
    }
}