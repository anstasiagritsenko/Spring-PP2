package app;

import app.config.AppConfig;
import app.model.AnimalsCage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        // Создание контекста приложения на основе конфигурационного класса AppConfig
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);

        // Цикл для создания и использования бина AnimalsCage из контекста приложения
        for (int i = 0; i < 5; i++) {
            // Получение бина AnimalsCage из контекста приложения
            AnimalsCage bean = applicationContext.getBean(AnimalsCage.class);
            // Вызов метода whatAnimalSay() для бина AnimalsCage
            bean.whatAnimalSay();
        }
    }

}
