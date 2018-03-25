package com.example.dalpoz.miniquiz;

public class Classe_Domande {
    public String Domande[]={
            "Il Sole gira intorno alla Terra",
            "Jury Chechi è un noto politico italiano",
            "I Vegani non escludono dal loro stile di vita tutti i prodotti di origine animale. Per esempio mangiano il formaggio",
            "Il sismografo è lo strumento che viene utilizzato per registrare i fenomeni sismici",
            "Se mi trovo ad Ostia mi trovo a due passi da Firenze",
            "Il Museo del Louvre si trova a Firenze",
            "L'ape ha 4 ali",
            "Il mouse è stato inventato nel 1982",
            "Nel Lazio si trova il lago Trasimeno",
            "Gli occhi del camaleonte sono indipendenti l'uno dall'altro",
            "Nel testo dell'inno del Sudafrica ci sono parole di 5 lingue",
            "L'ornitorinco depone le uova ",
            " La prima tavoletta di cioccolato e stata realizzata nel 1958",
            "La città natale di Giuseppe Garibaldi è Nizza",
            "L'antica città di Cartagine corrisponde all'attuale 'Il Cairo' in Egitto",
            "Gli utenti di internet nel 1982 erano circa 200",
            "35 anni era l'eta media nell'antica Grecia",
            "A dicembre in Islanda, ci sono 5 ore di sole al giorno",
            "La digestione inizia nello stomaco già dal primo boccone ",
            "L’argento si utilizza anche per la produzione di calzini"

    };
    public String Risposte[]={
            "Falso",
            "Falso" ,
            "Falso" ,
            "Vero" ,
            "Falso" ,
            "Falso" ,
            "Vero",
            "Falso",
            "Falso",
            "Vero",
            "Vero",
            "Vero",
            "Falso",
            "Vero",
            "Falso",
            "Vero",
            "Vero",
            "Falso",
            "Falso",
            "Vero"
    };
    public String getDomanda(int n){
        String domanda=Domande[n];
        return domanda;
    }
    public String getRisposta(int n){
        String risposta=Risposte[n];
        return risposta;
    }
    public int getDim(){
        return Domande.length;
    }
}
