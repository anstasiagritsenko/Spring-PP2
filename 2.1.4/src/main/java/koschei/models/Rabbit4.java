package koschei.models;
// Определение пакета koschei.models для хранения моделей

// Импорт аннотации @Autowired из пакета org.springframework.beans.factory.annotation
// Импорт аннотации @Component из пакета org.springframework.stereotype
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// Аннотация @Component указывает, что этот класс является компонентом, управляемым Spring
@Component
public class Rabbit4 {
    // Приватное поле для хранения экземпляра класса Duck5
    private Duck5 duck;

    // Метод-сеттер для установки зависимости duck
    // Аннотация @Autowired указывает на то, что зависимость будет автоматически внедрена Spring-контейнером
    @Autowired
    public void setDuck(Duck5 duck) {
        this.duck = duck;
    }

    // Переопределение метода toString для представления объекта Rabbit4 в виде строки
    @Override
    public String toString() {
        return ", в зайце утка " + duck.toString();
    }
}
