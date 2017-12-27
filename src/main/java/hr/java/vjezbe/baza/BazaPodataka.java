package hr.java.vjezbe.baza;

import hr.java.vjezbe.javafx.entitet.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by Fico on 16.7.2017..
 */
public class BazaPodataka {

    private static final String DATABASE_FILE="C:\\Users\\Fico\\Desktop\\Zadaci\\9.1 - Copy\\cogelja-6\\src\\main\\resources\\bazaPodataka.properties";

    private static Connection spajanjeNaBazu () throws SQLException ,IOException {
        Properties svojstva = new Properties();

        svojstva.load(new FileReader(DATABASE_FILE));
        String urlBazePodataka = svojstva.getProperty("bazaPodatakaUrl");
        String korisnickoIme = svojstva.getProperty("korisnickoIme");
        String lozinka = svojstva.getProperty("lozinka");

        Connection conn = DriverManager.getConnection("jdbc:h2:file:C://Baza//baza","user","user");

        return conn;
    }

    private static void zatvaranjeVezeNaBazu (Connection conn) throws SQLException {
        conn.close();
    }

    public static void spremanjeKlijenta (Klijent klijent) throws SQLException , IOException {
        Connection veza = spajanjeNaBazu();
         veza.setAutoCommit(false);

         try {
             PreparedStatement insertKlijent = veza.prepareStatement("INSERT INTO CRM.KLIJENT (OIB, PREZIME, IME, TELEFON, EMAIL, DATUM_RODJENJA)" +
                     " VALUES (?,?,?,?,?,?); ");
             insertKlijent.setString(1,klijent.getOib());
             insertKlijent.setString(2,klijent.getPrezime());
             insertKlijent.setString(3,klijent.getIme());
             insertKlijent.setString(4,klijent.getBrojTel());
             insertKlijent.setString(5,klijent.getEmail());
             insertKlijent.setDate(6, Date.valueOf(klijent.getDatumRod()));

             insertKlijent.executeUpdate();

             ResultSet generatedKeys = insertKlijent.getGeneratedKeys();

             if (generatedKeys.next()) {
                 klijent.setId(generatedKeys.getInt(1));
             }

             PreparedStatement insertTvrtkaKlijent = veza.prepareStatement("INSERT INTO CRM.TVRTKA_KLIJENT VALUES (? , ?);");

             insertTvrtkaKlijent.setInt(1 , 1);
             insertTvrtkaKlijent.setInt(2,klijent.getId());

             insertTvrtkaKlijent.executeUpdate();

             veza.commit();


         }catch (Throwable ex) {
             veza.rollback();
             throw ex;
         }

         zatvaranjeVezeNaBazu(veza);
    }

    public static void spremanjeArtikla (Artikl artikl) throws IOException , SQLException{
        Connection veza = spajanjeNaBazu();

        veza.setAutoCommit(false);

        try {
            PreparedStatement insertArtikl = veza.prepareStatement("INSERT INTO CRM.ARTIKL (NAZIV, KATEGORIJA_ID) VALUES  (?,?);");

            String s = artikl.toString();
            insertArtikl.setString(1,artikl.getNaziv());
            insertArtikl.setString(2,s);


            insertArtikl.executeUpdate();

            ResultSet generatedKeys = insertArtikl.getGeneratedKeys();
            if (generatedKeys.next()){
                artikl.setId(generatedKeys.getInt(1));
            }

            PreparedStatement insertTvrtkaKlijent = veza.prepareStatement("INSERT INTO CRM.TVRTKA_ARTIKL VALUES (?,?);");
            insertTvrtkaKlijent.setInt(1,1);
            insertTvrtkaKlijent.setInt(2,artikl.getId());

            insertTvrtkaKlijent.executeUpdate();
            veza.commit();

        }catch (Throwable ex) {
            veza.rollback();
            throw ex;
        }

        zatvaranjeVezeNaBazu(veza);
    }

    public static void spremanjeZaposlenika (Zaposlenik zaposlenik) throws IOException , SQLException {
        Connection veza = spajanjeNaBazu();

        veza.setAutoCommit(false);

        try {
            PreparedStatement insertZaposlenik = veza.prepareStatement("INSERT INTO CRM.ZAPOSLENIK (KORISNICKO_IME, PREZIME, IME, SIFRA) VALUES (?,?,?,?);");

            insertZaposlenik.setString(1,zaposlenik.getUserName());
            insertZaposlenik.setString(2,zaposlenik.getPrezime());
            insertZaposlenik.setString(3,zaposlenik.getIme());
            insertZaposlenik.setString(4,zaposlenik.getSifra());
            insertZaposlenik.executeUpdate();

            ResultSet generatedKeys = insertZaposlenik.getGeneratedKeys();
            if (generatedKeys.next()){
                zaposlenik.setId(generatedKeys.getInt(1));
            }

                PreparedStatement insertTvrtkaZaposlenik = veza.prepareStatement("INSERT INTO CRM.TVRTKA_ZAPOSLENIK VALUES (?,?);");
            insertTvrtkaZaposlenik.setInt(1,1);
            insertTvrtkaZaposlenik.setInt(2,zaposlenik.getId());

            insertTvrtkaZaposlenik.executeUpdate();
            veza.commit();

        }catch (Throwable ex) {
            veza.rollback();
            throw ex;
        }

        zatvaranjeVezeNaBazu(veza);
    }

    public static void spremanjeAlarma (Alarm alarm ) throws  IOException , SQLException{
        Connection veza = spajanjeNaBazu();

        veza.setAutoCommit(false);

        try {
            PreparedStatement insertAlarma = veza.prepareStatement("INSERT INTO CRM.ALARM (OPIS, KLIJENT_ID, VRIJEME, AKTIVAN) VALUES (?,?,?,?);");

            insertAlarma.setString(1,alarm.getOpisAlarm());
            insertAlarma.setObject(2,alarm.getKlijent());
            insertAlarma.setDate(3,Date.valueOf(alarm.getVrijemAlarma().toLocalDate()));

            insertAlarma.executeUpdate();

            ResultSet generatedKeys = insertAlarma.getGeneratedKeys();
            if (generatedKeys.next()){
                alarm.setId(generatedKeys.getInt(1));
            }

            PreparedStatement insertTvrtkaKlijent = veza.prepareStatement("INSERT INTO CRM. VALUES (?,?);");
            insertTvrtkaKlijent.setInt(1,1);
            insertTvrtkaKlijent.setInt(1,alarm.getId());

            insertTvrtkaKlijent.executeUpdate();
            veza.commit();

        }catch (Throwable ex) {
            veza.rollback();
            throw ex;
        }

        zatvaranjeVezeNaBazu(veza);
    }

    public static List<Klijent> dohvatiKlijente() throws SQLException , IOException {
        Connection veza = spajanjeNaBazu();
        Statement statementKlijent = veza.createStatement();
        ResultSet resultSetKlijent = statementKlijent.executeQuery("SELECT * FROM CRM.KLIJENT");
        List<Klijent> klijents = new ArrayList<>();

        while (resultSetKlijent.next()) {
            Integer klijentId = resultSetKlijent.getInt("ID");
            String oib = resultSetKlijent.getString("OIB");
            String prezime = resultSetKlijent.getString("PREZIME");
            String ime = resultSetKlijent.getString("IME");
            String brojTelefona = resultSetKlijent.getString("TELEFON");
            String email = resultSetKlijent.getString("EMAIL");
            LocalDate datumRodenja = resultSetKlijent.getDate("DATUM_RODJENJA").toLocalDate();

            Klijent klijent = new Klijent(ime,prezime,oib,brojTelefona,email,datumRodenja);
            klijent.setId(klijentId);

            klijents.add(klijent);
        }

        zatvaranjeVezeNaBazu(veza);
        return klijents;
    }

    public static List<Zaposlenik> dohvatiZaposlenik () throws SQLException , IOException {
        Connection veza = spajanjeNaBazu();
        Statement statementZaposlenik = veza.createStatement();
        ResultSet resultSetZaposlenik = statementZaposlenik.executeQuery("SELECT * FROM CRM.ZAPOSLENIK");
        List<Zaposlenik> zaposleniks = new ArrayList<>();

        while (resultSetZaposlenik.next()) {
            Integer zaposlenikId = resultSetZaposlenik.getInt("ID");
            String korisnickoIme = resultSetZaposlenik.getString("KORISNICKO_IME");
            String prezime = resultSetZaposlenik.getString("PREZIME");
            String ime = resultSetZaposlenik.getString("IME");
            String sifra = resultSetZaposlenik.getString("SIFRA");

            Zaposlenik zaposlenik = new Zaposlenik(ime,prezime,korisnickoIme,sifra);
            zaposlenik.setId(zaposlenikId);

            zaposleniks.add(zaposlenik);
        }
        zatvaranjeVezeNaBazu(veza);
        return zaposleniks;
    }

    public static List<Artikl> dohvatiArtikl () throws SQLException , IOException {
        Connection veza = spajanjeNaBazu();
        Statement statementArtikl = veza.createStatement();
        ResultSet resultSetArtikl = statementArtikl.executeQuery("SELECT * FROM CRM.ARTIKL");
        List<Artikl> artikls = new ArrayList<>();

        Statement statementKategorijaArtikla = veza.createStatement();
        ResultSet resultSetKategorijaArtikla = statementKategorijaArtikla.executeQuery("SELECT * FROM CRM.KATEGORIJA_ARTIKLA");

        while (resultSetArtikl.next()) {
            Integer artiklId = resultSetArtikl.getInt("ID");
            String naziv = resultSetArtikl.getString("NAZIV");

            Artikl artikl = new Artikl(naziv,KategorijaArtikla.OSTALO);
            artikl.setId(artiklId);

            artikls.add(artikl);

        }
        zatvaranjeVezeNaBazu(veza);
        return artikls;

    }

    public static MaloprodajnaTvrtka dohvatTvrtke() throws SQLException , IOException {
        Connection veza = spajanjeNaBazu();
        Statement statementTvrtka = veza.createStatement();
        ResultSet resultSetTvrtka = statementTvrtka.executeQuery("SELECT * FROM CRM.TVRTKA");
        MaloprodajnaTvrtka tvrtka = null;
        while (resultSetTvrtka.next()) {
            Integer tvrtkaId = resultSetTvrtka.getInt("ID");
            String naziv = resultSetTvrtka.getString("NAZIV");
            String oib = resultSetTvrtka.getString("OIB");

            tvrtka = new MaloprodajnaTvrtka(naziv,oib,dohvatiArtikl());

    }
    zatvaranjeVezeNaBazu(veza);
        return tvrtka;

}

    public static List<Alarm> dohvatAlarma () throws SQLException, IOException {
        Connection veza = spajanjeNaBazu();
        Statement statementAlram = veza.createStatement();
        ResultSet resultSetAlram = statementAlram.executeQuery("SELECT * FROM CRM.ALARM");

        Alarm alarm = null;
        List<Alarm> alarms = new ArrayList<>();

        while (resultSetAlram.next()) {
            Integer alarmId = resultSetAlram.getInt("ID");
            String opisAlarma = resultSetAlram.getString("OPIS");
            Integer klijentId= resultSetAlram.getInt("KLIJENT_ID");
            Timestamp vrijeme = resultSetAlram.getTimestamp("VRIJEME");
            Boolean status = resultSetAlram.getBoolean("AKTIVAN");

            LocalDateTime vrijeme2 = vrijeme.toLocalDateTime();
            List <Klijent> klijents = dohvatiKlijente();
            Klijent klijent= klijents.get(1);


            alarm = new Alarm(klijent,opisAlarma,vrijeme2,status);
            alarms.add(alarm);
        }
        zatvaranjeVezeNaBazu(veza);
        return alarms;
    }
}
