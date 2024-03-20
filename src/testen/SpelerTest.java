package testen;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Speler;

class SpelerTest {

			
	@ParameterizedTest
	@ValueSource(ints = {2004, 1999, 1960, 2017})
	void maakSpeler_GeldigGeboortejaar_maakSpeler(int geboortejaar) {
		Speler speler = new Speler(geboortejaar , "Jan", "Janssens", "jj", false);
		assertEquals(geboortejaar , speler.getGeboortejaar());

	}  
	
	@ParameterizedTest
	@ValueSource(ints = {2018, 2019})
	void maakSpeler_OngeldigGeboortejaar_maaktGeenSpeler(int geboortejaar) {
		assertThrows(IllegalArgumentException.class, () -> new Speler(geboortejaar , "Jan", "Janssens", "jj",false));
	}// commentaar
	
	@ParameterizedTest
	@ValueSource(strings = {"Tom", "Jan", "Frans"})
	void maakSpeler_GeldigeVoornaam_maakSpeler(String voornaam) {
		Speler speler = new Speler(2004 , voornaam, "Janssens", "jj",false);
		assertEquals(voornaam , speler.getVoornaam());

	}  
	
	@ParameterizedTest
	@ValueSource(strings = {"   ", "\t"})
	void maakSpeler_OngeldigeVoornaam_maaktGeenSpeler(String voornaam) {
		assertThrows(IllegalArgumentException.class, () -> new Speler(2004 , voornaam, "Janssens", "jj",false));
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"Boonen", "Janssens", "Fransen"})
	void maakSpeler_GeldigeAchternaamnaam_maakSpeler(String achternaam) {
		Speler speler = new Speler(2004 , "jan", achternaam, "jj",false);
		assertEquals(achternaam , speler.getAchternaam());

	}  
	
	@ParameterizedTest
	@ValueSource(strings = {"   ", "\t"})
	void maakSpeler_OngeldigeAchternaamnaam_maaktGeenSpeler(String achternaam) {
		assertThrows(IllegalArgumentException.class, () -> new Speler(2004 , "Jan", achternaam, "jj",false));
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"Tommy123", "Frans.1", "JJ"})
	void maakSpeler_GeldigeUsername_maakSpeler(String username) {
		Speler speler = new Speler(2004 , "jan", "Janssens", username,false);
		assertEquals(username , speler.getUsername());

	}  
	
	@ParameterizedTest
	@ValueSource(strings = {"0Tommy", " Fransie"})
	void maakSpeler_OngeldigeUsername_maaktGeenSpeler(String username) {
		assertThrows(IllegalArgumentException.class, () -> new Speler(2004 , "Jan", "Janssens", username, false));
	}
	
	

}
