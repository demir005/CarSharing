package com.example.demir.carsharing;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    DatabaseHelper helper = new DatabaseHelper(this);
    private Button v;
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

            EditText b = (EditText)findViewById(R.id.TFPassword);
            String pass = b.getText().toString();

            String password = helper.searchPass(str);

            if(pass.equals(password))
            {
                Intent i = new Intent(MainActivity.this, Display.class);
                i.putExtra("uname", str);
                startActivity(i);
            }
            else
            {
                // DIsplay popup message
                Toast temp =Toast.makeText(MainActivity.this, "Username and Password don't match", Toast.LENGTH_SHORT);
                temp.show();

            }

        }
        if (v.getId()==R.id.bSignUpHere)
        {
            Intent i = new Intent(MainActivity.this, signup.class);
            startActivity(i);
        }

    }
}
