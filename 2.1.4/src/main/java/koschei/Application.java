package koschei;
// Импорт классов из пакетов koschei.models, org.springframework.context.annotation и koschei.config
import koschei.models.Ocean1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import koschei.config.AppConfig;

// Класс приложения
public class Application {

    // Основной метод, который будет вызван при запуске приложения
    public static void main(String[] args) {
        // Создание контекста приложения на основе конфигурационного класса AppConfig
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Получение бина Ocean1 из контекста приложения
        Ocean1 ocean1 = context.getBean(Ocean1.class);

        // Вывод строки, представляющей объект ocean1
        System.out.println(ocean1.toString());

        // Закрытие контекста приложения
        context.close();
    }
}
