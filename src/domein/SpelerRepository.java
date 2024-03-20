package domein;

import java.util.ArrayList;
import java.util.List;
import persistentie.SpelerMapper;

public class SpelerRepository {
	private final SpelerMapper mapper;
	
	public SpelerRepository() {
		mapper = new SpelerMapper();
	}
	
	public void voegToe(Speler speler) {
	       if (bestaatSpeler(speler.getUsername()))
	            throw new IllegalArgumentException("Er bestaat reeds een speler met deze username!");
	       
	       mapper.voegToe(speler);
	    }

	public boolean bestaatSpeler(String username){
	    return mapper.geefSpeler(username)!=null;
	}
	
	
	
	public Speler geefSpeler(String username, int geboortejaar){
        Speler s = mapper.geefSpeler(username);
        if (s.getGeboortejaar() != geboortejaar) {
        	return null;
        }else {
        	return s;
        }
            
        
        
    }
}
