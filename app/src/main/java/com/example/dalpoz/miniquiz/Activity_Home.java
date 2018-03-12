package com.example.dalpoz.miniquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Activity_Home extends AppCompatActivity {
    String materia,nomegiocatore;
    Spinner sp;
    EditText giocatore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button Inizia=findViewById(R.id.button_Inizia);
        sp=findViewById(R.id.spinner_materia);
        giocatore=findViewById(R.id.editText);

        Inizia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*materia=""+sp.getSelectedItem();
                nomegiocatore=""+giocatore;*/
                    Intent myIntent = new Intent(Activity_Home.this, Activity_domande.class);
                    myIntent.putExtra("key", 1); //Optional parameters
                    Activity_Home.this.startActivity(myIntent);
            }
        });
    }
}
