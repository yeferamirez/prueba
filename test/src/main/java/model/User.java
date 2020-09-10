package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="user")
public class User {

	@Id
	@SequenceGenerator(name="iduser",sequenceName = "iduser",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "iduser")
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
	
	
}
