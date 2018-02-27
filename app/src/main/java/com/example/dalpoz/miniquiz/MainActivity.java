package com.example.dalpoz.miniquiz;

import android.graphics.drawable.Icon;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button indietro,avanti;
    ImageButton vero,falso;
    TextView nomeGiocatore,punteggio,domanda;

    private Domande domande=new Domande();
    private String Risposta,Risposta_giusta;
    private int Punteggio=0;
    private int numero_domande=domande.Domande.length;
    private int domande_eseguite=0;

    Random r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r=new Random();
        indietro=(Button) findViewById(R.id.button_Indietro);
        avanti=(Button)findViewById(R.id.button_Avanti);
        vero=(ImageButton) findViewById(R.id.imageButton_Vero);
        falso=(ImageButton) findViewById(R.id.imageButton_Falso);
        nomeGiocatore=(TextView) findViewById(R.id.textView_NomeGiocatore);
        punteggio=(TextView) findViewById(R.id.textView_Punteggio);
        domanda=(TextView) findViewById(R.id.textView_domanda);
        aggiornaDomanda(r.nextInt(numero_domande));

        indietro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aggiornaDomanda(r.nextInt(numero_domande));
            }
        });

        avanti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aggiornaDomanda(r.nextInt(numero_domande));
            }
        });

        vero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Risposta_giusta.equals("Vero")){
                    Punteggio++;
                    punteggio.setText("Punti: "+Punteggio);
                    aggiornaDomanda(r.nextInt(numero_domande));
                    Log.d("Pulsante","Schiacciato Vero");
                }
            }
        });

        falso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Risposta_giusta.equals("Falso")){
                    Punteggio++;
                    punteggio.setText("Punti: "+Punteggio);
                    aggiornaDomanda(r.nextInt(numero_domande));
                    Log.d("Pulsante","Schiacciato Falso");
                }
            }
        });

    }
    private void aggiornaDomanda(int num){
        domanda.setText(domande.getDomanda(num));
        Risposta_giusta = ""+domande.getRisposta(num);
    }
}
