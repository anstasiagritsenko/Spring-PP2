package hiber; // Объявление пакета

import hiber.HibernateUtil.HibernateUtil; // Импорт класса HibernateUtil из пакета HibernateUtil
import hiber.config.AppConfig; // Импорт класса AppConfig из пакета config
import hiber.model.Car; // Импорт класса Car из пакета model
import hiber.model.User; // Импорт класса User из пакета model
import hiber.service.UserService; // Импорт класса UserService из пакета service
import org.springframework.context.annotation.AnnotationConfigApplicationContext; // Импорт класса AnnotationConfigApplicationContext из пакета org.springframework.context.annotation

import java.sql.SQLException; // Импорт класса SQLException
import java.util.List; // Импорт интерфейса List

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = // Создание контекста приложения с помощью AppConfig
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class); // Получение бина UserService из контекста

      User user1 = new User("Irina", "Zurova", "Zurova@mail.ru"); // Создание пользователя user1
      Car car1 = new Car("Haval", 5687); // Создание машины car1
      user1.setCar(car1); // Привязка машины к пользователю
      userService.add(user1); // Добавление пользователя в базу данных

      User user2 = new User("Petr", "Nakirov", "Petr444@mail.ru"); // Создание пользователя user2
      Car car2 = new Car("Ford Focus", 3625); // Создание машины car2
      user2.setCar(car2); // Привязка машины к пользователю
      userService.add(user2); // Добавление пользователя в базу данных

      User user3 = new User("Elena", "Romova", "Rom7@mail.ru"); // Создание пользователя user3
      Car car3 = new Car("Kia Rio", 7874); // Создание машины car3
      user3.setCar(car3); // Привязка машины к пользователю
      userService.add(user3); // Добавление пользователя в базу данных

      List<User> users = userService.listUsers(); // Получение списка пользователей из базы данных
      for (User user : users) { // Перебор всех пользователей
         System.out.println("Id: " + user.getId() + ", " + // Вывод Id пользователя
                 "Имя: " + user.getFirstName() + ", " + // Вывод имени пользователя
                 "Фамилия: " + user.getLastName() + ", " + // Вывод фамилии пользователя
                 "Email: " + user.getEmail()); // Вывод email пользователя
         if (user.getCar() != null) { // Проверка наличия машины у пользователя
            System.out.println("Модель машины: " + user.getCar().getModel() + ", " + // Вывод модели машины пользователя
                    "Серия машины: " + user.getCar().getSeries()); // Вывод серии машины пользователя
         }
         System.out.println(); // Пустая строка для форматирования вывода
      }

      context.close(); // Закрытие контекста
      HibernateUtil.shutdown(); // Выключение Hibernate
   }
}
