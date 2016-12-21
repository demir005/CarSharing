package com.example.demir.carsharing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View v){
        if (v.getId()==R.id.bLogin)
        {
            EditText a = (EditText)findViewById(R.id.TFUsername);
            String str = a.getText().toString();
            Intent i = new Intent(MainActivity.this, Display.class);
            i.putExtra("Username", str);
            startActivity(i);
        }
        if (v.getId()==R.id.bSignUpHere)
        {
            Intent i = new Intent(MainActivity.this, signup.class);
            startActivity(i);
        }

    }
}
