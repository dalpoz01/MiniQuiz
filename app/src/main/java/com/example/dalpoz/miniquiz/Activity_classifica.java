package com.example.dalpoz.miniquiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Activity_classifica extends AppCompatActivity {
    String giocatore,punteggio;
    Button esci,partita;
    Classe_Giocatori gc=new Classe_Giocatori();
    //AlertDialog.Builder builder = new AlertDialog.Builder(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classifica);
        LinearLayout ly=findViewById(R.id.linear);
        esci=findViewById(R.id.button_Esci);
        partita=findViewById(R.id.button_NuovaPartita);
        Bundle b=getIntent().getExtras();
        giocatore=""+b.getString("Giocatore");
        punteggio=""+b.getString("Punteggio");
        for (int i=0;i<gc.getDimensione();i++){
            TextView p=new TextView(this);
            p.setText(""+gc.getGiocatore(i));
            ly.addView(p);
        }
        giocatore=""+b.getString("Giocatore");
        punteggio=""+b.getString("Punteggio");
        TextView p=new TextView(this);
        p.setGravity(9);
        p.setTextSize(24);
        p.setText(""+giocatore+" - "+getString(R.string.punti)+punteggio);
        ly.addView(p);
        esci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
        partita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Activity_classifica.this, Activity_Home.class);
                Activity_classifica.this.startActivity(i);
            }
        });
    }
    private void showDialog() throws Resources.NotFoundException{
        new AlertDialog.Builder(this)
                .setTitle("Conferma uscita")
                .setMessage("Vuoi uscire")
                .setPositiveButton("SI",
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //Do Something Here
                                finishAffinity();
                                System.exit(0);
                            }
                        })
                .setNegativeButton("NO",
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //Do Something Here
                            }
                        }).show();
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
