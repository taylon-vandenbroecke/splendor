package testen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Edelsteen;
import util.Kleur;

class EdelsteenTest {

	
	
	@ParameterizedTest
	@ValueSource(ints = {0, 1, 4, 5})
	void maakEdelsteen_GeldigeAantal_maakEdelsteen(int aantal) {
		Edelsteen edelsteen = new Edelsteen(Kleur.ROOD , aantal);
		assertEquals(Kleur.ROOD, edelsteen.getKleur());
		assertEquals(aantal, edelsteen.getAantal());
	}
	
	@ParameterizedTest
	@ValueSource(ints = {-1, 6, 10, 100})
	void maakEdelsteen_OngeldigeAantal_maaktGeenEdelsteen(int aantal) {
		assertThrows(IllegalArgumentException.class, () -> new Edelsteen(Kleur.GROEN, aantal));
	}


}
