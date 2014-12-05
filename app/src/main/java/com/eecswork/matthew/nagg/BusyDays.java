package com.eecswork.matthew.nagg;

import java.util.ArrayList;

/**
 * Created by Matthew on 12/4/2014.
 */


public class BusyDays {

    private String description;
    private ArrayList<String> weekdays;
    private String time;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getWeekdays() {
        return weekdays;
    }

    public void setWeekdays(ArrayList<String> weekdays) {
        this.weekdays = weekdays;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public BusyDays(String s, ArrayList<String> w, String t)
    {
        description = new String(s);
        weekdays =(ArrayList<String>) w.clone();
        time = new String(t);

    }
}
