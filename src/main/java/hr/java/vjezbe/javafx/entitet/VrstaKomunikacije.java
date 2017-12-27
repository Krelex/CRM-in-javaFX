package hr.java.vjezbe.javafx.entitet;

/**
 * Created by Fico on 6.6.2017..
 */
public enum  VrstaKomunikacije {

    VERBALNA(1 , "Usmena komunikacija"),
    PISMENA(2 , "Pismena komunkacija"),
    ELEKTORNICKA(3 , "Racunalana komunikacija" ),
    OSTALO(4 , "Ostali tipovi komunikacije");

    Integer kod ;
    String opis;

    private VrstaKomunikacije (Integer kod ,String opis ){
        this.kod = kod;
        this.opis = opis;
    }

    public Integer getKod() {
        return kod;
    }

    public String getOpis() {
        return opis;
    }


}
