package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.AnimalDao;
import web.model.Animal;

import java.util.List;

@Service
@Transactional
public class AnimalServiceImpl implements AnimalService {

    private final AnimalDao animalDao;

    public AnimalServiceImpl(AnimalDao animalDao) {
        this.animalDao = animalDao;
    }

    @Override
    public List<Animal> getAllAnimals() {
        return animalDao.getAllAnimals();
    }

    @Override
    public void createOrUpdateAnimal(Animal animal) {
        if (animal.getId() == 0) {
            createAnimal(animal);
        } else {
            updateAnimal(animal);
        }
    }

    private void createAnimal(Animal animal) {
        animalDao.createAnimal(animal);
    }

    private void updateAnimal(Animal animal) {
        animalDao.updateAnimal(animal);
    }

    @Override
    public Animal readAnimal(long id) {
        return animalDao.readAnimal(id);
    }

    @Override
    public Animal deleteAnimal(long id) {
        Animal animal = animalDao.readAnimal(id);
        if (animal != null) {
            animalDao.deleteAnimal(id);
        }
        return animal;
    }
}
