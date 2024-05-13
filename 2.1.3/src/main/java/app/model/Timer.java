package app.model;

import org.springframework.stereotype.Component;

@Component
// Аннотация @Component указывает Spring на то, что этот класс является компонентом и должен быть управляемым контейнером.
public class Timer {

    // Поле для хранения системного времени в наносекундах
    private Long nanoTime = System.nanoTime();

    // Метод для получения текущего времени в наносекундах
    public Long getTime() {
        return nanoTime;
    }
}
