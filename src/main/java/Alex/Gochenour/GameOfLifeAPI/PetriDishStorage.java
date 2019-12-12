package Alex.Gochenour.GameOfLifeAPI;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetriDishStorage {

	@Autowired
	PetriDishRepo petriDishRepo;
	
	public PetriDish addDish(PetriDish petriDish) {
		return petriDishRepo.save(petriDish);
	}
	
	public PetriDish findDishByName(String name) {
		return petriDishRepo.findDishByName(name);
	}

	public Optional<PetriDish> findDishById(Long id) {
		return petriDishRepo.findById(id);
	}
	
	public List<PetriDish> findAllDishes(){
		return (List<PetriDish>) petriDishRepo.findAll();
	}
	
	public void removeDish(PetriDish petriDish) {
		petriDishRepo.delete(petriDish);
	}
	
}
