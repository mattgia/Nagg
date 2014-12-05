package com.eecswork.matthew.nagg;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.format.DateFormat;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Matthew on 12/4/2014.
 */
public class Popup_One extends FragmentActivity {


    PopupWindow pw;
    String description;
    ArrayList<String> weekdays;
    String time;

    TextView desc;
    TextView start;
    TextView end;

    CheckBox mon;
    CheckBox tues;
    CheckBox wed;
    CheckBox thurs;
    CheckBox fri;
    CheckBox sat;
    CheckBox sun;

    public Popup_One(View rootView) {
        LayoutInflater inflater = (LayoutInflater) rootView.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        WindowManager wm = (WindowManager) rootView.getContext().getSystemService(Context.WINDOW_SERVICE);
        Display disp = wm.getDefaultDisplay();

        pw = new PopupWindow(inflater.inflate(R.layout.busy_hover, null, false), disp.getWidth() - 160, disp.getHeight() - 300, true);
        pw.showAtLocation(rootView.findViewById(R.id.one_important_list), Gravity.CENTER, 0, 0);


        Button b = ((Button) pw.getContentView().findViewById(R.id.busy_ok_button));
        Button c = ((Button) pw.getContentView().findViewById(R.id.busy_cancel));

        desc =(TextView) pw.getContentView().findViewById(R.id.busy_description);
        start = (TextView) pw.getContentView().findViewById(R.id.busy_from);
        end = (TextView) pw.getContentView().findViewById(R.id.busy_to);

        mon = (CheckBox) pw.getContentView().findViewById(R.id.busy_mon);
        tues = (CheckBox) pw.getContentView().findViewById(R.id.busy_tues);
        wed = (CheckBox) pw.getContentView().findViewById(R.id.busy_wed);
        thurs = (CheckBox) pw.getContentView().findViewById(R.id.busy_thurs);
        fri = (CheckBox) pw.getContentView().findViewById(R.id.busy_fri);
        sat = (CheckBox) pw.getContentView().findViewById(R.id.busy_sat);
        sun = (CheckBox) pw.getContentView().findViewById(R.id.busy_sun);





        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pw.dismiss();
            }
        });


    }

    public void finish() {
        {

            ArrayList<String> x = new ArrayList<String>();

            if(mon.isChecked())
            {
                x.add("Mon");
            }
            if(tues.isChecked())
            {
                x.add("Tues");
            }
            if(wed.isChecked())
            {
                x.add("Wed");
            }
            if(thurs.isChecked())
            {
                x.add("Thurs");
            }
            if(fri.isChecked())
            {
                x.add("Fri");
            }
            if(sat.isChecked())
            {
                x.add("Sat");
            }
            if(sun.isChecked())
            {
                x.add("Sun");
            }



            String daTime = start.getText().toString() + " to " + end.getText().toString();


            Fragment_One.adapter.add(new BusyDays(desc.getText().toString().toUpperCase().toUpperCase(), x,daTime ));
            Fragment_Two.adapter.notifyDataSetChanged();
            pw.dismiss();
        }
    }
}
