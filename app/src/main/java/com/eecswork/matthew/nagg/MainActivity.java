package com.eecswork.matthew.nagg;

/**
 * Created by Matthew on 12/3/2014.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;

import static com.eecswork.matthew.nagg.R.layout.login;

public class MainActivity extends Activity{

    public void next(View v)
    {
        sendMessage(v);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.login);



        ImageButton btn = (ImageButton) findViewById(R.id.facebook);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next(v);
            }
        });

        ImageButton btn2 = (ImageButton) findViewById(R.id.google);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next(v);
            }
        });
    }


}
