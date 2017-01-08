package com.example.demir.carsharing;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnLogout,btnReservation;
    private Session session;
    DbHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OpenReservation();




        session = new Session(this);
        if(!session.loggedin()){
            logout();
        }
        btnLogout = (Button)findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
        OpenReservation();

    }


    //button for opening reservation activity
    private void OpenReservation(){
        btnReservation=(Button)findViewById(R.id.btrReservation);
        btnReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.demir.carsharing.ReservationActivity");
                startActivity(intent);
            }
        });
    }
    // method for logout button
    private  void logout(){
        session.setLoggedin(false);
        finish();
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }




}
