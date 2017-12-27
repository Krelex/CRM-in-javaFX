package hr.java.vjezbe.javafx;

import hr.java.vjezbe.baza.BazaPodataka;
import hr.java.vjezbe.javafx.entitet.Artikl;
import hr.java.vjezbe.javafx.entitet.KategorijaArtikla;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Fico on 26.6.2017..
 */
public class noviArtiklController {

    @FXML
    private Button spremiButton;

    @FXML
    private TextField textKategorija;

    @FXML
    private TextField textNaziv;

    public Artikl unosArtikla () {
        Artikl artikl = null;
        File artiklFile = new File("dat/artikli.txt");
        try (FileWriter writer = new FileWriter(artiklFile,true);) {
            writer.write("\n" + textNaziv.getText() + "\r");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Uspijesno spremanje Klijenta!");
            alert.setHeaderText("Uspijesno spremanje klijenta!");
            alert.setContentText("Unesni podaci za klijenta su uspojesno spremljeni.");
            alert.showAndWait();
    }catch (IOException E) {
            E.printStackTrace();
        }

        Stage stage = (Stage) spremiButton.getScene().getWindow();
        stage.close();

        artikl = new Artikl(textNaziv.getText(), KategorijaArtikla.SOFTWEAR);

        try {
            BazaPodataka.spremanjeArtikla(artikl);
        }catch (IOException ex) {
            ex.printStackTrace();
        }catch (SQLException SQ) {
            SQ.printStackTrace();
        }

    return artikl;

}}
