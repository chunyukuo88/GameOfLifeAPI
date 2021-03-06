package Alex.Gochenour.GameOfLifeAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Populator implements CommandLineRunner {

	@Autowired
	private PetriDishStorage petriDishStorage; 
	
	@Override
	public void run(String... args) throws Exception {
		
		producePetriDishes();
		
	}
	
	private void producePetriDishes() {
		char[][] blankDishArray = 
			   {
				{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},				
				{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},				
				{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
				};
		PetriDish blankDish = new PetriDish("Blank Dish", blankDishArray); 
		petriDishStorage.addDish(blankDish);
		
		char[][] propellorsArray = 
			   {
				{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '@', '@', '@', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},				
				{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '@', '@', '@', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '@', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '@', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '@', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},				
				{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
				};
		PetriDish propellors = new PetriDish("Propellors", propellorsArray); 
		petriDishStorage.addDish(propellors);
		
		char[][] gliderArray = 
			   {
				{'.', '@', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '@', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'@', '@', '@', '.', '.', '.', '@', '.', '.', '.', '.', '.', '.', '.', '.', '.'},				
				{'.', '.', '.', '.', '.', '.', '.', '@', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '@', '@', '@', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '@', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '@', '.', '.', '.', '.', '.', '.', '.', '@', '.', '.', '.', '.', '.'},
				{'@', '@', '@', '.', '.', '.', '.', '.', '.', '.', '@', '.', '@', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '@', '@', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},				
				{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
				};
		PetriDish glider = new PetriDish("Glider", gliderArray); 
		petriDishStorage.addDish(glider);
	}
}
