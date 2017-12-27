package hr.java.vjezbe.javafx.entitet;

import java.time.LocalDateTime;

/**
 * Created by Fico on 13.5.2017..
 */
public class Komunkacija {

    private Integer id;
    private Klijent klijent;
    private Zaposlenik zaposlenik;
    private VrstaKomunikacije vrstaKom;
    private String sadrzajKom;
    private LocalDateTime vrijemeKom;

    public Komunkacija(Klijent klijent, Zaposlenik zaposlenik, VrstaKomunikacije vrstaKom, String sadrzajKom, LocalDateTime vrijemeKom) {
        this.klijent = klijent;
        this.zaposlenik = zaposlenik;
        this.vrstaKom = vrstaKom;
        this.sadrzajKom = sadrzajKom;
        this.vrijemeKom = vrijemeKom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public Zaposlenik getZaposlenik() {
        return zaposlenik;
    }

    public void setZaposlenik(Zaposlenik zaposlenik) {
        this.zaposlenik = zaposlenik;
    }

    public VrstaKomunikacije getVrstaKom() {
        return vrstaKom;
    }

    public void setVrstaKom(VrstaKomunikacije vrstaKom) {
        this.vrstaKom = vrstaKom;
    }

    public String getSadrzajKom() {
        return sadrzajKom;
    }

    public void setSadrzajKom(String sadrzajKom) {
        this.sadrzajKom = sadrzajKom;
    }

    public LocalDateTime getVrijemeKom() {
        return vrijemeKom;
    }

    @Override
    public String toString() {
        return ("Prezime i ime klijenta : " + getKlijent() + "\n" +  "Prezime i ime zaposlenika : " + getZaposlenik() + "\n" + "Vrsta komunikacije : "
        + getVrstaKom() + "\n" + "Sadrzaj komunikacije : " + getSadrzajKom() + "\n" + "Vrijeme komunikacije " + getVrijemeKom());
    }
}

