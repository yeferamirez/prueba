package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Bet;

public interface BetRepository extends JpaRepository<Bet, Long> {

	@Query("SELECT B Bet B Where B.roulette.id= :roulette ")
	List<Bet> listRouletteSearch(@Param("roulette") long roulette);
}
