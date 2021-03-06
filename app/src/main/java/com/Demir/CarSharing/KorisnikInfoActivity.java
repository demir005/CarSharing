package com.Demir.CarSharing;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class KorisnikInfoActivity extends Activity {

    Korisnik korisnik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_info);

        korisnik = (Korisnik) getIntent().getSerializableExtra("korisnik");

        ((TextView)findViewById(R.id.imePrezime)).setText(korisnik.getIme() + " " + korisnik.getPrezime());
        ((TextView)findViewById(R.id.userTelefon)).setText(korisnik.getTelefon());
        ((TextView)findViewById(R.id.userMail)).setText(korisnik.getEmail());
        ((TextView)findViewById(R.id.userFb)).setText(korisnik.getFb());

    }
}
