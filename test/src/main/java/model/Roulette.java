package model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="roulette")
public class Roulette {

	@Id
	@SequenceGenerator(name="idroulette",sequenceName = "idroulette",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "idroulette")
	private int id;
	
	@Column(name="state")
	private String state;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
	
	
}
