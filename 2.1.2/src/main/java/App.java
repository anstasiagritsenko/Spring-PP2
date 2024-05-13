// Импорт необходимых классов из пакета Spring Framework
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Объявление класса приложения
public class App {
    // Точка входа в приложение
    public static void main(String[] args) {
        // Создание контекста приложения с использованием конфигурации AppConfig
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);

        // Получение бина HelloWorld из контекста приложения по его имени
        HelloWorld bean1 = (HelloWorld) applicationContext.getBean("helloworld");
        // Получение другого экземпляра того же бина HelloWorld из контекста приложения
        HelloWorld bean2 = (HelloWorld) applicationContext.getBean("helloworld");

        // Получение бина Cat из контекста приложения по его имени
        Cat bean3 = (Cat) applicationContext.getBean("cat");
        // Получение другого экземпляра того же бина Cat из контекста приложения
        Cat bean4 = (Cat) applicationContext.getBean("cat");

        // Вывод сообщения бина HelloWorld в консоль
        System.out.println(bean1.getMessage());
        // Вывод сообщения бина HelloWorld в консоль
        System.out.println(bean2.getMessage());
        // Вывод сообщения бина Cat в консоль
        System.out.println(bean3.getMessage());
        // Вывод сообщения бина Cat в консоль
        System.out.println(bean4.getMessage());

        // Сравнение бинов по ссылке и вывод результата в консоль
        System.out.println("Сравнение HelloWorld: " + (bean1.equals(bean2)));
        // Сравнение бинов по ссылке и вывод результата в консоль
        System.out.println("Сравнение Cat: " + (bean3.equals(bean4)));
    }
}
