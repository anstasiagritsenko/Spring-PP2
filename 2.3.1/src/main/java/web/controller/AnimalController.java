package web.controller; // Объявление пакета

import org.springframework.stereotype.Controller; // Импорт аннотации Controller
import org.springframework.ui.Model; // Импорт класса Model
import org.springframework.validation.BindingResult; // Импорт класса BindingResult
import org.springframework.web.bind.annotation.*; // Импорт аннотаций для обработки HTTP запросов
import org.springframework.web.servlet.mvc.support.RedirectAttributes; // Импорт класса RedirectAttributes
import web.model.Animal; // Импорт модели Animal
import web.service.AnimalService; // Импорт сервиса AnimalService

import javax.validation.Valid; // Импорт аннотации для валидации входных данных
import java.util.List; // Импорт класса List

@Controller // Аннотация, обозначающая класс как контроллер Spring MVC
@RequestMapping("/animals") // Указание базового URL для всех методов контроллера
public class AnimalController { // Объявление класса AnimalController

    private final AnimalService animalService; // Объявление переменной animalService типа AnimalService

    public AnimalController(AnimalService animalService) { // Конструктор класса AnimalController
        this.animalService = animalService; // Присвоение значения переменной animalService
    }

    @GetMapping({"", "/", "list"}) // Аннотация для обработки HTTP GET запросов к указанному URL
    public String showAllAnimals(Model model, @ModelAttribute("flashMessage") String flashAttribute) { // Метод для отображения списка всех животных
        List<Animal> animals = animalService.getAllAnimals(); // Получение списка всех животных
        model.addAttribute("animals", animals); // Добавление списка животных в модель
        return "list"; // Возвращение имени представления для отображения
    }

    @GetMapping("/add") // Аннотация для обработки HTTP GET запросов к указанному URL
    public String addAnimalForm(Model model) { // Метод для отображения формы добавления животного
        model.addAttribute("animal", new Animal()); // Добавление нового объекта Animal в модель
        return "form"; // Возвращение имени представления для отображения формы
    }

    @GetMapping("/{id}/edit") // Аннотация для обработки HTTP GET запросов к указанному URL
    public String editAnimalForm(@PathVariable(value = "id", required = true) long id, Model model, // Метод для отображения формы редактирования животного
                                 RedirectAttributes attributes) {
        Animal animal = animalService.readAnimal(id); // Получение животного по его ID

        if (null == animal) { // Проверка, найдено ли животное
            attributes.addFlashAttribute("flashMessage", "Животное не найдено!"); // Добавление сообщения об ошибке в атрибуты
            return "redirect:/animals"; // Перенаправление на страницу со списком животных
        }

        model.addAttribute("animal", animal); // Добавление животного в модель
        return "form"; // Возвращение имени представления для отображения формы
    }

    @PostMapping() // Аннотация для обработки HTTP POST запросов к указанному URL
    public String saveAnimal(@ModelAttribute("animal") @Valid Animal animal, BindingResult bindingResult, // Метод для сохранения информации о животном
                             RedirectAttributes attributes, Model model) {
        if (bindingResult.hasErrors()) { // Проверка наличия ошибок валидации
            List<Animal> animals = animalService.getAllAnimals(); // Получение списка всех животных
            model.addAttribute("animals", animals); // Добавление списка животных в модель
            return "form"; // Возвращение имени представления для отображения формы
        }

        animalService.createOrUpdateAnimal(animal); // Создание или обновление информации о животном
        attributes.addFlashAttribute("flashMessage", // Добавление сообщения об успешном сохранении в атрибуты
                "Животное " + animal.getName() + " успешно добавлено!");
        return "redirect:/animals"; // Перенаправление на страницу со списком животных
    }

    @GetMapping("/delete") // Аннотация для обработки HTTP GET запросов к указанному URL
    public String deleteAnimal(@RequestParam(value = "id", required = true, defaultValue = "") long id, // Метод для удаления информации о животном
                               RedirectAttributes attributes) {
        Animal animal = animalService.deleteAnimal(id); // Удаление животного по его ID

        attributes.addFlashAttribute("flashMessage", (null == animal) ? // Добавление сообщения об успешном удалении или ошибке в атрибуты
                "Животное не найдено!" :
                "Животное " + animal.getName() + " успешно удалено!");

        return "redirect:/animals"; // Перенаправление на страницу со списком животных
    }
}
