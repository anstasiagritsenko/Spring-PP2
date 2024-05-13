package koschei.models;
// Определение пакета koschei.models для хранения моделей

// Импорт аннотации @Component из пакета org.springframework.stereotype
import org.springframework.stereotype.Component;

// Аннотация @Component указывает, что этот класс является компонентом, управляемым Spring
@Component
public class Needle7 {
    // Приватное поле для хранения экземпляра класса Deth8
    private final Deth8 deth;

    // Конструктор класса Needle7 с параметром deth, автоматически связывается Spring-контейнером
    public Needle7(Deth8 deth) {
        this.deth = deth;
    }

    // Переопределение метода toString для представления объекта Needle7 в виде строки
    @Override
    public String toString() {
        return ", смерть Кощея на игле :( " + deth.toString();
    }
}
