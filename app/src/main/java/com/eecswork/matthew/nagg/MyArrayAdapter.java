package com.eecswork.matthew.nagg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.*;

/**
 * Created by Matthew on 12/3/2014.
 */
public class MyArrayAdapter extends ArrayAdapter<Event> {

    private Context context;
    private List<Event> events;
    public MyArrayAdapter(Context c, int resource, List<Event> objects )
    {
        super(c, resource, objects);
        context = c;
        events = objects;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View itemView = convertView;
        //make sure we have a view to work with
        if(itemView == null)
        {
            LayoutInflater li = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            itemView = li.inflate(R.layout.row, parent, false);

            TextView date = (TextView) itemView.findViewById(R.id.daymonth);
            TextView desc = (TextView) itemView.findViewById(R.id.Description);
            TextView info = (TextView) itemView.findViewById(R.id.additionalInfo);

            int day = events.get(position).getDueDate().getDay();
            int month = events.get(position).getDueDate().getMonth();
            String string_month = null;


            switch(month) {
                case 1:
                    string_month = "JAN";
                case 2:
                    string_month = "FEB";
                case 3:
                    string_month = "MAR";
                case 4:
                    string_month = "APR";
                case 5:
                    string_month = "MAY";
                case 6:
                    string_month = "JUN";
                case 7:
                    string_month = "JUL";
                case 8:
                    string_month = "AUG";
                case 9:
                    string_month = "SEPT";
                case 10:
                    string_month = "OCT";
                case 11:
                    string_month = "NOV";
                case 12:
                    string_month = "DEC";
            }

            date.setText(day + "\n" + string_month);

            desc.setText(events.get(position).getTitle());
            info.setText("due at: " + events.get(position).getDueTime() );

        }




        return itemView;
       // return super.getView(position, convertView, parent);
    }
}