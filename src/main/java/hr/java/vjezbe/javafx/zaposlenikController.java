package hr.java.vjezbe.javafx;

import hr.java.vjezbe.baza.BazaPodataka;
import hr.java.vjezbe.javafx.entitet.Alarm;
import hr.java.vjezbe.javafx.entitet.Klijent;
import hr.java.vjezbe.javafx.entitet.MaloprodajnaTvrtka;
import hr.java.vjezbe.javafx.entitet.Zaposlenik;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Fico on 25.6.2017..
 */
public class zaposlenikController {

    private List<Klijent> klijentList;
    private List<Zaposlenik> zaposlenikList;
    private List<Alarm> alarmList;
    private MaloprodajnaTvrtka tvrtka;


    @FXML
    private TableColumn<Zaposlenik, String> korImeColumn;

    @FXML
    private TableColumn<Zaposlenik, String> prezimeColumn;

    @FXML
    private TableColumn<Zaposlenik, String> sifraColumn;

    @FXML
    private TableView<Zaposlenik> ZaposlenikTable;


    @FXML
    private TextField ZaposlenikTextField;

    @FXML
    private TableColumn<Zaposlenik, String> imeColumn;

    public void initialize() {

        korImeColumn.setCellValueFactory(new PropertyValueFactory<>("userName"));

        imeColumn.setCellValueFactory(new PropertyValueFactory<>("ime"));

        prezimeColumn.setCellValueFactory(new PropertyValueFactory<>("Prezime"));

        sifraColumn.setCellValueFactory(new PropertyValueFactory<>("sifra"));

        try {
            zaposlenikList = BazaPodataka.dohvatiZaposlenik();
            klijentList = BazaPodataka.dohvatiKlijente();
            tvrtka = BazaPodataka.dohvatTvrtke();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }catch (SQLException sq) {
            sq.printStackTrace();
        }
        alarmList = Main.ucitavanjeAlarma();
        tvrtka.setKlijents(klijentList);
        tvrtka.setZaposleniks(zaposlenikList);

        ObservableList<Zaposlenik> listaZaposlenika = FXCollections.observableArrayList(zaposlenikList);
        ZaposlenikTable.setItems(listaZaposlenika);

    }

    public void prikaziKlijente() {
        List<Zaposlenik> filtriranizaposlenici = new ArrayList<Zaposlenik>();
        if (ZaposlenikTextField.getText().isEmpty() == false) {
            filtriranizaposlenici = zaposlenikList.stream().filter(p -> p.getPrezime()
                    .contains(ZaposlenikTextField.getText()))
                    .collect(Collectors.toList());
        } else {
            filtriranizaposlenici = zaposlenikList;
        }

        ObservableList<Zaposlenik> listaZaposlenika = FXCollections.observableArrayList(filtriranizaposlenici);
        ZaposlenikTable.setItems(listaZaposlenika);

    }
}


