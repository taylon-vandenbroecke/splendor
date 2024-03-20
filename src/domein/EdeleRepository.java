package domein;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import persistentie.KaartenMapper;

public class EdeleRepository {
	private final KaartenMapper mapper;
	private final List<Edele> lijstEdelen;
	
	public EdeleRepository() {
		this.mapper = new KaartenMapper();
		lijstEdelen = new ArrayList<>(mapper.geefEdelen());
	}
	
	public List<Edele> geefEdelen() {
		Collections.shuffle(lijstEdelen);
		List<Edele> pick4 = lijstEdelen.subList(0, 4);
		return pick4;
	}
}
