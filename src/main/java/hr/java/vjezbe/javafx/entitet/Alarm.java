package hr.java.vjezbe.javafx.entitet;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by Fico on 13.5.2017..
 */
public class Alarm implements Serializable {

    private Integer id;
    private Klijent klijent;
    private String opisAlarm;
    private LocalDateTime vrijemAlarma;
    private boolean statusAlarm;

    public Alarm(Klijent klijent, String opisAlarm, LocalDateTime vrijemAlarma, boolean statusAlarm) {
        this.klijent = klijent;
        this.opisAlarm = opisAlarm;
        this.vrijemAlarma = vrijemAlarma;
        this.statusAlarm = statusAlarm;
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

    public String getOpisAlarm() {
        return opisAlarm;
    }

    public void setOpisAlarm(String opisAlarm) {
        this.opisAlarm = opisAlarm;
    }

    public boolean isStatusAlarm() {
        return statusAlarm;
    }

    public void setStatusAlarm(boolean statusAlarm) {
        this.statusAlarm = statusAlarm;
    }

    public LocalDateTime getVrijemAlarma() {
        return vrijemAlarma;
    }

    public void setVrijemAlarma(LocalDateTime vrijemAlarma) {
        this.vrijemAlarma = vrijemAlarma;
    }
}
