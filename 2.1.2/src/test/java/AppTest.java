import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
// Аннотация @RunWith указывает JUnit на использование SpringJUnit4ClassRunner для выполнения теста.
@ContextConfiguration(classes = AppConfig.class)
// Аннотация @ContextConfiguration указывает на конфигурационный класс приложения, который будет использоваться во время тестирования.
public class AppTest {

    @Autowired
    // Внедрение ApplicationContext для доступа к бинам приложения
    private ApplicationContext applicationContext;

    @Test
    // Метод, помеченный аннотацией @Test, будет выполняться как тестовый метод
    public void mainTest() {
        // Получение двух экземпляров бина HelloWorld из контекста приложения
        HelloWorld tree = applicationContext.getBean(HelloWorld.class);
        HelloWorld leaf = applicationContext.getBean(HelloWorld.class);

        // Получение двух экземпляров бина Cat из контекста приложения
        Cat one = applicationContext.getBean(Cat.class);
        Cat two = applicationContext.getBean(Cat.class);

        // Проверка, что экземпляры бина HelloWorld совпадают (т.е. это один и тот же объект)
        Assert.assertSame("Тест провален, не корректная настройка бина HelloWorld", tree, leaf);
        // Проверка, что экземпляры бина Cat не совпадают (т.е. это разные объекты)
        Assert.assertNotSame("Тест провален, не корректная настройка бина Cat", one, two);
    }
}
