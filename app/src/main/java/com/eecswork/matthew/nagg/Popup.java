package com.eecswork.matthew.nagg;

import android.content.Context;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

/**
 * Created by Matthew on 12/4/2014.
 */
public class Popup {

    public Popup(View rootView)
    {
        LayoutInflater inflater = (LayoutInflater) rootView.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        WindowManager wm = (WindowManager) rootView.getContext().getSystemService(Context.WINDOW_SERVICE);
        Display disp = wm.getDefaultDisplay();

        PopupWindow pw = new PopupWindow(inflater.inflate(R.layout.hover_window, null, false),disp.getWidth()-160,disp.getHeight()-300, true);
        pw.showAtLocation(rootView.findViewById(R.id.important_list), Gravity.CENTER, 0, 0);
    }
}
