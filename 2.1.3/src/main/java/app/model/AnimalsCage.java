package app.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
// Аннотация @Component говорит Spring о том, что этот класс является компонентом и должен быть управляемым контейнером.
public class AnimalsCage {

    @Autowired
    // Аннотация @Autowired указывает Spring на то, что нужно внедрить зависимость.
    @Qualifier("dog")
    // Аннотация @Qualifier используется для выбора конкретной реализации бина.
    private Animal animal;

    @Autowired
    // Снова используется аннотация @Autowired для внедрения зависимости.
    private Timer timer;

    public void whatAnimalSay() {
        // Вывод сообщения о том, что будет сказано
        System.out.println("Say:");
        // Вывод содержания животного
        System.out.println(animal.toString());
        // Вывод времени
        System.out.println("At:");
        System.out.println(timer.getTime());
        // Разделительная строка для наглядности
        System.out.println("________________________");
    }

    public Timer getTimer() {
        // Метод для получения таймера
        return timer;
    }
}
