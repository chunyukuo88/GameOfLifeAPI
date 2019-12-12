package Alex.Gochenour.GameOfLifeAPI;

import javax.persistence.Entity;

@Entity
public class PetriDish {

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
	
}
