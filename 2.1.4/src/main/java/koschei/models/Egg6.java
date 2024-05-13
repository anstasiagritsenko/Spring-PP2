package koschei.models;
// Определение пакета koschei.models для хранения моделей

// Импорт аннотации @Autowired из пакета org.springframework.beans.factory.annotation
import org.springframework.beans.factory.annotation.Autowired;
// Импорт аннотации @Component из пакета org.springframework.stereotype
import org.springframework.stereotype.Component;

// Аннотация @Component указывает, что этот класс является компонентом, управляемым Spring
@Component
public class Egg6 {
    // Приватное поле для хранения экземпляра класса Needle7
    private Needle7 needle;

    // Автоматическое внедрение зависимости Needle7 через метод установки
    @Autowired
    public void setNeedle(Needle7 needle) {
        this.needle = needle;
    }

    // Переопределение метода toString для представления объекта Egg6 в виде строки
    @Override
    public String toString() {
        return ", в яйце иголка" + needle.toString();
    }
}
