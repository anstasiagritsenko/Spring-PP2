package web.config; // Объявление пакета

import com.mchange.v2.c3p0.ComboPooledDataSource; // Импорт класса ComboPooledDataSource из пакета com.mchange.v2.c3p0
import org.springframework.context.annotation.*; // Импорт аннотаций из пакета org.springframework.context.annotation
import org.springframework.core.env.Environment; // Импорт класса Environment из пакета org.springframework.core.env
import org.springframework.orm.jpa.JpaTransactionManager; // Импорт класса JpaTransactionManager из пакета org.springframework.orm.jpa
import org.springframework.orm.jpa.JpaVendorAdapter; // Импорт класса JpaVendorAdapter из пакета org.springframework.orm.jpa
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean; // Импорт класса LocalContainerEntityManagerFactoryBean из пакета org.springframework.orm.jpa
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter; // Импорт класса HibernateJpaVendorAdapter из пакета org.springframework.orm.jpa.vendor
import org.springframework.transaction.PlatformTransactionManager; // Импорт интерфейса PlatformTransactionManager из пакета org.springframework.transaction
import org.springframework.transaction.annotation.EnableTransactionManagement; // Импорт аннотации EnableTransactionManagement из пакета org.springframework.transaction.annotation
import org.springframework.context.annotation.Configuration; // Импорт аннотации Configuration из пакета org.springframework.context.annotation
import org.springframework.context.annotation.PropertySource; // Импорт аннотации PropertySource из пакета org.springframework.context.annotation
import javax.persistence.EntityManagerFactory; // Импорт интерфейса EntityManagerFactory из пакета javax.persistence
import javax.sql.DataSource; // Импорт интерфейса DataSource из пакета javax.sql
import java.beans.PropertyVetoException; // Импорт класса PropertyVetoException из пакета java.beans
import java.util.Properties; // Импорт класса Properties из пакета java.util

@Configuration // Объявление класса как конфигурационного
@PropertySource("classpath:db.properties") // Указание источника свойств
@EnableAspectJAutoProxy // Включение поддержки AspectJ для создания прокси-объектов
@EnableTransactionManagement // Включение управления транзакциями
@ComponentScan("web.service") // Автоматическое сканирование компонентов сервиса
@ComponentScan("web.dao") // Автоматическое сканирование компонентов доступа к данным
public class AppConfig { // Объявление класса AppConfig

    private final Environment env; // Объявление переменной env типа Environment

    public AppConfig(Environment env) { // Объявление конструктора с параметром env типа Environment
        this.env = env; // Присвоение значения переменной env
    }

    @Bean // Объявление бина
    public DataSource dataSource() throws PropertyVetoException { // Метод для создания и настройки источника данных
        ComboPooledDataSource dataSource = new ComboPooledDataSource(); // Создание объекта ComboPooledDataSource
        dataSource.setDriverClass(env.getProperty("db.driver")); // Установка свойства driverClass
        dataSource.setJdbcUrl(env.getProperty("db.url")); // Установка свойства jdbcUrl
        dataSource.setUser(env.getProperty("db.username")); // Установка свойства user
        dataSource.setPassword(env.getProperty("db.password")); // Установка свойства password
        return dataSource; // Возврат источника данных
    }

    @Bean // Объявление бина
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws PropertyVetoException { // Метод для создания фабрики EntityManager
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter(); // Создание объекта HibernateJpaVendorAdapter
        vendorAdapter.setGenerateDdl(true); // Установка свойства generateDdl

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean(); // Создание объекта LocalContainerEntityManagerFactoryBean
        em.setDataSource(dataSource()); // Установка источника данных
        em.setPackagesToScan("web.model"); // Установка пакета для сканирования
        em.setJpaVendorAdapter(vendorAdapter); // Установка адаптера JPA

        Properties hibernateProperties = new Properties(); // Создание объекта Properties
        hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect")); // Установка свойства hibernate.dialect
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto")); // Установка свойства hibernate.hbm2ddl.auto
        hibernateProperties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql")); // Установка свойства hibernate.show_sql

        em.setJpaProperties(hibernateProperties); // Установка свойств Hibernate

        return em; // Возврат фабрики EntityManager
    }

    @Bean // Объявление бина
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) { // Метод для создания менеджера транзакций
        JpaTransactionManager transactionManager = new JpaTransactionManager(); // Создание объекта JpaTransactionManager
        transactionManager.setEntityManagerFactory(emf); // Установка фабрики EntityManager
        return transactionManager; // Возврат менеджера транзакций
    }
}
