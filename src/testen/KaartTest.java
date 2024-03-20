package testen;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Kaart;
import util.Kleur;

class KaartTest {

	
	@ParameterizedTest
	@ValueSource(ints = {1, 4, 5, 10})
	void maakKaart_GeldigeWaarde_maakKaart(int waarde) {
		Kaart kaart = new Kaart(1,"rood" , waarde, 3, 3, 1, 0, 0, 0);
		assertEquals(waarde , kaart.getPrestigepunten());

	}  
	
	@ParameterizedTest
	@ValueSource(ints = {-1, 0, 11, 100})
	void maakKaart_OngeldigeWaarde_maaktGeenKaart(int waarde) {
		assertThrows(IllegalArgumentException.class, () -> new Kaart(2, "rood" , waarde, 3, 3, 1, 0, 0, 0));
	}
	
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4})
	void maakKaart_GeldigNiveau_maakKaart(int niveau) {
		Kaart kaart = new Kaart(3, "groen" , 1, niveau, 0, 0, 0, 0, 1);
		assertEquals(niveau , kaart.getNiveau());

	}  
	
	@ParameterizedTest
	@ValueSource(ints = {-1, 0, 11, 100})
	void maakKaart_OngeldigNiveau_maaktGeenKaart(int niveau) {
		assertThrows(IllegalArgumentException.class, () -> new Kaart(4, "groen" , 1, niveau, 2, 1, 0, 0, 1));
	}
	
	/*@ParameterizedTest
	@ValueSource(ints = {0, 1, 2, 3, 4, 5})
	void maakKaart_GeldigePrijs_maakKaart(int prijs) {
		Kaart kaart = new Kaart(Kleur.ZWART , 1, 1);
		assertEquals(prijs , kaart.getPrijs());
	}  */
	
	@Test
	void maakKaart_GeldigePrijs_maakKaart() {
		Kaart kaart = new Kaart(5, "zwart" , 1, 1, 0, 1, 2, 3, 4);
		assertArrayEquals(new int[] {0,1,2,3,4}, kaart.getPrijs1());

	}  
	@Test
	void maakKaart_OngeldigePrijs_maaktGeenKaart() {
		assertThrows(IllegalArgumentException.class, () -> new Kaart(6, "zwart" , 1, 1, 0, 0, 0, 0, 0));

	}  
	
	
	/*@ParameterizedTest
	@ValueSource(ints = {-1, 6, 11, 100})
	void maakKaart_OngeldigePrijs_maaktGeenKaart(int prijs) {
		assertThrows(IllegalArgumentException.class, () -> new Kaart("rood" , 1, prijs, 1));
	}*/

}
