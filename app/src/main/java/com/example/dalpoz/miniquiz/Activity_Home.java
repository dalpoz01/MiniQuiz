package com.example.dalpoz.miniquiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

public class Activity_Home extends AppCompatActivity {
    String materia,nomegiocatore;
    Spinner sp;
    EditText giocatore;
    ImageButton info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button Inizia=findViewById(R.id.button_Inizia);
        sp=findViewById(R.id.spinner_materia);
        giocatore=findViewById(R.id.editText);
        info=findViewById(R.id.imageButton_inf);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog1();
            }
        });
        Inizia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    materia=""+sp.getSelectedItem();
                    nomegiocatore=""+giocatore.getText();
                    if(nomegiocatore.equals("")||nomegiocatore.equals(" ")){
                        showDialog();
                    }else{
                        Log.d("Nome giocatore:",""+nomegiocatore);
                        Log.d("Materia Home",""+materia);
                        Intent myIntent = new Intent(Activity_Home.this, Activity_domande.class);
                        myIntent.putExtra("Giocatore", ""+nomegiocatore); //Optional parameters
                        myIntent.putExtra("Materia", ""+materia);
                        Activity_Home.this.startActivity(myIntent);
                    }

            }
        });
    }
    private void showDialog1() throws Resources.NotFoundException{
        new AlertDialog.Builder(this)
                .setTitle(getString(R.string.regole))
                .setMessage(getString(R.string.desc_reg))
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //Do Something Here
                            }
                        })
                .setNegativeButton("",
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //Do Something Here
                            }
                        }).show();
    }
    private void showDialog() throws Resources.NotFoundException{
        new AlertDialog.Builder(this)
                .setTitle(getString(R.string.inserisci_il_nome_giocatore))
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //Do Something Here
                            }
                        })
                .setNegativeButton("",
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
