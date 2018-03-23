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

import java.util.ArrayList;
import java.util.Random;

public class Activity_domande extends AppCompatActivity {
    Button avanti;
    ImageButton vero,falso;
    TextView nomeGiocatore,punteggio,domanda,numdom;
    String giocatore;
    boolean controllo=false;
    private Classe_Domande domande=new Classe_Domande();
    private Classe_Domande_Fatte domandesvolte=new Classe_Domande_Fatte();
    private String Risposta_giusta,Domandafatta,materia;
    private int Punteggio=0;
    private int numero_domande=domande.Domande.length;
    private int domande_eseguite=0;
    ArrayList num_domande=new ArrayList();

    Random r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_domande);
        r=new Random();
        avanti=(Button)findViewById(R.id.button_Avanti);
        vero=(ImageButton) findViewById(R.id.imageButton_Vero);
        falso=(ImageButton) findViewById(R.id.imageButton_Falso);
        nomeGiocatore=(TextView) findViewById(R.id.textView_NomeGiocatore);
        punteggio=(TextView) findViewById(R.id.textView_Punteggio);
        domanda=(TextView) findViewById(R.id.textView_domanda);
        numdom=findViewById(R.id.num_dom);
        Bundle b = getIntent().getExtras();
        giocatore=b.getString("Giocatore");
        nomeGiocatore.setText(""+giocatore);
        materia=b.getString("Materia");
        Log.d("Materia_Activity_domand",""+materia);
        aggiornaDomanda(r.nextInt(numero_domande));
        avanti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(domande_eseguite==6){
                    Intent i = new Intent(Activity_domande.this, Activity_classifica.class);
                    i.putExtra("Giocatore",""+giocatore);//Optional parameters
                    i.putExtra("Punteggio",""+Punteggio);
                    Activity_domande.this.startActivity(i);
                }else{
                    aggiornaDomanda(r.nextInt(numero_domande));
                }
            }
        });

        vero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Risposta_giusta.equals("Vero")){
                    Punteggio++;
                    punteggio.setText("Punti: "+Punteggio);
                    Log.d("Pulsante","Schiacciato Vero");
                    if(domande_eseguite==6){
                        Intent i = new Intent(Activity_domande.this, Activity_classifica.class);
                        i.putExtra("Giocatore",""+giocatore);//Optional parameters
                        i.putExtra("Punteggio",""+Punteggio);
                        Activity_domande.this.startActivity(i);
                    }else{
                        aggiornaDomanda(r.nextInt(numero_domande));
                    }
                }else{
                    if(domande_eseguite==6){
                        Intent i = new Intent(Activity_domande.this, Activity_classifica.class);
                        i.putExtra("Giocatore",""+giocatore);//Optional parameters
                        i.putExtra("Punteggio",""+Punteggio);
                        Activity_domande.this.startActivity(i);
                    }else{
                        aggiornaDomanda(r.nextInt(numero_domande));
                    }
                }
            }
        });

        falso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Risposta_giusta.equals("Falso")){
                    Punteggio++;
                    punteggio.setText("Punti: "+Punteggio);
                    if(domande_eseguite==6){
                        Intent i = new Intent(Activity_domande.this, Activity_classifica.class);
                        i.putExtra("Giocatore",""+giocatore);//Optional parameters
                        i.putExtra("Punteggio",""+Punteggio);
                        Activity_domande.this.startActivity(i);
                    }else{
                        aggiornaDomanda(r.nextInt(numero_domande));
                    }
                    Log.d("Pulsante","Schiacciato Falso");
                }else{
                    if(domande_eseguite==6){
                        Intent i = new Intent(Activity_domande.this, Activity_classifica.class);
                        i.putExtra("Giocatore",""+giocatore);//Optional parameters
                        i.putExtra("Punteggio",""+Punteggio);
                        Activity_domande.this.startActivity(i);
                    }else{
                        aggiornaDomanda(r.nextInt(numero_domande));
                    }
                }
            }
        });

    }
    private boolean controllo(int num){
        boolean controlla=false;
        String prova,numero=""+num;
        for(int i=0;i<num_domande.size();i++){
            prova=""+num_domande.get(i);
            System.out.println(""+prova);
            if(prova.equals(numero)){
                controlla=true;
            }
        }
        return controlla;
    }
    private void aggiornaDomanda(int num){
        boolean controlla=true;
        if(domande_eseguite==0){
            Domandafatta=""+domande.getDomanda(num);
            domanda.setText(Domandafatta);
            domande_eseguite++;
            Risposta_giusta = ""+domande.getRisposta(num);
            numdom.setText(""+domande_eseguite);
        }else{
            controlla=controllo(num);
            while(controlla==true){
                num=r.nextInt(numero_domande);
                controlla=controllo(num);
            }
            Domandafatta=""+domande.getDomanda(num);
            domanda.setText(Domandafatta);
            domande_eseguite++;
            numdom.setText(""+domande_eseguite);
            Risposta_giusta = ""+domande.getRisposta(num);
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
