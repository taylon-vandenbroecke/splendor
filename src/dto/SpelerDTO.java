package dto;

import java.util.ArrayList;

import domein.Edelsteen;
import domein.Kaart;

public record SpelerDTO(int geboortejaar, String voornaam, String achternaam, String username, int score, ArrayList<Edelsteen> edelstenen, ArrayList<Kaart> kaarten) {

}
