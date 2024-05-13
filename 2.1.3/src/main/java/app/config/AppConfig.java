package app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// Аннотация @Configuration говорит Spring, что этот класс является конфигурационным классом.
@ComponentScan(basePackages = "app")
// Аннотация @ComponentScan указывает Spring на то, что нужно сканировать компоненты (бины) в пакете "app".
public class AppConfig {
    // Этот класс содержит только аннотации и не имеет дополнительной логики.
    // Он используется для настройки контекста приложения и определения местоположения компонентов.
}
