package Alex.Gochenour.GameOfLifeAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/petri-dishes")
public class PetriDishController {

	@Autowired
	private PetriDishStorage petriDishStorage;
	
	@GetMapping("")
	public List<PetriDish> findAll() {
		return petriDishStorage.findAllDishes();
	}
	
}
