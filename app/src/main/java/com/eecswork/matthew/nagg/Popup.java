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
import android.widget.DatePicker;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.app.DatePickerDialog;
import java.util.Calendar;
import java.util.Date;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import static android.R.layout.simple_spinner_item;

/**
 * Created by Matthew on 12/4/2014.
 * Edited by aditya on 24-Dec-2014
 */
public class Popup extends FragmentActivity {

    TextView title;
    TextView date;
    TextView time;
    TextView priority;
    PopupWindow pw;
    private Spinner spinner1;
    private Button btnSubmit;

    public Popup(View rootView)  {


        LayoutInflater inflater = (LayoutInflater) rootView.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        WindowManager wm = (WindowManager) rootView.getContext().getSystemService(Context.WINDOW_SERVICE);
        Display disp = wm.getDefaultDisplay();

        pw = new PopupWindow(inflater.inflate(R.layout.hover_window, null, false), disp.getWidth() - 160, disp.getHeight() - 300, true);
        pw.showAtLocation(rootView.findViewById(R.id.important_list), Gravity.CENTER, 0, 0);

        title = ((TextView) pw.getContentView().findViewById(R.id.new_Title));

        date = ((TextView) pw.getContentView().findViewById(R.id.new_Date_Text));

        time = ((TextView) pw.getContentView().findViewById(R.id.new_Time_Text));

        priority = ((TextView) pw.getContentView().findViewById(R.id.new_Dif_Text));



        Button b = ((Button) pw.getContentView().findViewById(R.id.ok_button));
        Button c = ((Button) pw.getContentView().findViewById(R.id.cancel_butt));


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

        Button date_b = ((Button) pw.getContentView().findViewById(R.id.new_Date));
        Button time_b = ((Button) pw.getContentView().findViewById(R.id.new_Time));


        date_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                //open dialog to ask for date
                int mYear = cal.get(Calendar.YEAR);
                int mMonth = cal.get(Calendar.MONTH);
                int mDay = cal.get(Calendar.DAY_OF_MONTH);
                // System.out.println("the selected " + mDay);
                DatePickerDialog dialog = new DatePickerDialog(v.getContext(), new mDateSetListener(), mYear, mMonth, mDay);
                dialog.show();
            }
        });

        time_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int hour = cal.get(Calendar.HOUR);
                int minute = cal.get(Calendar.MINUTE);
                //showTimePickerDialog(v);
                TimePickerDialog dialog = new TimePickerDialog(v.getContext(), new mTimeListener(), hour, minute, false);
                dialog.show();
            }
        });


    }
    public void finish() {
        if (isValid()) {

            String zeDate = date.getText().toString();
            Fragment_Zero.adapter.add(new Event(zeDate, time.getText().toString(), title.getText().toString().toUpperCase(), Integer.parseInt(priority.getText().toString())));
            Fragment_Two.adapter.notifyDataSetChanged();
            pw.dismiss();
        }

    }

    private boolean isValid() {
        try {
            //Going to need this later.
            String[] datTime = time.getText().toString().split(":");
            boolean noMin = false;
            //Since Matt wants the user to be able to just put "1"
            if (datTime.length == 1 && Integer.parseInt(datTime[0]) >= 0 && Integer.parseInt(datTime[0]) < 24)
                noMin = true;
            //This as well
            String[] datDate = date.getText().toString().split("/");
            //System.out.println(date.toString());

            //Check that dif (number from 1-10) is in range
            if (Integer.parseInt(priority.getText().toString()) > 0 && Integer.parseInt(priority.getText().toString()) < 11) {
                //Makes sure the title is at least length 1.
                if (title.getText().toString().length() > 0) {
                    if (noMin || (Integer.parseInt(datTime[0]) < 24 && Integer.parseInt(datTime[0]) >= 0 && Integer.parseInt(datTime[1]) < 60 && Integer.parseInt(datTime[1]) >= 0)) {
                        //Don't need to check year I think
                        if (Integer.parseInt(datDate[0]) > 0 && Integer.parseInt(datDate[0]) <= 12 && Integer.parseInt(datDate[1]) > 0 && Integer.parseInt(datDate[1]) <= 31) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerMenu();
        newFragment.show(getFragmentManager(), "timePicker");
    }

    public static class TimePickerMenu extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            // Return to parent instance.
        }
    }

    class mDateSetListener implements DatePickerDialog.OnDateSetListener {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            date.setText(new StringBuilder()
                    // Month is 0 based so add 1
                    .append(monthOfYear + 1).append("/").append(dayOfMonth).append("/")
                    .append(year).append(" "));
        }
    }

    class mTimeListener implements TimePickerDialog.OnTimeSetListener {


        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

            time.setText(new StringBuilder().append(pad(hourOfDay))
                    .append(":").append(pad(minute)));
        }

        private String pad(int c) {
            if (c >= 10)
                return String.valueOf(c);
            else
                return "0" + String.valueOf(c);
        }
    }
    public class CustomOnItemSelectedListener implements OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
            String item = parent.getItemAtPosition(pos).toString();

            // Showing selected spinner item
            Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
        }

    }






}


