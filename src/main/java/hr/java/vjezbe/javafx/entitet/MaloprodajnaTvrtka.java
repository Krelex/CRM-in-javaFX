package hr.java.vjezbe.javafx.entitet;

import java.util.List;

/**
 * Created by Fico on 23.5.2017..
 */
public class MaloprodajnaTvrtka extends Tvrtka {
    private List<Artikl> artikl;
    private Alarm [] alarms;

    public MaloprodajnaTvrtka(String ime, String oib,List<Artikl> artikl) {
        super(ime, oib);
        this.artikl = artikl;
    }


    @Override
    public List<Alarm> getAlarms() {
        return super.getAlarms();
    }

    @Override
    public void setAlarms(List<Alarm> alarms) {
        super.setAlarms(alarms);
    }

    @Override
    public void setKomunkacija(List<Komunkacija> komunkacija) {
        super.setKomunkacija(komunkacija);
    }
}
