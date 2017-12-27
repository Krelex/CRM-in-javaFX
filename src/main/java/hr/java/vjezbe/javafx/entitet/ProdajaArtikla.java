package hr.java.vjezbe.javafx.entitet;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by Fico on 23.5.2017..
 */
public class ProdajaArtikla extends Usluga implements Robna {

    private Integer id;
    private Artikl artikl;
    private VrstaUsluge vrstaUsluge;

    public ProdajaArtikla(Klijent klijent, VrstaUsluge vrstaUsl, String opisUsl, LocalDate datumUsl,
                          BigDecimal cijenaUsl, boolean isporucenaUsl, boolean placenaUsl, Artikl artikl) {
        super(klijent, vrstaUsl, opisUsl, datumUsl, cijenaUsl, isporucenaUsl, placenaUsl);
        this.artikl = artikl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Artikl getArtikl() {
        return artikl;
    }

    public void setArtikl(Artikl artikl) {
        this.artikl = artikl;
    }

    @Override
    public BigDecimal prodaja(int broj) {
        super.setIsporucenaUsl(true);
        super.setPlacenaUsl(true);
        BigDecimal cijena=getCijenaUsl().multiply(new BigDecimal(broj));
        return cijena ;
    }
}
