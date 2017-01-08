package com.example.demir.carsharing;

import android.content.Intent;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.demir.carsharing.R.id.etName;

public class ReservationActivity extends AppCompatActivity {
    private Button save;
    private EditText name, surname, address, phone, start, destination;
    private DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        db = new DbHelper(this);
        name = (EditText) findViewById(etName);
        surname = (EditText) findViewById(R.id.etSurname);
        address = (EditText) findViewById(R.id.etAddress);
        phone = (EditText) findViewById(R.id.etPhone);
        start = (EditText) findViewById(R.id.etStart);
        destination = (EditText) findViewById(R.id.etDestination);
        save = (Button) findViewById(R.id.btnSave);

    }


}
