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
public class MyArrayAdapterOne extends ArrayAdapter<BusyDays> {

    public MyArrayAdapterOne(Context c, int resource, ArrayList<BusyDays> objects )
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

            TextView txt = (TextView) itemView.findViewById(R.id.one_row_Description);
            TextView time = (TextView) itemView.findViewById(R.id.one_row_Time);
            TextView weekdays = (TextView) itemView.findViewById(R.id.one_row_WeekDays);


            //set fields in the row
            txt.setText(getItem(position).getDescription());
            time.setText(getItem(position).getTime());

            ArrayList<String> x = getItem(position).getWeekdays();
            String s = "";

            for(int i = 0; i < x.size(); i++)
            {
                s = s + ", " + x.get(i);
            }

            weekdays.setText(s);


        ImageButton trash = (ImageButton) itemView.findViewById(R.id.one_trash);
        trash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment_One.adapter.remove(Fragment_One.adapter.getItem(position));
                Fragment_One.adapter.notifyDataSetChanged();

            }
        });








        return itemView;
        // return super.getView(position, convertView, parent);
    }
}