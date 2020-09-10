package business;

import java.util.List;

import org.springframework.http.ResponseEntity;

import model.Bet;
import model.Roulette;

public interface RouletteBusinnes {
	long createRoulette(Roulette roulette);
	String openRoulette(long id);
	String bet(Bet bet,long idRoulette, long idUser);
	List<Bet> searchBets(long idRoulette);
	List<Roulette> searchRoulettes();
	ResponseEntity<Roulette> searchRoulette(long id);
	String deleteRoulette(long id);
	ResponseEntity<Roulette> updateRoulette(Roulette roulette);
	
}
