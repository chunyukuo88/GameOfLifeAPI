package Alex.Gochenour.GameOfLifeAPI;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetriDishRepo extends CrudRepository<PetriDish, Long> {

	PetriDish findDishByName(String name);

}
