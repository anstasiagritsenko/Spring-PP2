package web.controller; // Объявление пакета

import org.springframework.beans.factory.annotation.Autowired; // Импорт аннотации Autowired
import org.springframework.stereotype.Controller; // Импорт аннотации Controller
import org.springframework.ui.Model; // Импорт класса Model
import org.springframework.web.bind.annotation.GetMapping; // Импорт аннотации GetMapping
import org.springframework.web.bind.annotation.RequestMapping; // Импорт аннотации RequestMapping
import web.model.Animal; // Импорт модели Animal
import web.service.AnimalService; // Импорт сервиса AnimalService

@Controller // Аннотация, обозначающая класс как контроллер Spring MVC
@RequestMapping("/") // Указание базового URL для всех методов контроллера
public class IndexController { // Объявление класса IndexController

    @Autowired // Аннотация для внедрения зависимости через автосвязывание
    private AnimalService userService; // Объявление переменной userService типа AnimalService

    @GetMapping("") // Аннотация для обработки HTTP GET запросов к указанному URL
    public String indexView(Model model) { // Метод для отображения главной страницы
        Animal animal = new Animal(); // Создание нового объекта класса Animal
        model.addAttribute("animal", animal); // Добавление атрибута "animal" в модель
        return "index"; // Возвращение имени представления для отображения
    }
}
