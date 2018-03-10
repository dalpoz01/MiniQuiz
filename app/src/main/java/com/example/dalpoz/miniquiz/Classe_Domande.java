package com.example.dalpoz.miniquiz;

public class Classe_Domande {
    public String Domande[]={
        "Il Sole gira intorno alla Terra",
        "Jury Chechi è un noto politico italiano",
        "I Vegani non escludono dal loro stile di vita tutti i prodotti di origine animale. Per esempio mangiano il formaggio",
        "Il sismografo è lo strumento che viene utilizzato per registrare i fenomeni sismici",
        "Se mi trovo ad Ostia mi trovo a due passi da Firenze",
        "Il Museo del Louvre si trova a Firenze"
    };
    public String Risposte[]={
        "Falso",
        "Falso",
        "Falso",
        "Vero",
        "Falso",
        "Falso"
    };
    public String getDomanda(int n){
        String domanda=Domande[n];
        return domanda;
    }
    public String getRisposta(int n){
        String risposta=Risposte[n];
        return risposta;
    }
}
