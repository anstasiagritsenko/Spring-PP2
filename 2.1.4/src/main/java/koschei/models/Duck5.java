package koschei.models;// Определение пакета koschei.models для хранения моделей

// Импорт аннотации @Autowired из пакета org.springframework.beans.factory.annotation
import org.springframework.beans.factory.annotation.Autowired;
// Импорт аннотации @Component из пакета org.springframework.stereotype
import org.springframework.stereotype.Component;

// Аннотация @Component указывает, что этот класс является компонентом, управляемым Spring
@Component
public class Duck5 {
    // Приватное поле для хранения экземпляра класса Egg6
    private Egg6 egg;

    // Автоматическое внедрение зависимости Egg6 через метод установки
    @Autowired
    public void setEgg(Egg6 egg) {
        this.egg = egg;
    }

    // Переопределение метода toString для представления объекта Duck5 в виде строки
    @Override
    public String toString() {
        return ", в утке яйцо " + egg.toString();
    }
}
