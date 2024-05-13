package hiber.config;

import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration // Указываем, что класс является конфигурацией Spring
@PropertySource("classpath:db.properties") // Указываем файл с настройками базы данных
@EnableTransactionManagement // Включаем управление транзакциями
@ComponentScan(value = "hiber") // Сканирование пакета hiber для компонентов Spring
public class AppConfig {

   @Autowired // Аннотация, указывающая Spring'у на необходимость внедрения зависимости
   private Environment env; // Объект для работы с переменными окружения

   // Метод для создания и конфигурации источника данных (DataSource)
   @Bean
   public DataSource getDataSource() {
      DriverManagerDataSource dataSource = new DriverManagerDataSource(); // Создаем источник данных
      dataSource.setDriverClassName(env.getProperty("db.driver")); // Устанавливаем драйвер базы данных
      dataSource.setUrl(env.getProperty("db.url")); // Устанавливаем URL для подключения к базе данных
      dataSource.setUsername(env.getProperty("db.username")); // Устанавливаем имя пользователя для подключения к базе данных
      dataSource.setPassword(env.getProperty("db.password")); // Устанавливаем пароль для подключения к базе данных
      return dataSource; // Возвращаем созданный источник данных
   }

   // Метод для создания и конфигурации фабрики сессий Hibernate
   @Bean
   public LocalSessionFactoryBean getSessionFactory() {
      LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean(); // Создаем фабрику сессий Hibernate
      factoryBean.setDataSource(getDataSource()); // Устанавливаем источник данных для фабрики сессий

      Properties props=new Properties(); // Создаем объект для хранения свойств конфигурации Hibernate
      props.put("hibernate.show_sql", env.getProperty("hibernate.show_sql")); // Устанавливаем свойство show_sql
      props.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto")); // Устанавливаем свойство hbm2ddl.auto

      factoryBean.setHibernateProperties(props); // Устанавливаем свойства конфигурации для фабрики сессий
      factoryBean.setAnnotatedClasses(User.class, Car.class); // Устанавливаем классы-сущности для маппинга
      return factoryBean; // Возвращаем созданную фабрику сессий
   }

   // Метод для создания и конфигурации менеджера транзакций Hibernate
   @Bean
   public HibernateTransactionManager getTransactionManager() {
      HibernateTransactionManager transactionManager = new HibernateTransactionManager(); // Создаем менеджер транзакций Hibernate
      transactionManager.setSessionFactory(getSessionFactory().getObject()); // Устанавливаем фабрику сессий для менеджера транзакций
      return transactionManager; // Возвращаем созданный менеджер транзакций
   }
}
