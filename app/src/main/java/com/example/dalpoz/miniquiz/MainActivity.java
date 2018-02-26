package com.example.dalpoz.miniquiz;

import android.graphics.drawable.Icon;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button indietro,avanti;
    ImageButton vero,falso;
    TextView nomeGiocatore,punteggio,domanda;

    private Domande domande=new Domande();
    private String Risposta;
    private int Punteggio=0;
    private int numero_domande=domande.Domande.length;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        indietro=(Button) findViewById(R.id.button_Indietro);
        avanti=(Button)findViewById(R.id.button_Avanti);
        vero=(ImageButton) findViewById(R.id.imageButton_Vero);
        falso=(ImageButton) findViewById(R.id.imageButton_Falso);
        nomeGiocatore=(TextView) findViewById(R.id.textView_NomeGiocatore);
        punteggio=(TextView) findViewById(R.id.textView_Punteggio);
        domanda=(TextView) findViewById(R.id.textView_domanda);
        domanda.setText(domande.getDomanda(1));
    }
}
