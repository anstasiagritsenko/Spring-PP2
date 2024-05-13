package web.config; // Объявление пакета

import org.springframework.context.ApplicationContext; // Импорт класса ApplicationContext
import org.springframework.context.annotation.Bean; // Импорт аннотации Bean
import org.springframework.context.annotation.ComponentScan; // Импорт аннотации ComponentScan
import org.springframework.context.annotation.Configuration; // Импорт аннотации Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc; // Импорт аннотации EnableWebMvc
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry; // Импорт класса ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry; // Импорт класса ViewResolverRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer; // Импорт интерфейса WebMvcConfigurer
import org.thymeleaf.spring5.SpringTemplateEngine; // Импорт класса SpringTemplateEngine
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver; // Импорт класса SpringResourceTemplateResolver
import org.thymeleaf.spring5.view.ThymeleafViewResolver; // Импорт класса ThymeleafViewResolver

@Configuration // Аннотация, обозначающая класс как конфигурацию Spring
@EnableWebMvc // Включение поддержки MVC
@ComponentScan(basePackages = {"web"}) // Указание базового пакета для автоматического сканирования компонентов Spring
public class MvcConfig implements WebMvcConfigurer { // Объявление класса MvcConfig, реализующего интерфейс WebMvcConfigurer

    private final ApplicationContext applicationContext; // Объявление переменной applicationContext типа ApplicationContext

    public MvcConfig(ApplicationContext applicationContext) { // Конструктор класса MvcConfig с параметром applicationContext
        this.applicationContext = applicationContext; // Присвоение значения переменной applicationContext
    }

    @Override // Аннотация, указывающая на переопределение метода родительского класса
    public void addResourceHandlers(ResourceHandlerRegistry registry) { // Метод для настройки обработки статических ресурсов
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/"); // Регистрация обработчика для директории с JavaScript файлами
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/"); // Регистрация обработчика для директории с CSS файлами
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/"); // Регистрация обработчика для остальных статических ресурсов
    }

    @Override // Аннотация, указывающая на переопределение метода родительского класса
    public void configureViewResolvers(ViewResolverRegistry registry) { // Метод для настройки резолвера представлений
        ThymeleafViewResolver resolver = new ThymeleafViewResolver(); // Создание объекта ThymeleafViewResolver
        resolver.setCharacterEncoding("UTF-8"); // Установка кодировки символов
        resolver.setTemplateEngine(templateEngine()); // Установка движка шаблонов Thymeleaf
        registry.viewResolver(resolver); // Регистрация резолвера представлений
    }

    @Bean // Аннотация, указывающая на то, что метод возвращает экземпляр бина Spring
    public SpringTemplateEngine templateEngine() { // Метод для создания шаблонного движка
        SpringTemplateEngine templateEngine = new SpringTemplateEngine(); // Создание объекта SpringTemplateEngine
        templateEngine.setTemplateResolver(templateResolver()); // Установка резолвера шаблонов
        templateEngine.setEnableSpringELCompiler(true); // Включение компиляции Spring EL
        return templateEngine; // Возвращение объекта SpringTemplateEngine
    }

    @Bean // Аннотация, указывающая на то, что метод возвращает экземпляр бина Spring
    public SpringResourceTemplateResolver templateResolver() { // Метод для создания резолвера шаблонов
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver(); // Создание объекта SpringResourceTemplateResolver
        templateResolver.setApplicationContext(applicationContext); // Установка контекста приложения
        templateResolver.setPrefix("/WEB-INF/templates/"); // Установка префикса пути к шаблонам
        templateResolver.setSuffix(".html"); // Установка суффикса имен файлов шаблонов
        templateResolver.setTemplateMode("HTML"); // Установка режима шаблона
        templateResolver.setCacheable(false); // Отключение кэширования шаблонов
        return templateResolver; // Возвращение объекта SpringResourceTemplateResolver
    }
}
