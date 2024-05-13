package app.model;

import org.springframework.stereotype.Component;

@Component
// Аннотация @Component указывает Spring на то, что этот класс является компонентом и должен быть управляемым контейнером.
public class Dog extends Animal {
    // Конкретная реализация метода toString() для собаки
    @Override
    public String toString() {
        return "I'm a Dog";
    }
}
