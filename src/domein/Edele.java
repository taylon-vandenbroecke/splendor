package domein;

import util.Kleur;

public class Edele {
	private int kaartID;
	private int waarde;
	private Kleur kleur;
	int[] prijslijst = new int[5]; 

	
	public Edele(int kaartID, int waarde, int prijsWit, int prijsRood,int prijsZwart,
				 int prijsBlauw, int prijsGroen)
	{
		setWaarde(waarde);
		setPrijs(prijsWit,prijsRood, prijsZwart, prijsBlauw, prijsGroen);
		setKaartID(kaartID);
	}
	
	public int getKaartID() {
		return kaartID;
	}
	
	private void setKaartID(int kaartID) {
		this.kaartID = kaartID;
	}

	public int getWaarde() {
		return waarde;
	}

	public void setWaarde(int waarde) {
		if(waarde < 1 || waarde > 10)
			throw new IllegalArgumentException("Geef een waarde in van [1-10]");
		this.waarde = waarde; //Geef een kaart een waarde (Extra aanpassing) - Proberen extra commit
	}

	public int[] getPrijs() {
		return prijslijst;
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
			if(prijslijst[i] < 0 || prijslijst[i] > 5) {
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
	

}
