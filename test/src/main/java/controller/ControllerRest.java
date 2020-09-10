package controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import business.RouletteBusinessImpl;
import model.Roulette;

@RestController
@RequestMapping(value = "/web")
public class ControllerRest {
	@Autowired
	RouletteBusinessImpl rouletteBusiness;
	
	@PostMapping
	public ResponseEntity<Roulette> newRoulette(@RequestBody Roulette roulette){
		Roulette rouletteState = rouletteBusiness.createRoulette(roulette);
		return ResponseEntity.ok(rouletteState);	
	}

	@GetMapping("/roulettes")
	public ResponseEntity<List<Roulette>> getRoulette() {
		List<Roulette> roulettes = rouletteBusiness.searchRoulettes();
		return ResponseEntity.ok(roulettes);
	}

	@GetMapping(value = "{id}")
	public ResponseEntity<String> getRouletteById(@PathVariable("id") long id) {
		String roulette = rouletteBusiness.searchRoulette(id).toString();
		return new ResponseEntity<>(roulette, HttpStatus.OK);
	}

	@GetMapping("/openRoulette")
	public ResponseEntity<String> open(@RequestParam(name = "roulette") long roulette) {
		String state = rouletteBusiness.openRoulette(roulette);
		return new ResponseEntity<>(state, HttpStatus.OK);
		// en caso de q algo salga mal return new ResponseEntity<>(state,
		// HttpStatus.BAD_REQUEST);

	}
	
	@DeleteMapping
	public ResponseEntity<Roulette> delRoulette(@PathVariable("id") long id){
		Roulette rouletteState = rouletteBusiness.createRoulette(roulette);
		return ResponseEntity.ok(rouletteState);	
	}
	
}
