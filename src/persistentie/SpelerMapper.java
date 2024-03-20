package persistentie;

import domein.Speler;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SpelerMapper {

    private static final String INSERT_SPELER = "INSERT INTO ID400061_G002.Speler (voornaam, achternaam, username, geboortejaar)"
            + "VALUES (?, ?, ?, ?)";
    private static final String UPDATE_SPELER = "UPDATE ID400061_G002.Speler SET krediet = ? WHERE username = ?";
        
    public void voegToe(Speler speler) {

        try (
                Connection conn = DriverManager.getConnection(Connectie.JDBC_URL);
                PreparedStatement query = conn.prepareStatement(INSERT_SPELER)) {
        	query.setString(1, speler.getVoornaam());
            query.setString(2, speler.getAchternaam());            
            query.setString(3, speler.getUsername());
            query.setInt(4, speler.getGeboortejaar());
            query.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Speler> geefSpelers() {
        List<Speler> spelers = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL);
                PreparedStatement query = conn.prepareStatement("SELECT * FROM ID400061_G002.Speler");
                ResultSet rs = query.executeQuery()) {

            while (rs.next()) {
                String achternaam = rs.getString("achternaam");
                String voornaam = rs.getString("voornaam");
                String username = rs.getString("username");
                int geboortejaar = rs.getInt("geboortejaar");

                spelers.add(new Speler(geboortejaar, voornaam, achternaam, username, false));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return spelers;
    }

    public Speler geefSpeler(String username) {
        Speler speler = null;

        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL);
                PreparedStatement query = conn.prepareStatement("SELECT * FROM ID400061_G002.Speler WHERE username = ?")) {
            query.setString(1, username);
            try (ResultSet rs = query.executeQuery()) {
                if (rs.next()) {
                	String achternaam = rs.getString("achternaam");
                    String voornaam = rs.getString("voornaam");
                    String username2 = rs.getString("username");
                    int geboortejaar = rs.getInt("geboortejaar");

                    speler = new Speler(geboortejaar, voornaam, achternaam, username2, false);
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return speler;
    }

    /*public void slaKredietOp(Speler speler) {
        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL);
                PreparedStatement query = conn.prepareStatement(UPDATE_SPELER)) {
            query.setBigDecimal(1, speler.getKrediet());
            query.setString(2, speler.getEmailadres());
            query.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }*/
}
