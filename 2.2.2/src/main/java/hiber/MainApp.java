package hiber;

import hiber.HibernateUtil.HibernateUtil;
import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Екатерина", "Зотова", "ek12@mail.ru");
      Car car1 = new Car("KIA RIO", 6789);
      user1.setCar(car1);
      userService.add(user1);

      User user2 = new User("Павел", "Прохоров", "puv0@mail.ru");
      Car car2 = new Car("Ford Focus", 8796);
      user2.setCar(car2);
      userService.add(user2);

      User user3 = new User("Роман", "Лордов", "lord93@mail.ru");
      Car car3 = new Car("Lada Kalina", 9013);
      user3.setCar(car3);
      userService.add(user3);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         if (user.getCar() != null) {
            System.out.println("Car Model = " + user.getCar().getModel());
            System.out.println("Car Series = " + user.getCar().getSeries());
         }
         System.out.println();
      }

      context.close();
      HibernateUtil.shutdown();
   }
}
