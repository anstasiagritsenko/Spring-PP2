package hiber.service;

import hiber.model.User; // Импортируем класс User из пакета hiber.model
import java.util.List; // Импортируем класс List из стандартной библиотеки Java

public interface UserService { // Объявляем интерфейс UserService

    // Метод для добавления пользователя в систему
    void add(User user);

    // Метод для получения списка всех пользователей
    List<User> listUsers();

    // Метод для получения пользователя по модели и серии его автомобиля
    User getUserByCarModelAndSeries(String model, int series);
}
