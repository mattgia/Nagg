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
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Matthew on 12/4/2014.
 */
public class Popup_One extends FragmentActivity {


    PopupWindow pw;

    public Popup_One(View rootView) {
        LayoutInflater inflater = (LayoutInflater) rootView.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        WindowManager wm = (WindowManager) rootView.getContext().getSystemService(Context.WINDOW_SERVICE);
        Display disp = wm.getDefaultDisplay();

        pw = new PopupWindow(inflater.inflate(R.layout.busy_hover, null, false), disp.getWidth() - 160, disp.getHeight() - 300, true);
        pw.showAtLocation(rootView.findViewById(R.id.one_important_list), Gravity.CENTER, 0, 0);


        Button b = ((Button) pw.getContentView().findViewById(R.id.one_ok_button));


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    public void finish() {
        {
            //add new BusyDays Object
            //Fragment_One.adapter.add();
            pw.dismiss();
        }
    }
}
