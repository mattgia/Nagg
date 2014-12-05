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
public class MyArrayAdapter extends ArrayAdapter<Event> {

    public MyArrayAdapter(Context c, int resource, ArrayList<Event> objects )
    {
        super(c, resource, objects);

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        //System.out.println(position);
        View itemView = convertView;
        //make sure we have a view to work with
        if(true)
        {
            LayoutInflater li = (LayoutInflater) getContext().getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            itemView = li.inflate(R.layout.row, parent, false);



            TextView date = (TextView) itemView.findViewById(R.id.daymonth);
            TextView desc = (TextView) itemView.findViewById(R.id.Description);
            TextView info = (TextView) itemView.findViewById(R.id.additionalInfo);

            ImageButton trash = (ImageButton) itemView.findViewById(R.id.trash);
            trash.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Fragment_Zero.adapter.remove(Fragment_Zero.adapter.getItem(position));
                    Fragment_Zero.adapter.notifyDataSetChanged();

                }
            });
            int priority = getItem(position).getPriority();

            switch(priority) {


                case 1:
                    itemView.setBackgroundColor(0xFF00FF00);
                    break;
                case 2:
                    itemView.setBackgroundColor(0xFFCCFF33);
                    break;
                case 3:
                    itemView.setBackgroundColor(0xFFCCFF33);
                    break;
                case 4:
                    itemView.setBackgroundColor(0xFFCCCC00);
                    break;
                case 5:
                    itemView.setBackgroundColor(0xFFFFFF00);
                    break;
                case 6:
                    itemView.setBackgroundColor(0xFFFFCC00);
                    break;
                case 7:
                    itemView.setBackgroundColor(0xFFFF9933);
                    break;
                case 8:
                    itemView.setBackgroundColor(0xFFFF9933);
                    break;
                case 9:
                    itemView.setBackgroundColor(0xFFFF6600);
                    break;
                case 10:
                    itemView.setBackgroundColor(0xFFFF0000);
                    break;
                default:
                    itemView.setBackgroundColor(0x00000000);
            }


            /*
            for(int i = 0; i < getCount(); i++) {
                System.out.println(getItem(i).getTitle());
            }
            */


            String nums[] = getItem(position).getDueDate().split("/");
            int day = Integer.parseInt(nums[0]);
            int month = Integer.parseInt(nums[1]);

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

            System.out.println("day: " + day);
            date.setText(day + "\n" + string_month);

            desc.setText(getItem(position).getTitle());
            info.setText("due at: " + getItem(position).getDueTime() );
        }

        return itemView;
       // return super.getView(position, convertView, parent);
   }
}