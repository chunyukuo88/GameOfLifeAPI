package Alex.Gochenour.GameOfLifeAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/petri-dishes")
public class PetriDishController {

	@Autowired
	private PetriDishStorage petriDishStorage;
	
	@GetMapping("")
	public List<PetriDish> findAll() {
		return petriDishStorage.findAllDishes();
	}
	
	@GetMapping("/{name}")
	public PetriDish getPetriDishByName(@PathVariable String name) {
		PetriDish petriDish = petriDishStorage.findDishByName(name);
		return petriDish;
	}
	
	@PostMapping("/add/{name}")
	public  PetriDish addPetriDish(@PathVariable String name, char[][] input) {
		PetriDish petriDish = new PetriDish(name, input);
		petriDishStorage.addDish(petriDish);
		return petriDish;
	}
	
	@DeleteMapping("/remove/{name}")
	public void deleteDish(@PathVariable String name) {
		PetriDish petriDish = petriDishStorage.findDishByName(name);
		petriDishStorage.removeDish(petriDish);
	}
}
