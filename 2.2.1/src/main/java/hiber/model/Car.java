package hiber.model;

import javax.persistence.*;

@Entity // Аннотация, указывающая, что класс Car является сущностью Hibernate
public class Car {
    @Id // Указываем, что поле id является первичным ключом
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Указываем стратегию генерации значений для поля id
    private Long id; // Поле для хранения идентификатора автомобиля

    private String model; // Поле для хранения модели автомобиля

    private int series; // Поле для хранения серии автомобиля

    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL, fetch = FetchType.LAZY) // Устанавливаем отношение "один к одному" между таблицами Car и User
    private User user; // Поле для хранения пользователя, который владеет данным автомобилем

    public Car() {} // Конструктор без параметров

    public Car(String model, int series) { // Конструктор с параметрами модели и серии автомобиля
        this.model = model;
        this.series = series;
    }

    // Геттеры и сеттеры для приватных полей класса
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
