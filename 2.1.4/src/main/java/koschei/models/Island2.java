package koschei.models;
// Определение пакета koschei.models для хранения моделей

// Импорт аннотации @Component из пакета org.springframework.stereotype
import org.springframework.stereotype.Component;

// Аннотация @Component указывает, что этот класс является компонентом, управляемым Spring
@Component
public class Island2 {
    // Приватное поле для хранения экземпляра класса Wood3
    private Wood3 wood;

    // Конструктор класса Island2 с параметром wood, автоматически связывается Spring-контейнером
    public Island2(Wood3 wood) {
        this.wood = wood;
    }

    // Переопределение метода toString для представления объекта Island2 в виде строки
    @Override
    public String toString() {
        return ", на острове дерево " + wood.toString();
    }
}
