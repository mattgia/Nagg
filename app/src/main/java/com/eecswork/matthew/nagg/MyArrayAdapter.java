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

    public MyArrayAdapter(Context c, int resource, ArrayList<Event> objects )
    {
        super(c, resource, objects);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

           System.out.println(position);
        View itemView = convertView;
        //make sure we have a view to work with
        if(true)
        {
            LayoutInflater li = (LayoutInflater) getContext().getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            itemView = li.inflate(R.layout.row, parent, false);

            TextView date = (TextView) itemView.findViewById(R.id.daymonth);
            TextView desc = (TextView) itemView.findViewById(R.id.Description);
            TextView info = (TextView) itemView.findViewById(R.id.additionalInfo);

            /*
            for(int i = 0; i < getCount(); i++) {
                System.out.println(getItem(i).getTitle());
            }
            */

            int day = getItem(position).getDueDate().getDay();
            int month = getItem(position).getDueDate().getMonth();
            String string_month = null;

            switch(month) {
                case 1:
                    string_month = "JAN";
                    break;
                case 2:
                    string_month = "FEB";
                    break;
                case 3:
                    string_month = "MAR";
                    break;
                case 4:
                    string_month = "APR";
                    break;
                case 5:
                    string_month = "MAY";
                    break;
                case 6:
                    string_month = "JUN";
                    break;
                case 7:
                    string_month = "JUL";
                    break;
                case 8:
                    string_month = "AUG";
                    break;
                case 9:
                    string_month = "SEP";
                    break;
                case 10:
                    string_month = "OCT";
                    break;
                case 11:
                    string_month = "NOV";
                    break;
                case 12:
                    string_month = "DEC";
                    break;
                default:
                    string_month = ""; //Pre-emptive NullPointerException fixer
            }

            date.setText(day + "\n" + string_month);

            desc.setText(getItem(position).getTitle());
            info.setText("due at: " + getItem(position).getDueTime() );
        }

        return itemView;
       // return super.getView(position, convertView, parent);
    }
}