package com.eecswork.matthew.nagg;

import android.text.format.Time;

import java.util.Date;

/**
 * Created by Matthew on 12/3/2014.
 */
public class Event {

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Time getDueTime() {
        return dueTime;
    }

    public void setDueTime(Time dueTime) {
        this.dueTime = dueTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    private Date dueDate;
    private Time dueTime;
    private String title;
    private int priority;

    public Event(Date d, Time t, String s, int p)
    {
        dueDate = d;
        dueTime = t;
        title = s;
        priority = p;
    }


}
