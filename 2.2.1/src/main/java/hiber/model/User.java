package hiber.model;

import javax.persistence.*;

@Entity // Аннотация, указывающая, что класс User является сущностью Hibernate
@Table(name = "users") // Указываем имя таблицы, с которой будет связана сущность User
public class User {

    @Id // Указываем, что поле id является первичным ключом
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Указываем стратегию генерации значений для поля id
    private Long id; // Поле для хранения идентификатора пользователя

    @Column(name = "name") // Указываем имя столбца в таблице, соответствующего полю firstName
    private String firstName; // Поле для хранения имени пользователя

    @Column(name = "last_name") // Указываем имя столбца в таблице, соответствующего полю lastName
    private String lastName; // Поле для хранения фамилии пользователя

    @Column(name = "email") // Указываем имя столбца в таблице, соответствующего полю email
    private String email; // Поле для хранения электронной почты пользователя

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER) // Устанавливаем отношение "один к одному" между таблицами User и Car
    @JoinColumn(name = "car_id") // Указываем имя столбца в таблице, который будет использоваться для связи с таблицей Car
    private Car car; // Поле для хранения автомобиля, которым владеет данный пользователь

    public User() {} // Конструктор без параметров

    public User(String firstName, String lastName, String email) { // Конструктор с параметрами имени, фамилии и электронной почты пользователя
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Геттеры и сеттеры для приватных полей класса
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
