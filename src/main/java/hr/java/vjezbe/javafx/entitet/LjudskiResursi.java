package hr.java.vjezbe.javafx.entitet;

import java.util.Collections;
import java.util.List;

/**
 * Created by Fico on 8.6.2017..
 */
public class LjudskiResursi<T extends Osoba > {

    private List<T> listaLjudskiResursa;

    public void get (Integer i) {
        listaLjudskiResursa.get(i);

    }

    public  void add (T tipa) {
        this.listaLjudskiResursa.add(tipa);
    }

    public void getSortedList () {
        Collections.sort(listaLjudskiResursa, (a , b) ->a.getPrezime().compareTo(b.getPrezime()));

    }
    public List<T> getlistaLjudski () {
        return listaLjudskiResursa ;
    }}



