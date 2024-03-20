package domein;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import util.Kleur;

public class Spel {

	private List<Edele> beschikbareEdelen;
	private List<Kaart> ontwikkelingskaarten;
	private List<Edelsteen> resterendeVoorraad;
	private ArrayList<Speler> spelers;
	
	private Edelsteen wit;
	private Edelsteen rood;
	private Edelsteen zwart;
	private Edelsteen blauw;
	private Edelsteen groen;
	
	private EdeleRepository edeleRepo = new EdeleRepository();
	
	private static String padTaal ="src/talen/taal.properties";
	
	static final Properties taal = new Properties();
	 static {
	        try {
	            taal.load(new FileInputStream(padTaal));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    };
	
	public Spel()
	{
		wit = new Edelsteen(Kleur.WIT, 5);
		rood = new Edelsteen(Kleur.ROOD, 5);
		zwart = new Edelsteen(Kleur.ZWART, 5);
		blauw = new Edelsteen(Kleur.BLAUW, 5);
		groen = new Edelsteen(Kleur.GROEN, 5);
		beschikbareEdelen = new ArrayList<>();
		resterendeVoorraad = new ArrayList<>();
		resterendeVoorraad.add(0, wit);
		resterendeVoorraad.add(1, rood);
		resterendeVoorraad.add(2, zwart);
		resterendeVoorraad.add(3, blauw);
		resterendeVoorraad.add(4, groen);
		
		voegEdelenToe();
		spelers = new ArrayList<>();
	}
	
	private void voegEdelenToe() {
		beschikbareEdelen.addAll(edeleRepo.geefEdelen());
	}

	public boolean isEindeSpel()
	{
		boolean antwoord = false;
		if(Speler.getScore()>15)
		{
			antwoord = true;
		}
		return antwoord;
	}
	
	public void koopKaarten(Speler speler, Kaart kaarten)
	{
		speler.voegKaartToe(kaarten);
	}
	
	public void neemEdelsteen(Speler speler, Edelsteen edelsteen)
	{
		speler.voegGemToe(edelsteen);
	}
	
	public void toonKaarten(Speler speler)
	{
		speler.toonAantalKaarten();
	}
	
	public void toonEdelstenen(Speler speler)
	{
		speler.toonAantalGems();
	}
	
	public void voegSpelerToe(Speler speler)
	{
		spelers.add(speler);
	}
	public void infoSpeler(String taalKeuze)
	{
		for(int i = 0; i < spelers.size(); i++) {
			System.out.println(taal.getProperty(taalKeuze + "Username") + spelers.get(i).getUsername() );  
			System.out.println(taal.getProperty(taalKeuze + "Edelstenen") + spelers.get(i).toonAantalGems());  
			System.out.println(taal.getProperty(taalKeuze + "Kaarten") + spelers.get(i).toonAantalKaarten());  
			System.out.println(taal.getProperty(taalKeuze + "Score") + spelers.get(i).getScore() );
			System.out.println(taal.getProperty(taalKeuze + "AanDeBeurt") + spelers.get(i).getAanDeBeurt() );
			}
	}

	public List<Edele> getBeschikbareEdelen() {
		return beschikbareEdelen;
	}

	public void setBeschikbareEdelen(ArrayList<Edele> beschikbareEdelen) {
		
		this.beschikbareEdelen = beschikbareEdelen;
	}

	public List<Kaart> getOntwikkelingskaarten() {
		return ontwikkelingskaarten;
	}

	public void setOntwikkelingskaarten(ArrayList<Kaart> ontwikkelingskaarten) {
		this.ontwikkelingskaarten = ontwikkelingskaarten;
	}

	public List<Edelsteen> getResterendeVoorraad() {
		return resterendeVoorraad;
	}

	public void setResterendeVoorraad(ArrayList<Edelsteen> resterendeVoorraad) {
		this.resterendeVoorraad = resterendeVoorraad;
	}
	
}
