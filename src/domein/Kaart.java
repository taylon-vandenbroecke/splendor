package domein;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import util.Kleur;

public class Kaart {
	private int kaartID, prestigepunten, niveau;
	private String kleur;
	int[] prijslijst = new int[5]; 

	
	public Kaart(int kaartID, String kleur, int prestigepunten, int niveau, int prijsWit, int prijsRood,int prijsZwart,
				 int prijsBlauw, int prijsGroen)
	{
		//setKleur(kleur);
		this.kleur = kleur;
		setPrestigepunten(prestigepunten);
		//setPrijs(kleur ,prijs);
		setPrijs(prijsWit,prijsRood, prijsZwart, prijsBlauw, prijsGroen);
		setNiveau(niveau);
		setKaartID(kaartID);
	}
	
	public int getNiveau() {
		return niveau;
	}
	
	private void setNiveau(int niveau) {
		if(niveau < 1 || niveau > 3)
			throw new IllegalArgumentException("Geef een niveau in van [1-3]");
		this.niveau = niveau; //Geef een kaart een niveau
	}
	
	public int getKaartID() {
		return kaartID;
	}
	
	private void setKaartID(int kaartID) {
		this.kaartID = kaartID;
	}

	public int getPrestigepunten() {
		return prestigepunten;
	}

	public void setPrestigepunten(int prestigepunten) {
		if(prestigepunten < 0 || prestigepunten > 10)
			throw new IllegalArgumentException("Geef een waarde in van [0-10]");
		this.prestigepunten = prestigepunten; //Geef een kaart een waarde (Extra aanpassing) - Proberen extra commit
	}

	public int[] getPrijs1() {
		 return prijslijst;
	}
	public int getPrijs(int index) {
		 return prijslijst[index];
	}

	public void setPrijs(int prijsWit, int prijsRood,int prijsZwart,int prijsBlauw, int prijsGroen) {
		prijslijst[0] = prijsWit;
		prijslijst[1] = prijsRood;
		prijslijst[2] = prijsZwart;
		prijslijst[3] = prijsBlauw;
		prijslijst[4] = prijsGroen;
		controleerPrijs(prijslijst);
	}
	
	private void controleerPrijs(int[] prijslijst) {
		boolean isCorrect = true;
		boolean bevatPrijs = false;
		for (int i = 0; i < prijslijst.length; i++) {
			if(prijslijst[i] < 0 || prijslijst[i] > 7) {
				isCorrect = false;
			}
			if(prijslijst[i] != 0) {
				bevatPrijs = true;
			}
		}
		if(isCorrect == false) {
			throw new IllegalArgumentException("Geef een geldige prijs in");
		}
		if(bevatPrijs == false) {
			throw new IllegalArgumentException("Moet een prijs bevatten.");
		}
	}
	
	/*public void setPrijs(Kleur kleur, int prijs) {
		controleerPrijs(prijs);
		
		switch (kleur) {
			case WIT:
				prijslijst[0] = prijs;
				break;
			case ROOD:
				prijslijst[1] = prijs;
				break;
			case ZWART:
				prijslijst[2] = prijs;
				break;
			case BLAUW:
				prijslijst[3] = prijs;
				break;
			case GROEN:
				prijslijst[4] = prijs;
				break;	
			default:
				break;
		}
		this.prijs = prijs;
	}*/

	/*private void controleerPrijs(int prijs) {
		if(prijs < 0 || prijs > 5) {
			throw new IllegalArgumentException("Geef een geldige prijs in");
		}
	}*/

	public String getKleur() {
		return kleur;
	}

	//public void setKleur(String kleur) {
		//if(kleur.equals(Kleur.WIT) || kleur.equals(Kleur.ROOD) || kleur.equals(Kleur.ZWART) || kleur.equals(Kleur.GROEN) || kleur.equals(Kleur.BLAUW)) {
			//this.kleur = kleur; //Geef de kleuren van de kaarten weer
		//}else {
			//throw new IllegalArgumentException("Geef een geldige kleur (Wit, Blauw, Groen, Rood, Zwart)");
		//}	
	//}
}
