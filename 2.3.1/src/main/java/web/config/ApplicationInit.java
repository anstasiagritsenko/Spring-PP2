package web.config; // Объявление пакета

import javax.servlet.FilterRegistration; // Импорт класса FilterRegistration
import javax.servlet.ServletContext; // Импорт класса ServletContext
import javax.servlet.ServletException; // Импорт класса ServletException
import org.springframework.web.filter.CharacterEncodingFilter; // Импорт класса CharacterEncodingFilter
import org.springframework.web.filter.HiddenHttpMethodFilter; // Импорт класса HiddenHttpMethodFilter
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer; // Импорт класса AbstractAnnotationConfigDispatcherServletInitializer


public class ApplicationInit extends AbstractAnnotationConfigDispatcherServletInitializer { // Объявление класса ApplicationInit, расширяющего AbstractAnnotationConfigDispatcherServletInitializer

    public ApplicationInit() { // Объявление конструктора по умолчанию
        super(); // Вызов конструктора суперкласса
    }

    @Override // Переопределение метода родительского класса
    protected Class<?>[] getRootConfigClasses() { // Метод для получения классов конфигурации корневого контекста
        return new Class[] {AppConfig.class}; // Возвращение массива классов конфигурации
    }

    @Override // Переопределение метода родительского класса
    protected Class<?>[] getServletConfigClasses() { // Метод для получения классов конфигурации сервлета
        return new Class[] {MvcConfig.class}; // Возвращение массива классов конфигурации
    }

    @Override // Переопределение метода родительского класса
    protected String[] getServletMappings() { // Метод для получения маппингов сервлета
        return new String[] {"/"}; // Возвращение массива маппингов
    }

    @Override // Переопределение метода родительского класса
    public void onStartup(ServletContext servletContext) throws ServletException { // Метод для настройки приложения при старте
        super.onStartup(servletContext); // Вызов метода суперкласса

        FilterRegistration.Dynamic filterRegistration = servletContext.addFilter("characterEncodingFilter", // Регистрация фильтра кодировки символов
                new CharacterEncodingFilter("UTF-8", true, true)); // Создание объекта CharacterEncodingFilter
        filterRegistration.addMappingForUrlPatterns(null, false, "/*"); // Добавление маппинга для фильтра

        filterRegistration = servletContext.addFilter("hiddenHttpMethodFilter", new HiddenHttpMethodFilter()); // Регистрация фильтра скрытых методов HTTP
        filterRegistration.addMappingForUrlPatterns(null, false, "/*"); // Добавление маппинга для фильтра скрытых методов HTTP
    }
}
