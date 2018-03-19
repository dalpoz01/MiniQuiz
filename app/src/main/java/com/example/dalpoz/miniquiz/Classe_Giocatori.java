package com.example.dalpoz.miniquiz;

import java.util.ArrayList;

/**
 * Created by studente on 19/03/2018.
 */

public class Classe_Giocatori {
    ArrayList giocatori=new ArrayList();

    public void aggiungiGiocatore(String Giocatore,String Punteggio){
        giocatori.add(""+Giocatore+""+Punteggio);
    }
    public String getGiocatore(int n){
        String giocatore= (String) giocatori.get(n);
        return giocatore;
    }
    public int getDimensione(){
        return giocatori.size();
    }
}
