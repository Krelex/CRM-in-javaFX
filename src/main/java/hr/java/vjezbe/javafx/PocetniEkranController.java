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
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PocetniEkranController {

    private List<Klijent> klijentList;
    private List<Zaposlenik> zaposlenikList;
    private List<Alarm> alarmList;
    private MaloprodajnaTvrtka tvrtka;

    @FXML
    private TextField alarmTextField;

    @FXML
    private TableView<Alarm> alarmTable;

    @FXML
    private TableColumn <Klijent, String> klijent;

    @FXML
    private TableColumn <Alarm , String> opis;

    @FXML
    private TableColumn <Alarm , String> datum;

    public void prikaziEkranKlijent () {
        try {
            BorderPane klijentPane = FXMLLoader.load(Main.class.getResource("/klijent.fxml"));
            Main.setCenterPane(klijentPane);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void prikaziEkranAlarma () {
        try {
            BorderPane alarmPane = FXMLLoader.load(Main.class.getResource("/alarm.fxml"));
            Main.setCenterPane(alarmPane);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void prikazEkranaZaposlenika () {
        try {
            BorderPane zaposlenikPane = FXMLLoader.load(Main.class.getResource("/zaposlenik.fxml"));
            Main.setCenterPane(zaposlenikPane);
        }catch (IOException ex){
            ex.printStackTrace();

        }

    }

    public void prikazEkranaArtikli () {
        try {
            BorderPane artiklPane = FXMLLoader.load(Main.class.getResource("/artikl.fxml"));
            Main.setCenterPane(artiklPane);
        }catch (IOException E){
            E.printStackTrace();
        }


    }

    public void prikaziEkranNovogKorisnika () {
        try {
            BorderPane noviklijentPane = FXMLLoader.load(Main.class.getResource("/unosKlijenta.fxml"));
            Scene scene = new Scene(noviklijentPane,600,400);

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();


        }catch (IOException E){
            E.printStackTrace();
        }
    }

    public void prikaziEkranNovogAlARMA () {
        try {
            BorderPane noviArtiklPane = FXMLLoader.load(Main.class.getResource("/unosArtikla.fxml"));
            Scene scene = new Scene(noviArtiklPane,600,400);

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }catch (IOException E){
            E.printStackTrace();
        }
    }

    public void prikaziEkranNovogZaposlenika () {
        try {
            BorderPane noviZapolenikPane = FXMLLoader.load(Main.class.getResource("/unosZaposlenika.fxml"));
            Scene scene = new Scene(noviZapolenikPane,600,400);

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }catch (IOException E ) {
            E.printStackTrace();
        }
    }


    @FXML
    protected void initialize () {
        DateTimeFormatter  formatter = DateTimeFormatter.ISO_DATE;

        PropertyValueFactory <Klijent , String> klijentProperty = new PropertyValueFactory<Klijent , String>("klijent");


        klijent.setCellValueFactory(klijentProperty);

        opis.setCellValueFactory(new PropertyValueFactory<Alarm ,String>("opisAlarm"));

        datum.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Alarm, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Alarm, String> param) {
                return new ReadOnlyObjectWrapper<String>(formatter.format(param.getValue().getVrijemAlarma()));
            }



        });



        try {
            zaposlenikList = BazaPodataka.dohvatiZaposlenik();
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

        ObservableList<Alarm> alarmObservableList = FXCollections.observableArrayList(alarmList);
        alarmTable.setItems(alarmObservableList);
    }



        public void prikaziAlarme() {
        List<Alarm> filtriraniAlarmi = new ArrayList<Alarm>();
        if (alarmTextField.getText().isEmpty() == false) {
            filtriraniAlarmi = alarmList.stream().filter(p -> p.getKlijent().getOib()
                    .contains(alarmTextField.getText()))
                    .collect(Collectors.toList());
        }

        else {
            filtriraniAlarmi = alarmList;
        }

        ObservableList<Alarm> listaAlarma = FXCollections.observableArrayList(filtriraniAlarmi);
        alarmTable.setItems(listaAlarma);  }

    public List<Klijent> getKlijentList() {
        return klijentList;
    }


    public List<Zaposlenik> getZaposlenikList() {
        return zaposlenikList;
    }


    public List<Alarm> getAlarmList() {
        return alarmList;
    }




}

















