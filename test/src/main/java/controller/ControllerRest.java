package controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import business.RouletteBusinessImpl;
import model.Bet;
import model.Roulette;

@RestController
@RequestMapping(value = "/web")
public class ControllerRest {
	@Autowired
	RouletteBusinessImpl rouletteBusiness;

	
	
	@GetMapping
	public String hola() {
		return "hola";
	}
	
	@PutMapping("/Bet/{idUser}/{idRoulette}")
	public ResponseEntity<String> replaceEmployee(@RequestBody Bet newBet, @PathVariable("idUser") Long idUser,
			@PathVariable("idRoulette") Long idRoulette) {
		String state = rouletteBusiness.bet(newBet, idRoulette, idUser);
		return ResponseEntity.ok(state);
	}

	@GetMapping(value = "{id}")
	public ResponseEntity<List<Bet>> BetOff(@PathParam("id") long id) {
		List<Bet> resultRoulette = rouletteBusiness.searchBets(id);
		return ResponseEntity.ok(resultRoulette);
	}

	@PostMapping
	public ResponseEntity<Long> newRoulette(@RequestBody Roulette Roulette) {
		long idRoulette = rouletteBusiness.createRoulette(Roulette);
		return ResponseEntity.ok(idRoulette);
	}

	@GetMapping("/roulettes")
	public ResponseEntity<List<Roulette>> getRoulette() {
		List<Roulette> roulettes = rouletteBusiness.searchRoulettes();
		return ResponseEntity.ok(roulettes);
	}

	@GetMapping(value = "{id}")
	public ResponseEntity<String> getRouletteById(@PathVariable("id") long id) {
		String roulette = rouletteBusiness.searchRoulette(id).toString();
		return ResponseEntity.ok(roulette);
	}

	@GetMapping("/openRoulette")
	public ResponseEntity<String> open(@RequestParam(name = "roulette") long roulette) {
		String state = rouletteBusiness.openRoulette(roulette);
		return ResponseEntity.ok(state);
	}

	@DeleteMapping(value = "{id}")
	public ResponseEntity<String> delRoulette(@PathVariable("id") long id) {
		String status = rouletteBusiness.deleteRoulette(id);
		return ResponseEntity.ok(status);
	}

	@PutMapping
	public ResponseEntity<ResponseEntity<Roulette>> setRoulette(@RequestBody Roulette roulette) {
		ResponseEntity<Roulette> rouletteState = rouletteBusiness.updateRoulette(roulette);
		return ResponseEntity.ok(rouletteState);
	}

}
