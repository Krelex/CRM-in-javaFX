package hr.java.vjezbe.javafx.entitet;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by Fico on 13.5.2017..
 */
public class Usluga {

    private Integer id;
    private Klijent klijent;
    private VrstaUsluge vrstaUsl;
    private String opisUsl;
    private LocalDate datumUsl;
    private BigDecimal cijenaUsl;
    private boolean isporucenaUsl=false;
    private boolean placenaUsl=false;

    public Usluga(Klijent klijent, VrstaUsluge vrstaUsl, String opisUsl,
                  LocalDate datumUsl, BigDecimal cijenaUsl, boolean isporucenaUsl, boolean placenaUsl) {
        this.klijent = klijent;
        this.vrstaUsl = vrstaUsl;
        this.opisUsl = opisUsl;
        this.datumUsl = datumUsl;
        this.cijenaUsl = cijenaUsl;
        this.isporucenaUsl = isporucenaUsl;
        this.placenaUsl = placenaUsl;
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

    public VrstaUsluge getVrstaUsl() {
        return vrstaUsl;
    }

    public void setVrstaUsl(VrstaUsluge vrstaUsl) {
        this.vrstaUsl = vrstaUsl;
    }

    public String getOpisUsl() {
        return opisUsl;
    }

    public void setOpisUsl(String opisUsl) {
        this.opisUsl = opisUsl;
    }

    public LocalDate getDatumUsl() {
        return datumUsl;
    }

    public void setDatumUsl(LocalDate datumUsl) {
        this.datumUsl = datumUsl;
    }

    public BigDecimal getCijenaUsl() {
        return cijenaUsl;
    }

    public void setCijenaUsl(BigDecimal cijenaUsl) {
        this.cijenaUsl = cijenaUsl;
    }

    public boolean isIsporucenaUsl() {
        return isporucenaUsl;
    }

    public void setIsporucenaUsl(boolean isporucenaUsl) {
        this.isporucenaUsl = isporucenaUsl;
    }

    public boolean isPlacenaUsl() {
        return placenaUsl;
    }

    public void setPlacenaUsl(boolean placenaUsl) {
        this.placenaUsl = placenaUsl;
    }
}
