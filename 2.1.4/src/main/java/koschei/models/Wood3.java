package koschei.models;
// Определение пакета koschei.models для хранения моделей

// Импорт аннотации @Autowired из пакета org.springframework.beans.factory.annotation
// Импорт аннотации @Component из пакета org.springframework.stereotype
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// Аннотация @Component указывает, что этот класс является компонентом, управляемым Spring
@Component
public class Wood3 {
    // Приватное поле для хранения экземпляра класса Rabbit4
    private Rabbit4 rabbit;

    // Конструктор класса Wood3, который принимает в качестве параметра объект класса Rabbit4
    // Аннотация @Autowired указывает на то, что зависимость будет автоматически внедрена Spring-контейнером
    @Autowired
    public Wood3(Rabbit4 rabbit) {
        this.rabbit = rabbit;
    }

    // Переопределение метода toString для представления объекта Wood3 в виде строки
    @Override
    public String toString() {
        return ", на дереве заяц " + rabbit.toString();
    }
}
