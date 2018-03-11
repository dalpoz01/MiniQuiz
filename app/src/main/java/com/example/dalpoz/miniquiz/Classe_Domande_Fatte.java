package com.example.dalpoz.miniquiz;

import java.util.ArrayList;

public class Classe_Domande_Fatte {
    public ArrayList domandefatte=new ArrayList();

    public void aggiungidomanda(String domanda){
        domandefatte.add(domanda);
    }

    public boolean controllodomande(String domanda){
        boolean presente=false;
        for (int i=0;i<domandefatte.size();i++){
            if(domandefatte.get(i).equals(domanda)){
                presente=true;
            }
        }
        return presente;
    }
}
