// Определяем пакет, в котором находится класс UserServiceImp
package hiber.service;

// Импортируем класс UserDao из пакета hiber.dao
import hiber.dao.UserDao;
// Импортируем класс User из пакета hiber.model
import hiber.model.User;
// Импортируем аннотации и классы из пакета Spring Framework
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// Импортируем класс List из стандартной библиотеки Java
import java.util.List;

// Аннотация Service указывает, что этот класс является сервисом Spring
@Service
// Определение класса UserServiceImp, который реализует интерфейс UserService
public class UserServiceImp implements UserService {

   // Аннотация Autowired указывает Spring внедрить экземпляр класса UserDao в этот класс
   @Autowired
   private UserDao userDao;

   // Аннотация Transactional указывает Spring, что этот метод должен выполняться в транзакционном контексте
   @Transactional
   @Override
   // Метод для добавления пользователя в базу данных
   public void add(User user) {
      userDao.add(user);
   }

   // Аннотация Transactional(readOnly = true) указывает Spring, что этот метод должен выполняться в транзакционном контексте только для чтения
   @Transactional(readOnly = true)
   @Override
   // Метод для получения списка всех пользователей из базы данных
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   // Аннотация Transactional(readOnly = true) указывает Spring, что этот метод должен выполняться в транзакционном контексте только для чтения
   @Transactional(readOnly = true)
   @Override
   // Метод для получения пользователя по модели и серии его автомобиля из базы данных
   public User getUserByCarModelAndSeries(String model, int series) {
      return userDao.getUserByCarModelAndSeries(model, series);
   }
}
