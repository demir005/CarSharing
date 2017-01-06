package com.example.demir.carsharing;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


/**
 * Created by Demir on 19.12.2016..
 */

public class Display extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        String username = getIntent().getStringExtra("Username");
        TextView tv = (TextView)findViewById(R.id.TVUsername);
        tv.setText(username);
    }


}
