package hr.java.vjezbe.javafx;

import hr.java.vjezbe.baza.BazaPodataka;
import hr.java.vjezbe.javafx.entitet.Zaposlenik;
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
public class NoviZaposlenikController {
    @FXML
    private TextField TextIme;

    @FXML
    private TextField TextSifra;

    @FXML
    private TextField TextUserName;

    @FXML
    private Button spremiButton;

    @FXML
    private TextField TextPrezime;

    public Zaposlenik unosZaposlenika () {

        Zaposlenik zaposlenik = null;
        File zaspoelfnikFile = new File("dat/zaposlenik.txt");
        try (FileWriter writer = new FileWriter(zaspoelfnikFile,true);) {
            writer.write("\n" +TextIme.getText() + "\r\n");
            writer.write(   TextPrezime.getText() + "\r\n");
            writer.write(TextUserName.getText() + "\r\n");
            writer.write(TextSifra.getText() + "\r");
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
        zaposlenik = new Zaposlenik(TextIme.getText(),TextPrezime.getText(),TextUserName.getText(),TextSifra.getText()) ;

        try {BazaPodataka.spremanjeZaposlenika(zaposlenik);}
        catch (IOException EX){
            EX.printStackTrace();
        }catch (SQLException E) {
            E.printStackTrace();        }

        return zaposlenik;
}}
