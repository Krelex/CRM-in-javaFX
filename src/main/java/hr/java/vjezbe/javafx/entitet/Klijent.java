package hr.java.vjezbe.javafx.entitet;

import java.time.LocalDate;

/**
 * Created by Fico on 13.5.2017..
 */
public class Klijent extends Osoba{

    private Integer id;
    private String oib ;
    private String brojTel;
    private String email;
    private LocalDate datumRod;

    public Klijent(String ime, String prezime, String oib, String brojTel, String email, LocalDate datumRod) {
        super(ime, prezime);
        this.oib = oib;
        this.brojTel = brojTel;
        this.email = email;
        this.datumRod = datumRod;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Klijent (){
        super("default","default");
    }

    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

    public String getBrojTel() {
        return brojTel;
    }

    public void setBrojTel(String brojTel) {
        this.brojTel = brojTel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDatumRod() {
        return datumRod;
    }

    public void setDatumRod(LocalDate datumRod) {
        this.datumRod = datumRod;
    }

    public void ispis () {
        System.out.println("OIB klijenta je : " +getOib() );
        System.out.println("Ime klijenta je : " +getIme() );
        System.out.println("Prezime klijenta je : " +getPrezime() );
        System.out.println("Broj telefona klijenta je : " +getBrojTel() );
        System.out.println("Email klijenta je : " +getEmail() );
        System.out.println("Datum rodenja klijenta je : "+getDatumRod());
    }
}
