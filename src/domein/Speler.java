package domein;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import domein.Kaart;
import util.Kleur;

public class Speler {
	private int geboortejaar;
	private String voornaam, achternaam, username;
	private static int score;
	private ArrayList<Edelsteen> edelstenen;
	private int totPrestigePunten = 0;
	private boolean aanDeBeurt;
	private boolean startSpeler;
	private ArrayList<Kaart> ontwikkelingsKaartenInBezit;
	private ArrayList<Edelsteen> edelstenenInBezit;
	private ArrayList<Edele> edelenInBezit;
	
	
	public Speler(int geboortejaar, String voornaam, String achternaam, String username, boolean aanDeBeurt) {
		setGeboortejaar(geboortejaar);
		setVoornaam(voornaam);
		setAchternaam(achternaam);
		setUsername(username);
		edelstenen = new ArrayList<>();
		ontwikkelingsKaartenInBezit = new ArrayList<>();
		setAanDeBeurt(aanDeBeurt);
		}

	public void setAanDeBeurt(boolean aanDeBeurt) {
		this.aanDeBeurt = aanDeBeurt;
		
	}

	public void voegKaartToe(Kaart kaart) {
		ontwikkelingsKaartenInBezit.add(kaart);
	}	
	
	//Deze methode wordt opgeropen als een speler een gem pakt.
	//Je kan maximum 10 Gems tergelijk hebben. Heb je dit aantal al dan
	//Wordt er een gepaste melding weergegeven.
	public void voegGemToe(Edelsteen edelsteen)
	{
		if(edelstenen.size() >= 10)
			throw new IllegalArgumentException("Je kan maximum 10 edelstenen hebben");
	 edelstenen.add(edelsteen);
	}

	//Deze methode geeft het aantal kaarten terug dat de speler heeft.
	public int toonAantalKaarten()
	{
		return ontwikkelingsKaartenInBezit.size();
	}
	
	//Deze methode geeft de score van de speler heeft terug.
	public int toonScore()
	{
		return score;
	}
	
	//Deze methode geeft het aantal gems  terug dat de speler heeft.
	public int toonAantalGems() {
		return edelstenen.size();
	}
	
	//Getters en setters
	public int getGeboortejaar() {
		return geboortejaar;
	}
	
	private void setGeboortejaar(int geboortejaar) {
		LocalDate currentdate = LocalDate.now();
		if(currentdate.getYear() - geboortejaar >= 6) {
			this.geboortejaar = geboortejaar;
		}else {
			throw new IllegalArgumentException("Je moet minstens 6 jaar oud zijn om dit te spelen");
		}
			
			
	}
	
	public String getAanDeBeurt()
	{ 
		String antwoord = "";
		if(aanDeBeurt == false)
		{
			antwoord = "Niet aan de beurt";
		}
		else
		{
			antwoord = "Aan de beurt";
		}
		return antwoord;
	}
	public String getVoornaam() {
		return voornaam;
	}
	
	private void setVoornaam(String voornaam) {
		if(voornaam == null || voornaam.isBlank())
			throw new IllegalArgumentException("Vul een geldige voornaam in.");
		this.voornaam = voornaam;
	}
	
	public String getAchternaam() {
		return achternaam;
	}
	
	private void setAchternaam(String achternaam) {
		if(achternaam == null || achternaam.isBlank())
			throw new IllegalArgumentException("Vul een geldige achternaam in.");
		this.achternaam = achternaam;
	}
	
	public String getUsername() {
		return username;
	}
	
	private void setUsername(String username) {
		if(username == null || username.isBlank())
			throw new IllegalArgumentException("Vul een geldige username in.");
		
		
		if (!Character.isLetter(username.charAt(0))) {
			throw new IllegalArgumentException("De MOET starten met een letter.");
		}
		
		this.username = username;
	}
	
	public static int getScore()
	{
		return score;
	}

	public ArrayList<Edelsteen> getEdelstenen() {
		
		return edelstenen;
	}

	public ArrayList<Kaart> getKaarten() {
		return ontwikkelingsKaartenInBezit;
	}

	
	
}
