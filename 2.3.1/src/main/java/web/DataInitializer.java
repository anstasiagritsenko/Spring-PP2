package web;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import web.config.AppConfig;
import web.model.Animal;
import web.service.AnimalService;

public class DataInitializer {
    public static void main(String[] args) {
        // Создаем контекст приложения на основе конфигурационного класса AppConfig
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Получаем бин AnimalService из контекста
        AnimalService animalService = context.getBean(AnimalService.class);

        // Создаем объекты Animal и добавляем их в базу данных
        Animal animal1 = new Animal("Барсик", 3, "Кот", "Дворовая", "Мужской", "Рыжий");
        animalService.createOrUpdateAnimal(animal1);

        Animal animal2 = new Animal("Мурка", 2, "Кошка", "Домашняя", "Женский", "Белый");
        animalService.createOrUpdateAnimal(animal2);

        // Закрываем контекст приложения
        context.close();
    }
}
