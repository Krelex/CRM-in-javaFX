package hr.java.vjezbe.javafx.entitet;

/**
 * Created by Fico on 13.5.2017..
 */
public class Zaposlenik extends Osoba {

    private Integer id;


    private String userName;
    private String sifra;

    public Zaposlenik(String ime, String prezime, String userName, String sifra) {
        super(ime, prezime);
        this.userName = userName;
        this.sifra = sifra;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public void ispis () {
        System.out.println("Ime zaposlenika je : "+getIme());
        System.out.println("Prezime zaposlenika je : " +getPrezime() );
        System.out.println("Username zaposlenika je : " +getUserName());
        System.out.println("Sifra zaposlenika je : " +getSifra());
    }

    @Override
    public String toString() {
        return ("\n IME : "+this.getIme()+ " \n PREZIME : " +this.getPrezime()+ " \n SIFRA : " + this.getSifra());
    }
}


