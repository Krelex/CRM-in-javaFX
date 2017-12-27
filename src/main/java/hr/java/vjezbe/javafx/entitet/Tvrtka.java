package hr.java.vjezbe.javafx.entitet;

import java.util.List;

/**
 * Created by Fico on 13.5.2017..
 */
public class Tvrtka {

    private Integer id;
    private String ime;
    private String oib;
    private List <Klijent> klijents;
    private List <Zaposlenik> zaposleniks;
    private List <Alarm> alarms;
    private List <Komunkacija> komunkacija;
    private List <Usluga> uslugas;

    public Tvrtka(String ime, String oib) {
        this.ime = ime;
        this.oib = oib;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Klijent> getKlijents() {
        return klijents;
    }

    public void setKlijents(List<Klijent> klijents) {
        this.klijents = klijents;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

    public List<Zaposlenik> getZaposleniks() {
        return zaposleniks;
    }

    public void setZaposleniks(List<Zaposlenik> zaposleniks) {
        this.zaposleniks = zaposleniks;
    }

    public List<Alarm> getAlarms() {
        return alarms;
    }

    public void setAlarms(List<Alarm> alarms) {
        this.alarms = alarms;
    }

    public List<Komunkacija> getKomunkacija() {
        return komunkacija;
    }

    public void setKomunkacija(List<Komunkacija> komunkacija) {
        this.komunkacija = komunkacija;
    }

    public List<Usluga> getUslugas() {
        return uslugas;
    }

    public void setUslugas(List<Usluga> uslugas) {
        this.uslugas = uslugas;
    }

    public void ispis () {
        System.out.println("Ime tvrtke je : "+getIme());
        System.out.println("OIB tvrtke je : "+getOib());

    }


}
