package com.example.demir.carsharing;

import android.app.Activity;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Demir on 19.12.2016..
 */

public class signup extends Activity {

    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

    }

    public void onSignUpClick(View v)
    {
        if(v.getId() == R.id.bSignUpHere)
        {
            EditText name = (EditText)findViewById(R.id.TFName);
            EditText email = (EditText)findViewById(R.id.TFEmail);
            EditText uname = (EditText)findViewById(R.id.TFuname);
            EditText pass1 = (EditText)findViewById(R.id.TFpass1);
            EditText pass2 = (EditText)findViewById(R.id.TFpass2);

            String namestr  = name.getText().toString();
            String emailstr  = email.getText().toString();
            String unamestr  = uname.getText().toString();
            String passstr1  = pass1.getText().toString();
            String passstr2  = pass2.getText().toString();


            if(!passstr1.equals(passstr2))
            {
                 // DIsplay popup message
                Toast pass =Toast.makeText(signup.this, "Password don't match", Toast.LENGTH_SHORT);
                pass.show();
            }
            else {

                //insert the detaild in database
                Contact c = new Contact();
                c.setName(namestr);
                c.setEmail(emailstr);
                c.setUname(unamestr);
                c.setPass(passstr1);

                helper.insertContact(c);
            }




        }
    }
}
