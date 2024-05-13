package hiber.dao;

import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import hiber.HibernateUtil.HibernateUtil;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository // Указываем, что класс является компонентом Spring и предназначен для доступа к данным (DAO)
public class UserDaoImp implements UserDao {

   @Autowired // Аннотация, указывающая Spring'у на необходимость внедрения зависимости
   private SessionFactory sessionFactory; // Фабрика сессий Hibernate

   // Метод для добавления пользователя в базу данных
   @Override
   public void add(User user) {
      Session session = sessionFactory.getCurrentSession(); // Получаем текущую сессию Hibernate
      session.save(user); // Сохраняем пользователя в базе данных
   }

   // Метод для получения списка всех пользователей из базы данных
   @Override
   public List<User> listUsers() {
      Session session = sessionFactory.getCurrentSession(); // Получаем текущую сессию Hibernate
      TypedQuery<User> query = session.createQuery("from User", User.class); // Создаем запрос на получение всех пользователей
      return query.getResultList(); // Возвращаем список пользователей
   }

   // Метод для получения пользователя по модели и серии его автомобиля
   @Override
   public User getUserByCarModelAndSeries(String model, int series) {
      Session session = sessionFactory.getCurrentSession(); // Получаем текущую сессию Hibernate
      TypedQuery<User> query = session.createQuery("select u from User u where u.car.model = :model and u.car.series = :series", User.class); // Создаем запрос на получение пользователя по модели и серии его автомобиля
      query.setParameter("model", model); // Устанавливаем параметр модели автомобиля
      query.setParameter("series", series); // Устанавливаем параметр серии автомобиля
      List<User> resultList = query.getResultList(); // Получаем результат запроса
      return resultList.isEmpty() ? null : resultList.get(0); // Возвращаем первого пользователя из списка или null, если список пуст
   }
}
