package com.example.dalpoz.miniquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class Activity_domande extends AppCompatActivity {
    Button indietro,avanti;
    ImageButton vero,falso;
    TextView nomeGiocatore,punteggio,domanda;
    String giocatore,materia;
    boolean controllo=false;
    private Classe_Domande domande=new Classe_Domande();
    private Classe_Domande_Fatte domandesvolte=new Classe_Domande_Fatte();
    private String Risposta,Risposta_giusta,Domandafatta;
    private int Punteggio=0;
    private int numero_domande=domande.Domande.length;
    private int domande_eseguite=0;


    Random r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_domande);
        r=new Random();
        indietro=(Button) findViewById(R.id.button_Indietro);
        avanti=(Button)findViewById(R.id.button_Avanti);
        vero=(ImageButton) findViewById(R.id.imageButton_Vero);
        falso=(ImageButton) findViewById(R.id.imageButton_Falso);
        nomeGiocatore=(TextView) findViewById(R.id.textView_NomeGiocatore);
        punteggio=(TextView) findViewById(R.id.textView_Punteggio);
        domanda=(TextView) findViewById(R.id.textView_domanda);
        aggiornaDomanda(r.nextInt(numero_domande));
        indietro.setEnabled(false);

        Bundle b = getIntent().getExtras();
        giocatore=b.getString("Giocatore");
        nomeGiocatore.setText(""+giocatore);
        materia=b.getString("Materia");
        Log.d("Materia_Activity_domand",""+materia);
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
                indietro.setEnabled(true);
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
                }else{
                    Intent i = new Intent(Activity_domande.this, Activity_classifica.class);
                    i.putExtra("Giocatore",""+giocatore);//Optional parameters
                    i.putExtra("Punteggio",""+Punteggio);
                    Activity_domande.this.startActivity(i);
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
        int j=0;
        Domandafatta=""+domande.getDomanda(num);
        while(j<domande_eseguite){
            controllo=domandesvolte.controllodomande(Domandafatta);
            if(controllo==true){
                num=r.nextInt(numero_domande);
                Domandafatta=""+domande.getDomanda(num);
            }
            j++;
        }
        domanda.setText(Domandafatta);
        domande_eseguite++;
        domandesvolte.aggiungidomanda(Domandafatta);
        Risposta_giusta = ""+domande.getRisposta(num);
    }
    private void ripristina_domanda(int num){

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
