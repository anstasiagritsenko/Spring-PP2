package hiber.HibernateUtil;

import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component // Указываем, что класс HibernateUtil является компонентом Spring
public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory(); // Создаем фабрику сессий Hibernate

    // Метод для построения фабрики сессий Hibernate
    private static SessionFactory buildSessionFactory() {
        try {
            Properties properties = new Properties(); // Создаем объект для хранения свойств конфигурации Hibernate
            properties.put(Environment.DRIVER, "org.postgresql.Driver"); // Указываем драйвер базы данных PostgreSQL
            properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/postgres"); // Указываем URL для подключения к базе данных PostgreSQL
            properties.put(Environment.USER, "postgres"); // Указываем имя пользователя для подключения к базе данных PostgreSQL
            properties.put(Environment.PASS, "999"); // Указываем пароль для подключения к базе данных PostgreSQL
            properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL95Dialect"); // Указываем диалект PostgreSQL
            properties.put(Environment.HBM2DDL_AUTO, "create"); // Указываем стратегию автоматического создания схемы базы данных Hibernate

            // Создаем реестр сервисов Hibernate
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .applySettings(properties) // Применяем указанные свойства конфигурации
                    .build();

            // Создаем метаданные из реестра сервисов Hibernate, добавляем аннотированные классы
            return new MetadataSources(registry)
                    .addAnnotatedClass(hiber.model.User.class)
                    .addAnnotatedClass(hiber.model.Car.class)
                    .buildMetadata()
                    .buildSessionFactory(); // Строим фабрику сессий Hibernate

        } catch (Exception e) {
            e.printStackTrace(); // Выводим информацию об ошибке
            throw new ExceptionInInitializerError(e); // Выбрасываем исключение при инициализации
        }
    }

    // Метод для получения фабрики сессий Hibernate
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    // Метод для закрытия фабрики сессий Hibernate
    public static void shutdown() {
        getSessionFactory().close(); // Закрываем фабрику сессий Hibernate
    }
}
