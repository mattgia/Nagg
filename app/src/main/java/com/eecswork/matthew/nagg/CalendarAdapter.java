package com.eecswork.matthew.nagg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Matthew on 12/3/2014.
 */
public class CalendarAdapter extends ArrayAdapter<ScheduleObject> {

    private ArrayList<ScheduleObject> data;

    public CalendarAdapter(Context c, int resource, ArrayList<ScheduleObject> objects )
    {


        super(c, resource, objects);
        data = objects;


        this.add(new ScheduleObject());
        this.add(new ScheduleObject());
        this.add(new ScheduleObject());
        this.add(new ScheduleObject());
        this.add(new ScheduleObject());
        this.add(new ScheduleObject());
        this.add(new ScheduleObject());
        this.add(new ScheduleObject());
        this.add(new ScheduleObject());
        this.add(new ScheduleObject());
        this.add(new ScheduleObject());
        this.add(new ScheduleObject());
        this.add(new ScheduleObject());
        this.add(new ScheduleObject());
        this.add(new ScheduleObject());
        this.add(new ScheduleObject());
        this.add(new ScheduleObject());
        this.add(new ScheduleObject());
        this.add(new ScheduleObject());
        this.add(new ScheduleObject());
        this.add(new ScheduleObject());
        this.add(new ScheduleObject());
        this.add(new ScheduleObject());
        this.add(new ScheduleObject());

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
        if( getItem(position).getDescription().length() > 0) {
            desc.setText("Work on: " + getItem(position).getDescription());
        }
        else {
            itemView.setBackgroundColor(0xFFFFFFFF);
            desc.setText("Nothing scheduled");
        }
        if( getItem(position).getDescription().length() > 0) {

            if (getItem(position).getType() == 0) {
                itemView.setBackgroundColor(0xFFFFFFFF);
            } else if (getItem(position).getType() == 1) {
                itemView.setBackgroundColor(0xB89B9CFF);
            } else if (getItem(position).getType() == 2) {
                itemView.setBackgroundColor(0x9CFF0200);
            } else {
                itemView.setBackgroundColor(0xFFFFFFFF);

            }
        }

        return itemView;

    }
    public ArrayList<ScheduleObject> getData()
    {
        return data;
    }
    public void clear()
    {
        super.clear();
    }

    @Override
    public void notifyDataSetChanged() {

        Event highestPriority = new Event("","","", -1);
        if(Fragment_One.adapter != null && Fragment_Two.adapter != null && Fragment_Zero.adapter != null) {
            ArrayList<BusyDays> busy = Fragment_One.adapter.getData();
            ArrayList<Event> events = Fragment_Zero.adapter.getData();
            ArrayList<ScheduleObject> x = getData();
            //find the task for today
            if(events != null) {
                for (int i = 0; i < events.size(); i++) {
                    if (events.get(i).getPriority() > highestPriority.getPriority())
                        highestPriority = events.get(i);
                }
            }

            //fill in all values with the event
            if(x != null) {


                for (int i = 0; i < x.size(); i++) {
                    x.get(i).setDescription(highestPriority.getTitle());
                    x.get(i).setType(1);
                }
            }
            //set the days where you are busy
            if(busy != null)
            {
                for(int i = 0; i < busy.size(); i++)
                {
                    String date = busy.get(i).getTime();

                    String start = date.split("to")[0].trim();
                    String finish = date.split("to")[1].trim();

                    String startHour = start.split(":")[0].trim();
                    String finishHour = finish.split(":")[0].trim();

                    int zeStart = Integer.parseInt(startHour);
                    int zeFinish = Integer.parseInt(finishHour);
                    for(int j = zeStart; j < zeFinish; j++)
                    {
                        String temp = busy.get(i).getDescription();
                        x.get(j).setDescription(temp);
                        x.get(j).setType(2);
                    }

                }
            }


            super.notifyDataSetChanged();
        }
    }
}