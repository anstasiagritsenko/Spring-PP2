package hiber.dao;

import hiber.model.User;

import java.util.List;

// Интерфейс для доступа к данным пользователей
public interface UserDao {
   // Метод для добавления пользователя в базу данных
   void add(User user);

   // Метод для получения списка всех пользователей из базы данных
   List<User> listUsers();

   // Метод для получения пользователя по модели и серии его автомобиля
   User getUserByCarModelAndSeries(String model, int series);
}
