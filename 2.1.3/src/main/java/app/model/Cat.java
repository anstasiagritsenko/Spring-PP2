package app.model;

import org.springframework.stereotype.Component;

@Component("cat")
// Аннотация @Component указывает Spring на то, что этот класс является компонентом и должен быть управляемым контейнером.
// С помощью параметра "cat" указывается имя этого компонента в контейнере Spring.
public class Cat extends Animal {
    // Конкретная реализация метода toString() для кошки
    @Override
    public String toString() {
        return "Im a Cat";
    }
}
