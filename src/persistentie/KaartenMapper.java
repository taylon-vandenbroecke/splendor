package persistentie;

import domein.Edele;
import domein.Kaart;
import domein.Speler;
import util.Kleur;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class KaartenMapper {
	
	public List<Kaart> geefKaart1() {
        List<Kaart> kaarten = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL);
                PreparedStatement query = conn.prepareStatement("SELECT * FROM ID400061_G002.Kaart WHERE niveau = 1");
                ResultSet rs = query.executeQuery()) {

            while (rs.next()) {
                int kaartID = rs.getInt("KaartID");
            	String kleur = rs.getString("kleur");
                int prestigepunten = rs.getInt("prestigepunten");
                int niveau = rs.getInt("niveau");
                int prijsWit = rs.getInt("prijsWit");
                int prijsRood = rs.getInt("prijsRood");
                int prijsZwart = rs.getInt("prijsZwart");
                int prijsBlauw = rs.getInt("prijsBlauw");
                int prijsGroen = rs.getInt("prijsGroen");

				kaarten.add(new Kaart( kaartID, kleur,  prestigepunten,  niveau,  prijsWit,  prijsRood, prijsZwart,
       				  prijsBlauw,  prijsGroen));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return kaarten;
    }
	
	public List<Kaart> geefKaart2() {
        List<Kaart> kaarten = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL);
                PreparedStatement query = conn.prepareStatement("SELECT * FROM ID400061_G002.Kaart WHERE niveau = 2");
                ResultSet rs = query.executeQuery()) {

            while (rs.next()) {
            	 int kaartID = rs.getInt("KaartID");
            	String kleur = rs.getString("kleur");
                int prestigepunten = rs.getInt("prestigepunten");
                int niveau = rs.getInt("niveau");
                int prijsWit = rs.getInt("prijsWit");
                int prijsRood = rs.getInt("prijsRood");
                int prijsZwart = rs.getInt("prijsZwart");
                int prijsBlauw = rs.getInt("prijsBlauw");
                int prijsGroen = rs.getInt("prijsGroen");

                kaarten.add(new Kaart( kaartID, kleur,  prestigepunten,  niveau,  prijsWit,  prijsRood, prijsZwart,
       				  prijsBlauw,  prijsGroen));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return kaarten;
    }
	
	public List<Kaart> geefKaart3() {
        List<Kaart> kaarten = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL);
                PreparedStatement query = conn.prepareStatement("SELECT * FROM ID400061_G002.Kaart WHERE niveau = 3");
                ResultSet rs = query.executeQuery()) {

            while (rs.next()) {
            	 int kaartID = rs.getInt("KaartID");
            	String kleur = rs.getString("kleur");
                int prestigepunten = rs.getInt("prestigepunten");
                int niveau = rs.getInt("niveau");
                int prijsWit = rs.getInt("prijsWit");
                int prijsRood = rs.getInt("prijsRood");
                int prijsZwart = rs.getInt("prijsZwart");
                int prijsBlauw = rs.getInt("prijsBlauw");
                int prijsGroen = rs.getInt("prijsGroen");

                kaarten.add(new Kaart( kaartID, kleur,  prestigepunten,  niveau,  prijsWit,  prijsRood, prijsZwart,
       				  prijsBlauw,  prijsGroen));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return kaarten;
    }
	
	public List<Edele> geefEdelen() {
        List<Edele> edelen = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL);
                PreparedStatement query = conn.prepareStatement("SELECT * FROM ID400061_G002.Edele");
                ResultSet rs = query.executeQuery()) {

            while (rs.next()) {
            	int idEdele = rs.getInt("idEdele");
                int prestigepunten = rs.getInt("prestigepunten");
                int prijsWit = rs.getInt("prijsWit");
                int prijsRood = rs.getInt("prijsRood");
                int prijsZwart = rs.getInt("prijsZwart");
                int prijsBlauw = rs.getInt("prijsBlauw");
                int prijsGroen = rs.getInt("prijsGroen");

                edelen.add(new Edele(idEdele, prestigepunten, prijsWit, prijsRood, prijsZwart,
       				  prijsBlauw, prijsGroen));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return edelen;
    }
	
}