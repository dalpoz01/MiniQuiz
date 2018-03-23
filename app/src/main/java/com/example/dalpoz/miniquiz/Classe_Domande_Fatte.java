package com.example.dalpoz.miniquiz;

import java.util.ArrayList;

public class Classe_Domande_Fatte {
    public ArrayList domandefatte=new ArrayList();
    public ArrayList rispostedomandefatte=new ArrayList();
    String domande;
    public void aggiungidomanda(String domanda){
        domandefatte.add(domanda);
    }
    public void aggiungirisposta(String risposta){
        rispostedomandefatte.add(risposta);
    }
    public String getDomande(int n){
        return ""+domandefatte.get(n);
    }
    public String getRisposte(int n){
        return ""+rispostedomandefatte.get(n);
    }

    public boolean controllodomande(String domanda){
        boolean presente=false;
        for (int i=0;i<domandefatte.size();i++){
            domande=""+domandefatte.get(i);
            if(domande.equals(domanda)){
                presente=true;
            }
        }
        return presente;
    }
}
