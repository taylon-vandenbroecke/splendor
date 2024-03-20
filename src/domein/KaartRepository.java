package domein;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import persistentie.KaartenMapper;

public class KaartRepository {
	private final KaartenMapper mapper;
	private final List<Kaart> kaarten1;
	private final List<Kaart> kaarten2;
	private final List<Kaart> kaarten3;
	
	public KaartRepository() {
		this.mapper  = new KaartenMapper();
		kaarten1 = new ArrayList<>(mapper.geefKaart1());
		kaarten2 = new ArrayList<>(mapper.geefKaart2());
		kaarten3 = new ArrayList<>(mapper.geefKaart3());
	}
	
	public List<Kaart> geefKaartNiveau1() {
		
		Collections.shuffle(kaarten1);
		List<Kaart> pick3 = kaarten1;
		return pick3;
		
	}
	
public List<Kaart> geefKaartNiveau2() {
		
		Collections.shuffle(kaarten2);
		List<Kaart> pick3 = kaarten2;
		return pick3;
	}

public List<Kaart> geefKaartNiveau3() {
	
	Collections.shuffle(kaarten3);
	List<Kaart> pick3 = kaarten3;
	return pick3;
}
}