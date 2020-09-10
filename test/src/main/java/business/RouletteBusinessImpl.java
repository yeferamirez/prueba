package business;

import java.util.List;
import java.util.Optional;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import Define.Colors;
import Define.Message;
import exceptions.RouletteException;
import model.Bet;
import model.Roulette;
import model.User;
import repositoryDao.BetRepository;
import repositoryDao.RouletteRepository;
import repositoryDao.UserRepository;

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
	@Autowired
	Bet bet = new Bet();
	@Autowired
	User user = new User();

	@Override
	public List<Bet> searchBets(long idRoulette) {
		if (idRoulette != 0) {
			List<Bet> betList = betRepository.listRouletteSearch(idRoulette);
			roulette = rouletteRepository.findById(idRoulette).get();
			roulette.setState("CLOSE");
			rouletteRepository.save(roulette);
			return betList;
		} else {
			new RouletteException("EL id de laa ruleta no puede ser cero");
			return null;
		}
	}

	@Override
	public String openRoulette(long id) {
		roulette = rouletteRepository.findById(id).get();
		roulette.setState(Message.OPEN.toString());
		rouletteRepository.save(roulette);
		return Message.OPENROULETTE.toString();
	}

	public boolean money(Bet bet) {
		if (bet.getMoney() < 10000) {
			return true;
		} else {
			return false;
		}
	}

	public boolean color(Bet bet) {
		if (bet.getColor().equalsIgnoreCase(Colors.BLACK.toString())
				|| bet.getColor().equalsIgnoreCase(Colors.RED.toString())) {
			return true;
		} else {
			return false;
		}
	}

	public boolean number(Bet bet) {
		if (bet.getNumber() >= 0 && bet.getNumber() <= 36) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String bet(Bet bet, long idRoulette, long idUser) {
		Optional<Roulette> rouletteNew = rouletteRepository.findById(idRoulette);
		if (rouletteNew.isPresent()) {
			if (color(bet) && number(bet) && money(bet)) {
				if (roulette.getState().equalsIgnoreCase((Message.OPEN.toString()))) {
					betRepository.save(bet);
					user.setId(idUser);
					userRepository.save(user);
					return Message.BETSUCESS.toString();
				}
			}
		}
		return Message.BETNOCREATED.toString();

	}

	@Override
	public long createRoulette(Roulette roulette) {
		Roulette rouletteCreated = rouletteRepository.save(roulette);
		long state = rouletteCreated.getId();
		return state;
	}

	@Override
	public List<Roulette> searchRoulettes() {
		List<Roulette> returnRoulettes = rouletteRepository.findAll();
		return returnRoulettes;
	}

	@Override
	public ResponseEntity<Roulette> searchRoulette(long id) {
		Optional<Roulette> roulette = rouletteRepository.findById(id);
		if (roulette.isPresent()) {
			return ResponseEntity.ok(roulette.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@Override
	public String deleteRoulette(long id) {
		rouletteRepository.deleteById(id);
		return Message.ROULETTEDELETE.toString();
	}

	@Override
	public ResponseEntity<Roulette> updateRoulette(Roulette roulette) {
		Optional<Roulette> rouletteNew = rouletteRepository.findById(roulette.getId());
		if (rouletteNew.isPresent()) {
			Roulette update = rouletteNew.get();
			update.setState("close");
			rouletteRepository.save(update);
			return ResponseEntity.ok(update);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
