package model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {

	@Id
	@SequenceGenerator(name = "iduser", sequenceName = "iduser", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "iduser")
	private long id;

	@OneToMany(mappedBy = "user")
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

}
