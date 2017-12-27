package hr.java.vjezbe.javafx.entitet;

/**
 * Created by Fico on 23.5.2017..
 */
public class Osoba {

    private Integer id;
    private String ime ;
    private String prezime ;

    public Osoba(String ime, String prezime) {
        this.ime = ime;
        this.prezime = prezime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Override
    public String toString() {
        return (this.getIme()+" "+this.getPrezime());
    }
}
