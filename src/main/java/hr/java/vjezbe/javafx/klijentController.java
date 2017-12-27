package hr.java.vjezbe.javafx;

import hr.java.vjezbe.baza.BazaPodataka;
import hr.java.vjezbe.javafx.entitet.Alarm;
import hr.java.vjezbe.javafx.entitet.Klijent;
import hr.java.vjezbe.javafx.entitet.MaloprodajnaTvrtka;
import hr.java.vjezbe.javafx.entitet.Zaposlenik;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Fico on 23.6.2017..
 */
public class klijentController {
    private List<Klijent> klijentList;
    private List<Zaposlenik> zaposlenikList;
    private List<Alarm> alarmList;
    private MaloprodajnaTvrtka tvrtka;





    @FXML
        private TableColumn<Klijent, String> brojTelColumn;

        @FXML
        private TableView<Klijent> klijentTable;

        @FXML
        private TableColumn<Klijent, String> prezimeColumn;

        @FXML
        private TableColumn<Klijent, String> datumColumn;

        @FXML
        private TableColumn<Klijent, String> oib;

        @FXML
        private TextField klijentTextField;

        @FXML
        private TableColumn<Klijent, String> imeColumn;

        @FXML
        private TableColumn<Klijent, String> emailColumn;


    public void initialize () {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;

        oib.setCellValueFactory(new PropertyValueFactory<Klijent, String>("oib"));

        prezimeColumn.setCellValueFactory(new PropertyValueFactory<Klijent, String>("prezime"));

        imeColumn.setCellValueFactory(new PropertyValueFactory<Klijent, String>("ime"));

        brojTelColumn.setCellValueFactory(new PropertyValueFactory<Klijent, String>("brojTel"));

        emailColumn.setCellValueFactory(new PropertyValueFactory<Klijent, String>("email"));

        datumColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Klijent, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Klijent, String> param) {
                return new ReadOnlyObjectWrapper<String>(formatter.format(param.getValue().getDatumRod()));
            }

        });


        try {
            zaposlenikList =BazaPodataka.dohvatiZaposlenik();
            klijentList = BazaPodataka.dohvatiKlijente();
            tvrtka = BazaPodataka.dohvatTvrtke();
            alarmList = BazaPodataka.dohvatAlarma();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }catch (SQLException sq) {
            sq.printStackTrace();
        }
        tvrtka.setKlijents(klijentList);
        tvrtka.setZaposleniks(zaposlenikList);

        ObservableList<Klijent> listaKlijenta = FXCollections.observableArrayList(klijentList);
        klijentTable.setItems(listaKlijenta);
    }

    public void prikaziKlijente() {
        List<Klijent> filtriraniklijenti = new ArrayList<Klijent>();
        if (klijentTextField.getText().isEmpty() == false) {
            filtriraniklijenti = klijentList.stream().filter(p -> p.getPrezime()
                    .contains(klijentTextField.getText()))
                    .collect(Collectors.toList());
        } else {
            filtriraniklijenti = klijentList;
        }

        ObservableList<Klijent> listaKlijenta = FXCollections.observableArrayList(filtriraniklijenti);
        klijentTable.setItems(listaKlijenta);

    }


}





