package repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import model.Roulette;

public interface RouletteRepository extends JpaRepository<Roulette, Long> 
{
	@Query("SELECT * from roulette")
	List<Roulette> listRouletteSearch();

}

