package koschei.models;
// Определение пакета koschei.models для хранения моделей

// Импорт аннотации @Autowired из пакета org.springframework.beans.factory.annotation
// Импорт аннотации @Qualifier из пакета org.springframework.beans.factory.annotation
// Импорт аннотации @Component из пакета org.springframework.stereotype
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// Аннотация @Component указывает, что этот класс является компонентом, управляемым Spring
@Component
public class Ocean1 {
    // Приватное поле для хранения экземпляра класса Island2
    private final Island2 island;

    // Конструктор класса Ocean1 с аргументом island, автоматически связывается Spring-контейнером
    // Аннотация @Autowired указывает на то, что аргумент конструктора будет автоматически внедрен Spring-контейнером
    // Аннотация @Qualifier используется для указания конкретного бина, который должен быть внедрен в качестве зависимости
    public Ocean1(@Qualifier("getIsland") Island2 island) {
        this.island = island;
    }

    // Переопределение метода toString для представления объекта Ocean1 в виде строки
    @Override
    public String toString() {
        return "на океане остров " + island.toString();
    }
}
