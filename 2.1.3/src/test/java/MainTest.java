// Импорт необходимых классов из пакетов
import app.config.AppConfig;
import app.model.AnimalsCage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// Аннотация для запуска теста с помощью SpringJUnit4ClassRunner
@RunWith(SpringJUnit4ClassRunner.class)
// Аннотация для указания конфигурации Spring-приложения
@ContextConfiguration(classes = AppConfig.class)
// Объявление класса теста
public class MainTest {

    // Внедрение зависимости ApplicationContext для доступа к бинам приложения
    @Autowired
    private ApplicationContext applicationContext;

    // Метод теста
    @Test
    public void mainTest() {
        // Инициализация переменной для хранения времени
        long time = 0;
        // Цикл для получения бина и проверки времени
        for (int i = 0; i < 5; i++) {
            // Получение бина типа AnimalsCage из контекста приложения
            AnimalsCage bean = applicationContext.getBean(AnimalsCage.class);
            // Проверка, если это первая итерация, то сохранить текущее время
            if (i == 0) {
                time = bean.getTimer().getTime();
                continue;
            }
            // Проверка времени выполнения метода getTimer() для бина AnimalsCage
            // Сравнение времени выполнения с сохраненным временем
            Assert.assertEquals("Тест провален, не корректная реализация бинов.", time, bean.getTimer().getTime().longValue());
            // Вывод времени (для отладки)
            System.out.println(time);
        }
    }
}
