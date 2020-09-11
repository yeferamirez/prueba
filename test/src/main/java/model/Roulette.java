package model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "roulette")
public class Roulette {

	@Id
	@Column(name = "idroulette")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String state;

	@OneToMany(mappedBy = "roulette")
	Bet betList;


	public Bet getBetList() {
		return betList;
	}

	public void setBetList(Bet betList) {
		this.betList = betList;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
