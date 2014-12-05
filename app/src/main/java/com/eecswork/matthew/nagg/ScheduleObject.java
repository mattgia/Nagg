package com.eecswork.matthew.nagg;

/**
 * Created by Matthew on 12/5/2014.
 */
public class ScheduleObject {

    private String description;
    private int t;//0 = nothing, 1 = event, 2 = busy

    public String getDescription() {
        return description;
    }

    public int getType() {
        return t;
    }

    public void setType(int t) {
        this.t = t;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ScheduleObject(String description, int priority, int type) {
        this.description = description;
        this.t = type;
    }
    public ScheduleObject() {
        this.description = "";
        this.t = 0;
    }
}
