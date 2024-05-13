package koschei.config;// Определение пакета koschei.config для хранения конфигурационных классов

// Импорт классов из пакетов koschei.models и org.springframework.context.annotation
import koschei.models.Island2;
import koschei.models.Wood3;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// Определение конфигурационного класса AppConfig
@Configuration
// Включение автоматического сканирования компонентов в пакете koschei и его подпакетах
@ComponentScan(basePackages = "koschei")
public class AppConfig {

    // Определение бина с именем "getIsland"
    // Этот бин создает экземпляр класса Island2 с использованием экземпляра класса Wood3
    @Bean
    public static Island2 getIsland(Wood3 wood) {
        return new Island2(wood);
    }
}
