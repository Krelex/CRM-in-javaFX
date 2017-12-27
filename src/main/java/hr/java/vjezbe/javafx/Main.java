package hr.java.vjezbe.javafx;

import hr.java.vjezbe.javafx.entitet.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main extends Application {
    static Scanner scanner1 = null;
    private static BorderPane root;
    private Stage primaryStage;



    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        try {
            root=(BorderPane)FXMLLoader.load(getClass().getResource("/sample.fxml"));
            Scene scene = new Scene(root,950,500);
//            scene.getStylesheets().add(getClass().getResource("aplication.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (Exception e) {
            e.printStackTrace();
        }}
//        Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
//        primaryStage.setTitle("Alarmi");
//        primaryStage.setScene(new Scene(root, 500, 500));
//        primaryStage.show();
//    }




    public static void main(String[] args) {
        launch(args);
    }

    public static void  setCenterPane (BorderPane centerPane) {
        root.setCenter(centerPane);
    }

    public static MaloprodajnaTvrtka ucitavanjeTvrtke() {
        MaloprodajnaTvrtka tvrtka = null;
        try {
            scanner1 = new Scanner(new BufferedReader(new FileReader("dat/tvrtka.txt"))) ;
            scanner1.useDelimiter("\n");
            while (scanner1.hasNextLine()) {
                String naziv=scanner1.next();
                scanner1.skip(scanner1.delimiter());
                String oib=scanner1.next();

                 tvrtka = new MaloprodajnaTvrtka(naziv,oib,ucitavanjeArtikla());

            }

        }catch (IOException ex) {
            ex.printStackTrace();
        }return tvrtka;
    }


    public static List<Klijent> ucitavanjeKlijenta () {
        List<Klijent> klijents = new ArrayList<>();
        Klijent klijent = null;
        try {
            scanner1 = new Scanner(new BufferedReader(new FileReader("dat/klijent.txt"))) ;
            scanner1.useDelimiter("\r\n");
            while (scanner1.hasNextLine()) {
                String oib = scanner1.next();
                scanner1.skip(scanner1.delimiter());
                String prezime = scanner1.next();
                scanner1.skip(scanner1.delimiter());
                String ime = scanner1.next();
                scanner1.skip(scanner1.delimiter());
                String brojTel = scanner1.next();
                scanner1.skip(scanner1.delimiter());
                String email = scanner1.next();
                scanner1.skip(scanner1.delimiter());
                LocalDate datum = LocalDate.parse(scanner1.nextLine());


                klijent = new Klijent(ime, prezime, oib, brojTel, email, datum);
                klijents.add(klijent);

            }
        }catch (IOException ex) {
            ex.printStackTrace();
        }
        return klijents;
    }


    public static List<Alarm> ucitavanjeAlarma () {
        List<Alarm> alarms = new ArrayList<>();
        Alarm alarm =null;
        try {

            scanner1 = new Scanner(new BufferedReader(new FileReader("dat/alarm.txt"))) ;
            scanner1.useDelimiter("\n");
            while (scanner1.hasNextLine()) {
                String opis=scanner1.next();


                alarm = new Alarm(ucitavanjeKlijenta().get(0),opis, LocalDateTime.now().plusMinutes(1),true);
                alarms.add(alarm);

            }

        }catch (IOException ex) {
            ex.printStackTrace();
        }
        return alarms;
    }

        public static List<Zaposlenik> ucitavanjeZapolsenika () {
        List<Zaposlenik> zaposleniks = new ArrayList<>();

        try {
            scanner1 = new Scanner(new BufferedReader(new FileReader("dat/zaposlenik.txt"))) ;
            scanner1.useDelimiter("\n");
            while (scanner1.hasNextLine()) {
                String ime = scanner1.next();
                scanner1.skip(scanner1.delimiter());
                String prezime = scanner1.next();
                scanner1.skip(scanner1.delimiter());
                String username = scanner1.next();
                scanner1.skip(scanner1.delimiter());
                String sifra = scanner1.next();



                Zaposlenik zaposlenik = new Zaposlenik(ime,prezime,username,sifra);
                zaposleniks.add(zaposlenik);


            }
        }catch (IOException ex) {
            ex.printStackTrace();
        }
        return zaposleniks;

    }

    public static List<Artikl> ucitavanjeArtikla () {
        List<Artikl>artikls = new ArrayList<>();

        try {
            scanner1 = new Scanner(new BufferedReader(new FileReader("dat/artikli.txt"))) ;
            scanner1.useDelimiter("\n");
            while (scanner1.hasNextLine()) {
                String naziv=scanner1.next();
                KategorijaArtikla kategorija= KategorijaArtikla.SOFTWEAR;

                Artikl artikl = new Artikl(naziv,kategorija);
                artikls.add(artikl);

            }

        }catch (IOException ex) {
            ex.printStackTrace();
        }return artikls;
    }




}
