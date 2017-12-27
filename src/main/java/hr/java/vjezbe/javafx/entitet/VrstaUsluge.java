package hr.java.vjezbe.javafx.entitet;

/**
 * Created by Fico on 6.6.2017..
 */
public enum VrstaUsluge {
    PRODAJNA (1,"Prodjana vrsta usluge"),
    PRAVNA  (2,"Pravna vrsta usluge"),
    OSTALO(3,"Ostala vrsta usluga");

    Integer kod ;
    String opis;

    private VrstaUsluge (Integer kod , String opis ) {
        this.kod=kod;
        this.opis=opis;
    }
}
