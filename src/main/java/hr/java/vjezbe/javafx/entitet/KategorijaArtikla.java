package hr.java.vjezbe.javafx.entitet;

/**
 * Created by Fico on 6.6.2017..
 */
public enum  KategorijaArtikla {
    SOFTWEAR (1 , "Sistemski artikli"),
    ELEKTROTEHNIKA (2 , "hardverske komponente"),
    MEHANIKA (3 , "Dodatni dijelovi"),
    OSTALO (4 , "Ostali odabir");

    Integer kod ;
    String opis;

    private KategorijaArtikla (Integer kod , String opis) {
        this.kod = kod;
        this.opis = opis;
    }

}
