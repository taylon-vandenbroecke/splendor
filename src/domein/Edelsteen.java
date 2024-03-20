package domein;

import util.Kleur;

public class Edelsteen {
	private Kleur kleur;
	private int aantal;
	
	public Edelsteen(Kleur kleur, int aantal) {
		setKleur(kleur);
		setAantal(aantal);
	}

	public Kleur getKleur() {
		return kleur;
	}

	public void setKleur(Kleur kleur) {
		if(kleur == Kleur.WIT || kleur == Kleur.ROOD || kleur == Kleur.ZWART || kleur == Kleur.GROEN || kleur == Kleur.BLAUW) {
			this.kleur = kleur; //Geef de kleuren van de kaarten weer
		}else {
			throw new IllegalArgumentException("Geef een geldige kleur (Wit, Blauw, Groen, Rood, Zwart)");
		}			
		
	}

	public int getAantal() {
		return aantal;
	}

	public void setAantal(int aantal) {
		if(aantal <0 || aantal > 10) {
			throw new IllegalArgumentException("Het aantal moet liggen tussen 0 en 5");
		}else {
			this.aantal = aantal;
		}
	}
	
	
	
	
}
