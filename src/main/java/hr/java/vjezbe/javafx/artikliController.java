package hr.java.vjezbe.javafx;

import hr.java.vjezbe.baza.BazaPodataka;
import hr.java.vjezbe.javafx.entitet.Artikl;
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
public class artikliController {

    private List<Artikl> artiklList = new ArrayList<>();



    @FXML
    private TableColumn<Artikl , String> NazivArtColumn;

    @FXML
    private TableColumn<Artikl , String> kategorijaColumn;

    @FXML
    private TableView<Artikl> ArtikliTable;

    @FXML
    private TextField ArtiklTextField;

    public void initialize () {
        NazivArtColumn.setCellValueFactory(new PropertyValueFactory<>("naziv"));

        kategorijaColumn.setCellValueFactory(new PropertyValueFactory<>("kategorija"));

        try {
            artiklList = BazaPodataka.dohvatiArtikl();
        }catch (IOException ex) {
            ex.printStackTrace();
        }catch (SQLException sq) {
            sq.printStackTrace();
        }
        ObservableList<Artikl> listaAlarma = FXCollections.observableArrayList(artiklList);
        ArtikliTable.setItems(listaAlarma);

    }

    public void prikaziArtikle() {
        List<Artikl> filtriraniA = new ArrayList<Artikl>();
        if (ArtiklTextField.getText().isEmpty() == false) {
            filtriraniA = artiklList.stream().filter(p -> p.getNaziv()
                    .contains(ArtiklTextField.getText()))
                    .collect(Collectors.toList());
        } else {
            filtriraniA = artiklList;
        }
        ObservableList<Artikl> listaAlarma = FXCollections.observableArrayList(filtriraniA);
        ArtikliTable.setItems(listaAlarma);

}}
