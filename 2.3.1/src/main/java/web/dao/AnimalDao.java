package web.dao; // Объявление пакета

import web.model.Animal; // Импорт модели Animal
import java.util.List; // Импорт списка

public interface AnimalDao { // Объявление интерфейса AnimalDao

    List<Animal> getAllAnimals(); // Метод для получения списка всех животных

    void createAnimal(Animal animal); // Метод для создания нового животного

    void updateAnimal(Animal animal); // Метод для обновления информации о животном

    Animal readAnimal(long id); // Метод для чтения информации о животном по его идентификатору

    Animal deleteAnimal(long id); // Метод для удаления животного по его идентификатору
}
