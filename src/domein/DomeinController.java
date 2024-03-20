package domein;

import java.io.FileInputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import dto.SpelerDTO;

public class DomeinController{
	
	
	private SpelerRepository spelerrepo;	
	private KaartRepository kaartrepo;
	private EdeleRepository edelerepo;
	private Speler speler;
	private List<Speler> spelers;
	private Spel spel = new Spel();
	
private static String padTaal ="src/talen/taal.properties";
	
	static final Properties taal = new Properties();
	 static {
	        try {
	            taal.load(new FileInputStream(padTaal));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    };
	
	//Dit is de constructor voor de klasse DomeinController.
	public DomeinController(){
		this.spelerrepo = new SpelerRepository();
		this.kaartrepo = new KaartRepository();
		this.edelerepo = new EdeleRepository();
	}
	
	//Deze methode start een spel
    public void startSpel() {
        this.spel = new Spel();
	}
    
    public void voegSpeler(String username, int geboortejaar)
    {
    	spel.voegSpelerToe(spelerrepo.geefSpeler(username, geboortejaar));
    }

    //Deze methode registreert een nieuwe speler
    public void registreer(String username, String voornaam, String achternaam, int geboortejaar) {	
    	spelerrepo.voegToe(new Speler(geboortejaar, voornaam, achternaam, username, false));
	}
    
    //Deze methode geeft alle info van de speler terug.
    public SpelerDTO geefSpeler() {
		if(speler != null) {		
			return new SpelerDTO(speler.getGeboortejaar(), speler.getVoornaam(), speler.getAchternaam(), speler.getUsername(), speler.getScore(), speler.getEdelstenen(), speler.getKaarten());
		}
		
		return null;
	}
    
    //Deze methode geeft de score van de speler terug
    public int geefScore() {
    	return speler.getScore();
    }
    
    //Deze methode controleert of het spel gedaan is.
	public boolean isEindeSpel() {
		return spel.isEindeSpel();
	}
	
	//Meld een speler aan, aan de hand van zijn username en geboortejaar. 
	public void meldAan(String username, int geboortejaar) {
		speler = spelerrepo.geefSpeler(username, geboortejaar);	
	}
	
	public boolean controleerSpeler(String username)
	{
		boolean antwoord =false;
		if(spelerrepo.bestaatSpeler(username))
		{
			antwoord =true;
		}
		
		return antwoord;
	}
	
	public void infoSpeler(String taalKeuze)
	{
		spel.infoSpeler(taalKeuze);
	}
	
	public List geefKaartNiveau1(String taalkeuze)
	{
		List<Kaart> pick3 = kaartrepo.geefKaartNiveau1();
		return pick3;
		
	}
	public List<Kaart> geefKaartNiveau2(String taalKeuze) 
	{
		List<Kaart> pick3 = kaartrepo.geefKaartNiveau2();
		return pick3;
	}

	public List<Kaart> geefKaartNiveau3(String taalKeuze) 
	{
		List<Kaart> pick3 = kaartrepo.geefKaartNiveau3();
		return pick3;
	}
		
	

	public List<Kaart> toonKaartenVanSpeler(Speler speler2) {
		return speler2.getKaarten();
	}
	
	public List<Edele> geefEdelen(String taalkeuze)
	{
		List<Edele> pick4 = edelerepo.geefEdelen();
		return pick4;
		/*for (Edele edele : pick4) {
			System.out.printf("%s  %s", edele.getPrijs(), edele.getWaarde());
		}*/
	}

	
	
	
}