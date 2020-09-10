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
@Table(name="bet")
public class Bet {

	@Id
	@SequenceGenerator(name="idbet",sequenceName = "idbet",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "idbet")
	private long id;
	
	@Column(name="color")
	private String color;
	
	@Column(name="number")
	private int number;
	
	@Column(name="money")
	private int money;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	
	
	
}
