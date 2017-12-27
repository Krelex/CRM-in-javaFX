package hr.java.vjezbe.javafx;

import hr.java.vjezbe.baza.BazaPodataka;
import hr.java.vjezbe.javafx.entitet.Klijent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

/**
 * Created by Fico on 26.6.2017..
 */
public class NoviKlijentController {
    DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;



    @FXML
    private TextField TextIme;

    @FXML
    private TextField TextEmail;

    @FXML
    private TextField TextTelefon;

    @FXML
    private DatePicker FiledRodenje;

    @FXML
    private TextField TextPrezime;

    @FXML
    private TextField TextOIB;

    @FXML
    private Button spremiButton;


    public Klijent noviKlijent () {


        File klijentFile = new File("dat/klijent.txt");
        try (FileWriter writer = new FileWriter(klijentFile,true);) {
            writer.write("\n" + TextOIB.getText() + "\r\n");
            writer.write(TextPrezime.getText() + "\r\n");
            writer.write(TextIme.getText() + "\r\n");
            writer.write(TextTelefon.getText() + "\r\n");
            writer.write(TextEmail.getText() + "\r\n");
            writer.write(formatter.format(FiledRodenje.getValue())+"\r\n");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Uspijesno spremanje Klijenta!");
            alert.setHeaderText("Uspijesno spremanje klijenta!");
            alert.setContentText("Unesni podaci za klijenta su uspojesno spremljeni.");
            alert.showAndWait();

        }catch (IOException E){

            E.printStackTrace();
        }

        Stage stage = (Stage) spremiButton.getScene().getWindow();
        stage.close();

        Klijent klijent = new Klijent(TextIme.getText(),TextPrezime.getText(),TextOIB.getText(),TextTelefon.getText(),TextEmail.getText(),FiledRodenje.getValue());


        try {
            BazaPodataka.spremanjeKlijenta(klijent);
        }catch (IOException ex) {
            ex.printStackTrace();
        }catch (SQLException SQ) {
            SQ.printStackTrace();
        }

        return klijent;


}}
