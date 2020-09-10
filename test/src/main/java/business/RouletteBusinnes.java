package business;

import java.util.List;

import org.springframework.http.ResponseEntity;

import model.Roulette;

public interface RouletteBusinnes {

	Roulette createRoulette(Roulette roulette);

	String openRoulette(long id);

	void bet(long idRoulette, long idUser, long moneyBet, String color, long number);

	String closeBet(long id);

	void searchBets(long idRoulette);

	List<Roulette> searchRoulettes();

	ResponseEntity<Roulette> searchRoulette(long id);

	deleteRoulette();

}
