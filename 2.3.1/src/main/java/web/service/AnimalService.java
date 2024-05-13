package web.service;

import web.model.Animal;

import java.util.List;

public interface AnimalService {

    List<Animal> getAllAnimals();

    Animal readAnimal(long id);

    Animal deleteAnimal(long id);

    void createOrUpdateAnimal(Animal animal);
}
