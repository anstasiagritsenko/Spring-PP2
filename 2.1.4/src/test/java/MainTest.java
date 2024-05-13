import koschei.KoscheiTheDeathless;
import koschei.config.AppConfig;
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
public class MainTest {

    @Autowired
    // Внедрение ApplicationContext для доступа к бинам приложения
    private ApplicationContext applicationContext;

    @Test
    // Метод, помеченный аннотацией @Test, будет выполняться как тестовый метод
    public void mainTest() {
        // Ожидаемая строка текста, содержащая правила смерти Кощея
        String text = "На свете есть океан , на океане остров , на острове дерево , на дереве заяц , в зайце утка , в утке яйцо , в яйце иголка , смерть Кощея на игле :(";

        // Получение бина KoscheiTheDeathless из контекста приложения
        KoscheiTheDeathless koscheiTheDeathless = applicationContext.getBean(KoscheiTheDeathless.class);
        // Получение строки с правилами смерти Кощея из бина
        String testText = koscheiTheDeathless.getRulesByDeth();

        // Проверка, содержит ли строка с правилами смерти Кощея ожидаемый текст
        // и имеет ли строка с правилами смерти Кощея длину, меньшую или равную длине ожидаемого текста
        if (!testText.contains(text) && testText.length() <= text.length()) {
            // Если условие не выполнено, генерируется исключение с сообщением о провале теста
            Assert.fail("Тест провален, не корректная связь бинов. Итоговая фраза не верна.");
        }
    }
}
