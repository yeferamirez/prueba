package business;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import Define.Message;
import exceptions.RouletteException;
import model.Bet;
import model.Roulette;
import repository.BetRepository;
import repository.RouletteRepository;
import repository.UserRepository;

@Component
public class RouletteBusinessImpl implements RouletteBusinnes {

	@Autowired
	BetRepository betRepository;
	@Autowired
	RouletteRepository rouletteRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	Roulette roulette = new Roulette();

	// metodo de que buscar apuestas
	@Override
	public void searchBets(long idRoulette) {
		if (idRoulette != 0) {
			List<Bet> betList = betRepository.listRouletteSearch(idRoulette);
		} else {
			new RouletteException("EL id de laa ruleta no puede ser cero");
		}
	}

	/**
	 * Metodo que abre la ruleta
	 * 
	 * @param idRoulette
	 */
	@Override
	public String openRoulette(long id) {

		roulette = rouletteRepository.findById(id).get();
		roulette.setState("OPEN");
		rouletteRepository.save(roulette);
		return Message.OPENROULETTE.toString();
	}

	// Este metodo realiza la apuesta
	@Override
	public void bet(long idRoulette, long idUser, long moneyBet, String color, long number) {
		Bet bet = new Bet();
	}

	@Override
	public Roulette createRoulette(Roulette roulette) {
		Roulette state = rouletteRepository.save(roulette);
		return state;

	}

	@Override
	public String closeBet(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	// buscar todas las ruletas
	@Override
	public List<Roulette> searchRoulettes() {
		List<Roulette> returnRoulettes = rouletteRepository.findAll();
		return returnRoulettes;

	}

	// buscar 1 ruleta por id
	@Override
	public ResponseEntity<Roulette> searchRoulette(long id) {
		Optional<Roulette> roulette = rouletteRepository.findById(id);
		if (roulette.isPresent()) {
			return ResponseEntity.ok(roulette.get());
		} else {
			return ResponseEntity.noContent().build();
		}

	}

}
