package hr.java.vjezbe.javafx.entitet;

/**
 * Created by Fico on 23.5.2017..
 */
public class Artikl {

    private Integer id;
    private String naziv;
    private KategorijaArtikla kategorija;

    public Artikl(String naziv, KategorijaArtikla kategorija) {
        this.naziv = naziv;
        this.kategorija = kategorija;
    }

    public  Artikl () {
        this.naziv = "default";
        this.kategorija=KategorijaArtikla.OSTALO;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public KategorijaArtikla getKategorija() {
        return kategorija;
    }

    public void setKategorija(KategorijaArtikla kategorija) {
        this.kategorija = kategorija;
    }

    public void ispis () {
        System.out.println("Naziv artikla : "+getNaziv());
        System.out.println("Kategorija artikla : " +getKategorija() );

    }

    @Override
    public String toString() {
        return ("\n Ime i prezime : "+this.getNaziv()+ "  " +this.getKategorija() +" \n");
    }
}
