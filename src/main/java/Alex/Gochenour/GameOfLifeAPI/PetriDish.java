package Alex.Gochenour.GameOfLifeAPI;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PetriDish {

	@Id
	@GeneratedValue
	private Long id;
	String name;
	char[][] inputArray;

	
//	Constructors ------------------------
	public PetriDish() {}
	
	public PetriDish(String name, char[][] inputArray) {
		this.name = name;
		this.inputArray = inputArray;
	}
//----------------------------------------
	
	
	public String getName() {
		return name;
	}

	public char[][] getInputArray() {
		return inputArray;
	}

	public Long getId() {
		return id;
	}
	
	
}
