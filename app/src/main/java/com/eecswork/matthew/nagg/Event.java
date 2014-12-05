package com.eecswork.matthew.nagg;

import android.text.format.Time;

import java.util.Date;

/**
 * Created by Matthew on 12/3/2014.
 */
public class Event {

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getDueTime() {
        return dueTime;
    }

    public void setDueTime(String dueTime) {
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

    private String dueDate;
    private String dueTime;
    private String title;
    private int priority;

    public Event(String d, String t, String s, int p)
    {
        dueDate = d;
        dueTime = new String (t);
        title = new String (s);
        priority = p;
    }


}
